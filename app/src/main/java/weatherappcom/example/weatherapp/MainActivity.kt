package weatherappcom.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import weatherappcom.example.weatherapp.R
import weatherappcom.example.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
//
                ) {
                    WebDisplay()
                }
            }
        }
    }
}

@Composable
fun WebDisplay() {
    Column(Modifier.size(500.dp)) {
        WeatherAppTitle()
        Loco()
        Weather()
        WeatherSpecifics()
    }
}

@Composable
fun WeatherAppTitle() {
    val tealColor = colorResource(id = R.color.purple_700)
    Surface(modifier = Modifier.fillMaxWidth(), color = tealColor) {
        Text(
            text = stringResource(id = R.string.app_name),

        )
    }

}

@Composable
fun Loco() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = stringResource(id = R.string.loc),
        )
    }
}

@Composable
fun WeatherSpecifics(){
    Column(Modifier.fillMaxWidth().padding(start = 10.dp)) {
        Row(Modifier.fillMaxWidth()){
            Text(
                text = stringResource(R.string.low),

            )
            Text(
                text = "\u00B0",

            )

        }
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.high),
            )
            Text(
                text = "\u00B0",
            )


        }
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.humidity),

            )

        }
        Row(Modifier.fillMaxWidth()){
            Text(
                text = stringResource(R.string.pressure),

            )
        }
    }
}

@Composable
fun Weather() {

    val temp = stringResource(R.string.temperatue)
    val feels = stringResource(R.string.feels)


    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text(

                text = buildAnnotatedString {
                    append(temp)
                    withStyle(style = SpanStyle(fontSize = 65.sp)) {
                        append(" \u00B0")
                    } },

                fontSize = 65.sp
            )
            Text(
                text = feels,
                fontSize = 14.sp
            )

        }
        Image(
            painter = painterResource(id = R.drawable.weatherpic),
            contentDescription = "photo",
            modifier = Modifier
                .size(100.dp)
                .padding(end = 0.dp)
                .align(Alignment.CenterVertically),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    WeatherAppTheme {
        WebDisplay()
    }
}