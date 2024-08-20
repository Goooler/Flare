package dev.dimension.flare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dev.dimension.flare.ui.AppContainer
import dev.dimension.flare.ui.theme.EdgeToEdge

class MainActivity : ComponentActivity() {
    private var keepSplashOnScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { keepSplashOnScreen }
        super.onCreate(savedInstanceState)
        android.webkit.WebView.setWebContentsDebuggingEnabled(true)
        setContent {
            EdgeToEdge()

            AppContainer(
                afterInit = {
                    keepSplashOnScreen = false
                },
            )
        }
    }
}
