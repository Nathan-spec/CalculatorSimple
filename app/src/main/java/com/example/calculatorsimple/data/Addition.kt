package com.example.calculatorsimple.data

import kotlin.math.roundToInt


/**
 * Calculator Simple
 * @author Mambo Bryan
 * @email mambobryan@gmail.com
 * Created 6/15/22 at 10:16 AM
 */

fun add(n: Any, m: Any): Any? {
    return null
}


fun add(a: Int, b: Int): Int?
{
    return a + b
}
fun add(a: Int, b: Float): Float?
{
    return a + b
}
fun add(a: Int, b: Long): Long?
{
    return a + b
}
fun add(a: Float, b: Long): Float?
{
    return a + b
}
fun add(a: Double, b:Double): Double?
{
    return a + b
}
fun add(a: Int, b: Double): Double?
{
    return a + b
}
fun add(a: Float, b: Float): Float?
{
    return a + b
}
fun add(a: Double, b: Float) : Double?
{
    return a + b
}
fun add(a: Float, b: Double) : Double?
{
    return a + b
}
fun add(a: Double, b: Long): Double?
{
    return a + b
}

fun add(vararg numbers: Double):Double?
{
    var sum = 0.toDouble()

    for(number in numbers) {
        sum += number
    }

    return sum
}
// varag -> Array equivalent
fun add(vararg numbers: Float): Float?
{
    var sum = 0.toFloat()

    for(number in numbers)
    {
        sum += number
    }
    return sum
}

fun add(vararg numbers: Int): Int?
{
    var sum = 0

    for (number in numbers)
    {
        sum += number
    }
    return sum
}
//fun add(vararg numbers: Any): Any {
    // Declare sum
    //val sum = 0
    //Check Value type of variable

    //Cast to Double

    //Add to Sum
   // sum += n

    //Return sum
    //return sum
//}