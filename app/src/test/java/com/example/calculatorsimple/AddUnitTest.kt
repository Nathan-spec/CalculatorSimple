package com.example.calculatorsimple

import com.example.calculatorsimple.data.add
import org.junit.Assert.assertEquals
import org.junit.Test

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
        assertEquals(number, 4)
    }

    @Test
    fun add_two_numbers_is_correct_1() {
        val number = add(2, 2)
        assertEquals(number, 5)
    }

    @Test
    fun add_two_integers_returns_integer() {
        val number = add(2, 2)
        assertEquals(number, 4)
    }

    @Test
    fun add_integer_and_float_returns_float() {
        val number = add(2, 2f)
        assertEquals(number, 4f)
    }

    @Test
    fun add_integer_and_double_returns_double() {
        val number = add(2, 2.0)
        assertEquals(number, 4.0)
    }

    @Test
    fun add_integer_and_long_returns_long() {
        val number = add(2, 2L)
        assertEquals(number, 4L)
    }

    @Test
    fun add_two_floats_returns_float() {
        val number = add(2f, 2f)
        assertEquals(number, 4f)
    }

    @Test
    fun add_float_and_long_returns_float() {
        val number = add(2f, 2L)
        assertEquals(number, 4f)
    }

    @Test
    fun add_float_and_double_returns_double() {
        val number = add(2f, 2.0)
        assertEquals(number, 4.0)
    }

    @Test
    fun add_two_doubles_returns_double() {
        val number = add(2.0, 2.0)
        assertEquals(number, 4.0)
    }

    @Test
    fun add_double_and_long_returns_double() {
        val number = add(2.0, 2L)
        assertEquals(number, 4.0)
    }

    @Test
    fun add_double_and_float_returns_double() {
        val number = add(2.0, 2f)
        assertEquals(number, 4.0)
    }

    @Test
    fun add_int_varags_is_correct() {
        val number = add(1,2,3,4,5)
        assertEquals(number, 15)
    }

    @Test
    fun add_float_varags_is_correct() {
        val number = add(1f,2f,3f,4f,5f)
        assertEquals(number, 15f)
    }


    @Test
    fun add_double_varags_is_correct() {
        val number = add(1.0,2.0,3.0,4.0,5.0)
        assertEquals(number, 15.0)
    }

    @Test
    fun add_varags_is_correct() {
        val number = add(1,2f,3L,4.0,5)
        assertEquals(number, 15.0)
    }

}