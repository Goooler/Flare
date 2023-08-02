package dev.dimension.flare.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.CodepointTransformation
import androidx.compose.foundation.text2.input.TextEditFilter
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TextField2(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    filter: TextEditFilter? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    onTextLayout: Density.(TextLayoutResult) -> Unit = {},
    interactionSource: MutableInteractionSource? = null,
    cursorBrush: Brush = SolidColor(Color.Black),
    scrollState: ScrollState = rememberScrollState(),
    codepointTransformation: CodepointTransformation? = null,

    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    shape: Shape = TextFieldDefaults.shape,
    isError: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.colors()
) {
    BasicTextField2(
        state = state,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        filter = filter,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        lineLimits = lineLimits,
        onTextLayout = onTextLayout,
        interactionSource = interactionSource,
        cursorBrush = cursorBrush,
        scrollState = scrollState,
        codepointTransformation = codepointTransformation,
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = state.text.toString(),
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                placeholder = placeholder,
                label = label,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                prefix = prefix,
                suffix = suffix,
                supportingText = supportingText,
                shape = shape,
                singleLine = lineLimits == TextFieldLineLimits.SingleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = remember { MutableInteractionSource() },
                colors = colors
            )
        }
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextField2(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    filter: TextEditFilter? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    onTextLayout: Density.(TextLayoutResult) -> Unit = {},
    interactionSource: MutableInteractionSource? = null,
    cursorBrush: Brush = SolidColor(Color.Black),
    scrollState: ScrollState = rememberScrollState(),
    codepointTransformation: CodepointTransformation? = null,

    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors()
) {
    BasicTextField2(
        state = state,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        filter = filter,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        lineLimits = lineLimits,
        onTextLayout = onTextLayout,
        interactionSource = interactionSource,
        cursorBrush = cursorBrush,
        scrollState = scrollState,
        codepointTransformation = codepointTransformation,
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = state.text.toString(),
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                placeholder = placeholder,
                label = label,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                prefix = prefix,
                suffix = suffix,
                supportingText = supportingText,
                singleLine = lineLimits == TextFieldLineLimits.SingleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = remember { MutableInteractionSource() },
                colors = colors,
                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled,
                        isError,
                        interactionSource = remember { MutableInteractionSource() },
                        colors,
                        shape
                    )
                }
            )
        }
    )
}
