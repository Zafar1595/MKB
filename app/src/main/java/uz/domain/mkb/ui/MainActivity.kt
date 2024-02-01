package uz.domain.mkb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.domain.mkb.ui.main.MainScreen
import uz.domain.mkb.ui.theme.MKBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MKBTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartApp()
                }
            }
        }
    }
}

@Composable
fun StartApp(modifier: Modifier = Modifier) {
    MainScreen()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MKBTheme(darkTheme = false) {
        StartApp()
    }
}