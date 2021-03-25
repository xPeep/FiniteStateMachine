package nntei_jazyk.interfaces

interface IAbstractStack<T> {
    fun add(item: T)
    fun peek(): T?
    fun isEmpty(): Boolean
    fun size(): Int
}