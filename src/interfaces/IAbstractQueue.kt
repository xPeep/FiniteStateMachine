package nntei_jazyk.interfaces

interface IAbstractQueue<T> {
    fun add(item: T)
    fun peek(): T?
    fun isEmpty(): Boolean
    fun size(): Int
}