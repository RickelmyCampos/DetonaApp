package com.gilbersoncampos.detona.ui.comoponents

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gilbersoncampos.detona.ui.theme.DetonaTheme

@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    value: String="",
    label: String="",
    onValueChange: (String) -> Unit = {}
) {
    TextField(
        shape = RoundedCornerShape(10.dp) ,
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) })
//    BasicTextField(
//        value = "",
//        onValueChange = {},
//        decorationBox = { innerTextField ->
//
//            innerTextField()
//        })

}

@Preview(showBackground = true)
@Composable
private fun TextInputsPreview() {
    DetonaTheme {
        BaseTextField()
    }
}