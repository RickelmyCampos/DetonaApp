package com.gilbersoncampos.detona.ui.comoponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gilbersoncampos.detona.ui.theme.DetonaTheme
import com.gilbersoncampos.detona.ui.theme.Pink

@Composable
fun BaseButton(
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    modifier: Modifier,
    color: ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable RowScope.() -> Unit = {}
) {

    Button(
        colors = color,
        enabled = enabled,
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        content()

    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    title: String = "",
    onClick: () -> Unit = {}
) {
    val color = ButtonDefaults.buttonColors(
        containerColor = Pink
    )
    BaseButton(color = color, onClick = onClick, modifier = modifier) {
        Text(text = title)
    }
}

@Preview
@Composable
fun ButtonPreview() {
    DetonaTheme {
        Column {
            PrimaryButton(title = "Login")


        }


    }
}