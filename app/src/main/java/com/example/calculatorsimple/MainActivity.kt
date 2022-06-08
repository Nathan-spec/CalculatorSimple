package com.example.calculatorsimple

import android.os.Bundle
import android.text.method.Touch
import android.view.RoundedCorner
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorsimple.ui.theme.CalculatorSimpleTheme
import com.example.calculatorsimple.ui.theme.*


class MainActivity : ComponentActivity() {

    val list = listOf<String>(
        "1", "2", "3", "4", "5"
    )

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorSimpleTheme {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxHeight(),
                    cells = GridCells.Fixed(4),
                    verticalArrangement = Arrangement.Bottom,
                    contentPadding = PaddingValues(8.dp),
                    content = {
                        items(list) { item ->
                            Press(
                                onClick = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        item,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }, value = item, color = when (item) {
                                    "5" -> greenDark
                                    else -> blueLight
                                }
                            )
                        }
                    })
            }
        }
    }
}

@Composable
fun Press(
    modifier: Modifier = Modifier.padding(8.dp),
    value: String = "",
    color: Color = blueLight,
    onClick: (value: String) -> Unit
) {

    Button(
        modifier = modifier.clip(RoundedCornerShape(100)),
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        onClick = { onClick.invoke(value) }) {
        Text(text = value, modifier = Modifier.padding(16.dp), fontSize = 32.sp)
    }

}

@Preview
@Composable
fun PressPreview() {
    Press(onClick = {})
}




