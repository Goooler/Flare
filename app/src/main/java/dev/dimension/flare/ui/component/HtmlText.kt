package dev.dimension.flare.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import moe.tlaster.ktml.dom.Comment
import moe.tlaster.ktml.dom.Doctype
import moe.tlaster.ktml.dom.Element
import moe.tlaster.ktml.dom.Node
import moe.tlaster.ktml.dom.Text

private const val ID_IMAGE = "image"

@Composable
fun HtmlText(
    element: Element,
    modifier: Modifier = Modifier,
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    maxLines: Int = Int.MAX_VALUE,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    textStyle: TextStyle = LocalTextStyle.current,
    linkStyle: TextStyle = textStyle.copy(MaterialTheme.colorScheme.primary),
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides layoutDirection,
    ) {
        ProvideTextStyle(value = textStyle) {
            RenderContent(
                modifier = modifier,
                element = element,
                maxLines = maxLines,
                textStyle = textStyle,
                linkStyle = linkStyle,
                color = color,
                fontSize = fontSize,
                fontStyle = fontStyle,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                letterSpacing = letterSpacing,
                textDecoration = textDecoration,
                textAlign = textAlign,
                lineHeight = lineHeight,
                overflow = overflow,
                softWrap = softWrap,
            )
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun RenderContent(
    element: Element,
    textStyle: TextStyle,
    linkStyle: TextStyle,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
) {
    val value =
        remember(element, textStyle, linkStyle) {
            buildContentAnnotatedString(
                element = element,
                textStyle = textStyle,
                linkStyle = linkStyle,
            )
        }
    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    if (value.text.isNotEmpty() && value.text.isNotBlank()) {
        Text(
            modifier = modifier,
            maxLines = maxLines,
            color = color,
            fontSize = fontSize,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            textAlign = textAlign,
            lineHeight = lineHeight,
            overflow = overflow,
            softWrap = softWrap,
            text = value,
            onTextLayout = {
                layoutResult.value = it
            },
            inlineContent =
                mapOf(
                    ID_IMAGE to
                        InlineTextContent(
                            Placeholder(
                                width = LocalTextStyle.current.fontSize,
                                height = LocalTextStyle.current.fontSize,
                                placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter,
                            ),
                        ) { target ->
                            EmojiImage(
                                uri = target,
                                modifier =
                                    Modifier
                                        .size(LocalTextStyle.current.fontSize.value.dp),
                            )
                        },
                ),
        )
    }
}

@ExperimentalUnitApi
fun buildContentAnnotatedString(
    element: Element,
    textStyle: TextStyle,
    linkStyle: TextStyle,
): AnnotatedString {
    val styleData =
        StyleData(
            textStyle = textStyle,
            linkStyle = linkStyle,
        )
    return buildAnnotatedString {
        element.children.forEach {
            renderNode(it, styleData)
        }
    }
}

data class StyleData(
    val textStyle: TextStyle,
    val linkStyle: TextStyle,
)

private fun AnnotatedString.Builder.renderNode(
    node: Node,
    styleData: StyleData,
) {
    when (node) {
        is Element -> {
            this.renderElement(node, styleData = styleData)
        }

        is Text -> {
            renderText(node.text, styleData.textStyle)
        }

        is Comment -> Unit
        is Doctype -> Unit
    }
}

private fun AnnotatedString.Builder.renderText(
    text: String,
    textStyle: TextStyle,
) {
    pushStyle(
        textStyle.toSpanStyle(),
    )
    append(text)
    pop()
}

private fun AnnotatedString.Builder.renderElement(
    element: Element,
    styleData: StyleData,
) {
    when (element.name.lowercase()) {
        "a" -> {
            renderLink(element, styleData)
        }

        "br" -> {
            appendLine()
        }

        "span", "p" -> {
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
        }

        "emoji" -> {
            val target = element.attributes["target"]
            if (!target.isNullOrEmpty()) {
                appendInlineContent(ID_IMAGE, target)
            }
        }

        "img" -> {
            val src = element.attributes["src"]
//            val alt = element.attributes["alt"]
            if (!src.isNullOrEmpty()) {
                appendInlineContent(ID_IMAGE, src)
            }
        }

        "strong" -> {
            pushStyle(
                styleData.textStyle.copy(fontWeight = FontWeight.Bold).toSpanStyle(),
            )
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
            pop()
        }

        "em" -> {
            pushStyle(
                styleData.textStyle.copy(fontStyle = FontStyle.Italic).toSpanStyle(),
            )
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
            pop()
        }

        "del", "s" -> {
            pushStyle(
                styleData.textStyle.copy(textDecoration = TextDecoration.LineThrough).toSpanStyle(),
            )
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
            pop()
        }

        "u" -> {
            pushStyle(
                styleData.textStyle.copy(textDecoration = TextDecoration.Underline).toSpanStyle(),
            )
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
            pop()
        }

        "small" -> {
            pushStyle(
                styleData.textStyle.copy(fontSize = styleData.textStyle.fontSize * 0.8).toSpanStyle(),
            )
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
            pop()
        }

        else -> {
            element.children.forEach {
                renderNode(node = it, styleData = styleData)
            }
        }
    }
}

private fun AnnotatedString.Builder.renderLink(
    element: Element,
    styleData: StyleData,
) {
    val href = element.attributes["href"]
    if (!href.isNullOrEmpty()) {
        withLink(LinkAnnotation.Url(href)) {
            element.children.forEach {
                renderNode(
                    node = it,
                    styleData = styleData.copy(textStyle = styleData.linkStyle),
                )
            }
        }
    }
}
