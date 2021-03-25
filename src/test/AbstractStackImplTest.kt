package nntei_jazyk.test

import nntei_jazyk.structures.AbstractStackImpl

import org.junit.Assert.*

class AbstractStackImplTest {

    @org.junit.Test
    fun add() {
        val stack = AbstractStackImpl<Int>()
        stack.add(1)
        stack.add(2)
        stack.add(3)
        stack.add(4)
        stack.add(5)

        val first = stack.peek()
        val second = stack.peek()
        val third = stack.peek()
        val fourth = stack.peek()
        val fifth = stack.peek()

        assertEquals(5, first)
        assertEquals(4, second)
        assertEquals(3, third)
        assertEquals(2, fourth)
        assertEquals(1, fifth)
    }

    @org.junit.Test
    fun peek() {
        val stack = AbstractStackImpl<Int>()

        val first = stack.peek()
        stack.add(1)
        val second = stack.peek()
        val third = stack.peek()

        assertEquals(null, first)
        assertEquals(1, second)
        assertEquals(null, third)
    }

    @org.junit.Test
    fun isEmpty() {
        val stack = AbstractStackImpl<Int>()
        assertEquals(true, stack.isEmpty())
        stack.peek()
        assertEquals(true, stack.isEmpty())
        stack.add(1)
        assertEquals(false, stack.isEmpty())
        stack.peek()
        assertEquals(true, stack.isEmpty())
    }

    @org.junit.Test
    fun size() {
        val stack = AbstractStackImpl<Int>()
        assertEquals(0, stack.size())
        stack.peek()
        assertEquals(0, stack.size())
        stack.add(1)
        assertEquals(1, stack.size())
        stack.add(2)
        stack.add(3)
        assertEquals(3, stack.size())
        stack.peek()
        assertEquals(2, stack.size())
    }
}