package com.example.calculatorsimple

import com.example.calculatorsimple.data.add
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.random.Random

/**
 * Calculator Simple
 * @author Mambo Bryan
 * @email mambobryan@gmail.com
 * Created 6/15/22 at 10:28 AM
 */
class AddUnitTest {

    @Test
    fun add_two_numbers_is_correct() {
        val number = add(2, 2)
        assertEquals(4, number)
    }

    @Test
    fun add_two_numbers_is_correct_1() {
        val number = add(8, 7)
        assertEquals(15, number)
    }

    @Test
    fun add_two_integers_returns_integer() {
        val number = add(2, 2)
        assertEquals(4, number)
    }

    @Test
    fun add_integer_and_float_returns_float() {
        val number = add(2, 2f)
        assertEquals(4f, number)
    }

    @Test
    fun add_integer_and_double_returns_double() {
        val number = add(2, 2.0)
        assertEquals(4.0, number)
    }

    @Test
    fun add_integer_and_long_returns_long() {
        val number = add(2, 2L)
        assertEquals(4L, number)
    }

    @Test
    fun add_two_floats_returns_float() {
        val number = add(2f, 2f)
        assertEquals(4f, number)
    }

    @Test
    fun add_float_and_long_returns_float() {
        val number = add(2f, 2L)
        assertEquals(4f, number)
    }

    @Test
    fun add_float_and_double_returns_double() {
        val number = add(2f, 2.0)
        assertEquals(4.0, number)
    }

    @Test
    fun add_two_doubles_returns_double() {
        val number = add(2.0, 2.0)
        assertEquals(4.0, number)
    }

    @Test
    fun add_double_and_long_returns_double() {
        val number = add(2.0, 2L)
        assertEquals(4.0, number)
    }

    @Test
    fun add_double_and_float_returns_double() {
        val number = add(2.0, 2f)
        assertEquals(4.0, number)
    }

    @Test
    fun add_int_varags_is_correct() {
        val number = add(1, 2, 3, 4, 5)
        assertEquals(15, number)
    }

    @Test
    fun add_float_varags_is_correct() {
        val number = add(1f, 2f, 3f, 4f, 5f)
        assertEquals(15f, number)
    }


    @Test
    fun add_double_varags_is_correct() {
        val number = add(1.0, 2.0, 3.0, 4.0, 5.0)
        assertEquals(15.0, number)
    }

    @Test
    fun add_varags_is_correct() {
        val number = add(1, 2f, 3L, 4.0, 5)
        assertEquals(15.0, number)
    }

    @Test
    fun add_varags_is_correct_int() {

        val list = mutableListOf<Int>()

        for (number in 0 until 10) {
            list.add(Random.nextInt())
        }

        val number = add(list)
        assertEquals(list.sum(), number)
    }

    @Test
    fun add_varags_is_correct_double() {

        val list = mutableListOf<Double>()

        for (number in 0 until 10) {
            list.add(Random.nextDouble())
        }

        val number = add(list)
        assertEquals(list.sum(), number)
    }

    @Test
    fun add_varags_is_correct_float() {

        val list = mutableListOf<Float>()

        for (number in 0 until 10) {
            list.add(Random.nextFloat())
        }

        val number = add(list)
        assertEquals(list.sum(), number)

    }

    @Test
    fun add_varags_is_correct_long() {

        val list = mutableListOf<Long>()

        for (number in 0 until 10) {
            list.add(Random.nextLong())
        }

        val number = add(list)
        assertEquals(list.sum(), number)

    }

    @Test
    fun add_varags_is_correct_numbers() {

        val ints = mutableListOf<Int>()
        val doubles = mutableListOf<Double>()

        for (number in 0 until 5) {
            ints.add(Random.nextInt())
        }

        for (number in 0 until 5) {
            doubles.add(Random.nextDouble())
        }

        val number = add(ints, doubles)
        assertEquals(ints.sum() + doubles.sum(), number)

    }

}