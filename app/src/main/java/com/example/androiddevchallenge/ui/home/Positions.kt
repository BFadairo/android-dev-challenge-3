package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Position
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.lang.String.format
import java.text.DecimalFormat
import java.text.NumberFormat

var positions = listOf<Position>(
    Position("ALK", "Alaska Air Group, Inc.", 7918f, -0.54f, R.drawable.ic_home_alk),
    Position("BA", "Boeing Co.", 1293f, 4.18f, R.drawable.ic_home_ba),
    Position("DAL", "Delta Airlines Inc.", 893.5f, -0.54f, R.drawable.ic_home_dal),
    Position("EXPE", "Expedia Group Inc", 12301f, 2.51f, R.drawable.ic_home_exp),
    Position("EADSY", "Airbus SE", 12301f, 1.38f, R.drawable.ic_home_eadsy),
    Position("JBLU", "Jetblue Airways Corp", 8521f, 1.56f, R.drawable.ic_home_jblu),
    Position("MAR", "Marriot International Inc.", 521f, 2.75f, R.drawable.ic_home_mar),
    Position("CCL", "Carnival Corp", 5481f, 0.14f, R.drawable.ic_home_ccl),
    Position("RCL", "Royal Caribbean Cruises", 9184f, 1.69f, R.drawable.ic_home_rcl),
    Position("TRVL", "Travelocity Inc", 654f, 3.23f, R.drawable.ic_home_trvl)
)

@Composable
fun PositionsScreen() {
    Surface(modifier = Modifier.background(Color.White)) {
        PositionsList(positions = positions)
    }
}

@Composable
fun PositionContent() {

}

@Composable
fun PositionsList(positions: List<Position>) {
    LazyColumn {
        items(positions) { position ->
            PositionItem(position = position)
        }
    }
}

@Composable
fun PositionItem(position: Position){
    val image = painterResource(id = position.chart)
    val percentColor = if (position.percentChange < 0f) Color.Red; else Color.Green
//    val price = if (position.price % 1 != 0f) position.price; else position.price.toInt()
    val convertedPrice = if (position.price % 1 != 0f) DecimalFormat("#.###").format(position.price).toString(); else NumberFormat.getInstance().format(position.price.toDouble()).toString()
    val price = if (position.price % 1 != 0f) String.format("$%a", position.price); else String.format("{0:n0}", position.price)
    Divider(modifier = Modifier.height(2.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Column(
            Modifier
                .padding(start = 16.dp)
                .weight(.2f)) {
            Text(text = "$${convertedPrice}", style = MaterialTheme.typography.body1)
            Text(text = "${position.percentChange}%", style = MaterialTheme.typography.body1, color = percentColor)
        }
        Column( modifier = Modifier.weight(.5f)) {
            Text(text = position.ticker, style = MaterialTheme.typography.h3)
            Text(text = position.companyName, style = MaterialTheme.typography.body1)
        }
        Image(painter = image, contentDescription = "${position.ticker} Chart", modifier = Modifier.weight(.3f))
    }
}

@Preview(showBackground = true)
@Composable
fun PositionsListPreview() {
    MyTheme {
        PositionsList(positions = positions)
    }
}