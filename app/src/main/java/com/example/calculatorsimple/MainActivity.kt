package com.example.calculatorsimple

import android.app.Activity
import android.icu.util.ULocale.ROOT
import android.os.Bundle
import android.provider.ContactsContract
import android.text.method.Touch
import android.view.RoundedCorner
import android.widget.Button
import android.widget.Toast
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.NonNull
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.material.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.times
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.colorspace.Illuminant.C
import androidx.compose.ui.platform.ValueElement
import androidx.compose.ui.res.fontResource
import androidx.lifecycle.MutableLiveData
import org.w3c.dom.Text
import java.time.format.TextStyle
import java.util.Locale.ROOT
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : ComponentActivity() {

    // Defining Operations
    enum class OPS {
        DIV, MULT, SUB, ADD, RAISE, root
    }

    val operators = listOf("+", "-", "÷", "*", "^", ".")

    // Values of the buttons(in list form)
    val list = listOf<String>(
        //C should clear
        //d should delete
        "c", "√", "^", "÷",
        "7", "8", "9", "×",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "⌫", ".", "0", "="

    )

    //    val text = MutableLiveData("")
    // MutableStateOf() -> Holds the value, where Compose will automatically observe changes to the value
    // by -> Declaration of a property
    var text by mutableStateOf("")


    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorSimpleTheme {
                // Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                {
                    // Text scope
                    Text(
                        text = text ?: "",
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 110.dp)
                            .background(color = Color.White),
                        fontSize = 45.sp,

                        )
                }
                //Lazy Vertical Grid
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxHeight(),
                    cells = GridCells.Fixed(4),
                    verticalArrangement = Arrangement.Bottom,
                    contentPadding = PaddingValues(8.dp),
                    content = {
                        items(list) { item ->
                            Press(
                                onClick = {
                                    //Fetches text within the function Press
                                    text = when (it) {
                                        "c" -> {
                                            ""
                                        }
                                        "⌫" -> {
                                            text.dropLast(1)
                                        }
                                        "=" -> evaluate()
                                        "+", "-", "÷", "X", "^", "." -> addOperator(it)
                                        else -> {
                                            text.plus(it)
                                        }

                                    }
                                }, value = item,
                                color = when (item) {
                                    //Various colours of buttons
                                    "c" -> Red
                                    "√", "^", "÷", "×", "-", "+" -> lightGreen
                                    //Dark Green
                                    "=" -> greenDark
                                    //Jonquil
                                    "⌫" -> Jonquil
                                    // Blue Light
                                    else -> blueLight
                                }

                            )
                        }
                    })
            }
        }
    }

    // get string
    private fun addOperator(operator: String): String {

        val s = text
        // Get the last character
        val lastChar = s.lastOrNull() ?: return text //?: -> elvis operator


        if (operators.contains(lastChar.toString())) // If it contains the last character
            return text

        return text.plus(operator)

    }

    //Various functions for adding, subtracting, multiplication and division
    fun add(a: Int, b: Int) = a + b
    fun sub(a: Int, b: Int) = a - b
    fun mul(a: Int, b: Int) = a * b
    fun divide(a: Int, b: Int) = a / b
    fun raise(a: Double, b: Double ) = Math.pow(a.toDouble(), b.toDouble())
    fun root(a:Double) = Math.sqrt(a)


    private fun evaluate(): String {
        return when (text.getOperator()) {
            OPS.DIV -> {
                val numbers = text.split("÷").map { it.toFloat() }
                return numbers.first().div(numbers.last()).toString()
            }
            OPS.MULT -> {
                val numbers = text.split("×").map { it.toFloat() }
                return numbers.first().times(numbers.last()).toString()
            }
            OPS.SUB -> {
                val numbers = text.split("-").map { it.toFloat() }
                return numbers.first().minus(numbers.last()).toString()
            }
            OPS.ADD -> {
                val numbers = text.split("+").map { it.toFloat() }
                return numbers.first().plus(numbers.last()).toString()
            }
            OPS.RAISE ->
            {
                val numbers = text.split("^").map { it.toDouble() }
                return numbers.first().pow(numbers.last()).toString()
            }
            OPS.root ->
            {
                val numbers = text.split("√").map { it.toDouble() }
                return sqrt(numbers.first()).toString()
            }
            null -> text
        }

    }

    private fun String.getOperator(): OPS? {
        return when {
            this.contains("+") -> OPS.ADD
            this.contains("-") -> OPS.SUB
            this.contains("/") -> OPS.DIV
            this.contains("×") -> OPS.MULT
            this.contains("^") -> OPS.RAISE
            this.contains("√") -> OPS.root
            else -> {
                null
            }
        }
    }
}


@Composable
fun Press(
    // Pre-defined values that are in the function Press
    modifier: Modifier = Modifier.padding(6.dp),
    value: String = "",
    color: Color = blueLight,
    onClick: (value: String) -> Unit
) {

    //Button specifics
    Button(
        modifier = modifier
            .clip(RoundedCornerShape(100)),
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        onClick = { onClick.invoke(value) }) {
        Text(value, modifier = Modifier.padding(16.dp), fontSize = 32.sp)
    }

}


@Preview
@Composable
fun PressPreview() {
    Press(onClick = {})
}




