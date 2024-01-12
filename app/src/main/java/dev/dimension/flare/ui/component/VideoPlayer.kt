package dev.dimension.flare.ui.component

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.PlayerView
import dev.dimension.flare.common.PlayerPoll
import org.koin.compose.koinInject

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(
    uri: String,
    previewUri: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    muted: Boolean = false,
    showControls: Boolean = false,
    keepScreenOn: Boolean = false,
    poll: PlayerPoll = koinInject(),
) {
    var isLoaded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        AndroidView(
            modifier =
                Modifier
                    .matchParentSize(),
            factory = { context ->
                val exoPlayer = poll.get(uri)
                exoPlayer.prepare()
                exoPlayer.playWhenReady = true
                exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
                exoPlayer.volume = if (muted) 0f else 1f
                exoPlayer.addListener(
                    object : Player.Listener {
                        override fun onIsLoadingChanged(isLoading: Boolean) {
                            isLoaded = !isLoading || exoPlayer.duration > 0
                        }
                    },
                )
                PlayerView(context).apply {
                    useController = showControls
                    player = exoPlayer
                    layoutParams =
                        FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                        )
                    this.keepScreenOn = keepScreenOn
                }
            },
            onRelease = {
                it.player?.release()
                poll.remove(uri)
            },
        )
        if (!isLoaded && previewUri != null) {
            NetworkImage(
                model = previewUri,
                contentDescription = contentDescription,
                modifier = Modifier.matchParentSize(),
            )
            LinearProgressIndicator(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
            )
        }
    }
}
