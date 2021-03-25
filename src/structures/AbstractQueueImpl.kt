package nntei_jazyk.structures

import nntei_jazyk.interfaces.IAbstractQueue

class AbstractQueueImpl<T> : IAbstractQueue<T> {

    private var firstItem: Node<T>? = null
    private var actualItem: Node<T>? = null
    private var counter = 0

    private data class Node<T>(
        var next: Node<T>? = null,
        val data: T? = null
    )

    override fun add(item: T) {
        val new = actualItem
        actualItem = Node(null, item)
        if (isEmpty()) {
            firstItem = actualItem
        } else {
            new?.next = actualItem
        }
        counter++
    }

    override fun peek(): T? {
        val item = firstItem?.data
        firstItem = firstItem?.next
        if (counter > 0) {
            counter--
        }
        return item
    }

    override fun isEmpty(): Boolean {
        return counter == 0
    }

    override fun size(): Int {
        return counter
    }
}