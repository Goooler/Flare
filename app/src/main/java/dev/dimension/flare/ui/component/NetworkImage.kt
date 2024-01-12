package dev.dimension.flare.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import dev.dimension.flare.ui.component.placeholder.placeholder

@Composable
fun NetworkImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    placeholder: @Composable BoxScope.() -> Unit = {
        Box(
            modifier =
                Modifier
                    .matchParentSize()
                    .placeholder(true),
        )
    },
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
) {
    val painter = rememberAsyncImagePainter(model = model, filterQuality = filterQuality)
    Box(modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            modifier = Modifier.matchParentSize(),
        )

        AnimatedVisibility(
            visible =
                when (painter.state) {
                    is AsyncImagePainter.State.Empty,
                    is AsyncImagePainter.State.Success,
                    -> false

                    is AsyncImagePainter.State.Loading,
                    is AsyncImagePainter.State.Error,
                    -> true
                },
        ) {
            placeholder()
        }
    }
}

@Composable
fun EmojiImage(
    uri: Any?,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val painter =
        rememberAsyncImagePainter(
            model =
                remember(uri, context) {
                    ImageRequest.Builder(context)
                        .data(uri)
                        .size(Size.ORIGINAL)
                        .build()
                },
        )
    if (painter.state is AsyncImagePainter.State.Success) {
        val aspectRatio =
            remember(painter.intrinsicSize) {
                val size = painter.intrinsicSize
                (size.width / size.height).takeUnless { it.isNaN() } ?: 1f
            }
        Image(
            painter = painter,
            contentDescription = null,
            modifier =
                modifier
                    .aspectRatio(aspectRatio)
                    .fillMaxSize(),
        )
    }
}
