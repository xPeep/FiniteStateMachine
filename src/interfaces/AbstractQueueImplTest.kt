package interfaces

import nntei_jazyk.interfaces.AbstractQueueImpl
import org.junit.Assert.*

class AbstractQueueImplTest {

    @org.junit.Test
    fun add() {
        val stack = AbstractQueueImpl<Int>()

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

        assertEquals(1, first)
        assertEquals(2, second)
        assertEquals(3, third)
        assertEquals(4, fourth)
        assertEquals(5, fifth)
    }

    @org.junit.Test
    fun peek() {
        val stack = AbstractQueueImpl<Int>()

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
        val stack = AbstractQueueImpl<Int>()

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
        val stack = AbstractQueueImpl<Int>()

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