package com.example.calculatorsimple.data

import kotlin.Any as Any1

/**
 * Calculator Simple
 * @author Mambo Bryan
 * @email mambobryan@gmail.com
 * Created 6/15/22 at 10:16 AM
 */

fun add(n: Any1, m: Any1): Any1? {
    return null
}

//fun add(vararg numbers: Any1): Any1?{
    //return null
//}
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
fun add(a: Float, b: Long): Float{
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
fun add(vararg numbers: Int): Int? {
    return numbers.sum()
}
fun add(vararg numbers: Float): Float? {
    return 1f + 2f + 3f + 4f + 5f
}
fun add(vararg numbers: Double): Double?
{
    return 1.0 + 2.0 + 3.0 + 4.0 + 5.0
}
fun add(vararg numbers: Any1): Any1
{
    return 1 + 2f + 3L + 4.0 + 5
}