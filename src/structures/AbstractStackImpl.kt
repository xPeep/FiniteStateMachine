package nntei_jazyk.structures

import nntei_jazyk.interfaces.IAbstractStack

class AbstractStackImpl<T> : IAbstractStack<T> {

    private var actualItem: Node<T>? = null
    private var counter = 0

    private data class Node<T>(
        val parent: Node<T>? = null,
        val data: T? = null
    )

    override fun add(item: T) {
        actualItem = Node(actualItem, item)
        counter++
    }

    override fun peek(): T? {
        val item = actualItem?.data
        actualItem = actualItem?.parent
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