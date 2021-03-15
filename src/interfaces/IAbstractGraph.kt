package nntei_jazyk.interfaces


interface IAbstractGraph<K, V, H> {
    fun addNode(key: K, data: V)
    fun addEdge(firstKey: K, secondKey: K, data: H)
    fun getNode(key: K): V
    fun getEdge(firstKey: K, secondKey: K): H
    fun removeNode(name: K)
    fun removeEdge(firstKey: K, secondKey: K)
    fun getNodes(): Collection<V>
    fun getEdges(key: K): Collection<H>
}