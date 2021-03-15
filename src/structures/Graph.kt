package nntei_jazyk.structures

import nntei_jazyk.interfaces.IAbstractGraph
import java.io.Serializable
import java.util.*
import kotlin.collections.HashMap

class Graph<K, V, H> : Serializable, IAbstractGraph<K, V, H> {

    private val nodes: MutableMap<K, Node<K, V, H>> = HashMap()

    private data class Node<K, V, H>(
            val data: V
    ) : Serializable {
        val edges: LinkedList<Edge<H, K>> = LinkedList<Edge<H, K>>()
    }

    private data class Edge<H, K>(
            val data: H,
            val sourceKey: K,
            val destinationKey: K
    ) : Serializable {
        fun isKeyMatch(firstKey: K, secondKey: K): Boolean {
            return (sourceKey == firstKey && destinationKey == secondKey ||
                    sourceKey == secondKey && destinationKey == firstKey)
        }
    }

    override fun addNode(key: K, data: V) {
        if (nodes[key] == null) {
            nodes[key] = Node(data)
        }
    }

    override fun addEdge(firstKey: K, secondKey: K, data: H) {
        val edge = Edge(data, firstKey, secondKey)
        nodes[firstKey]?.edges?.add(edge)
    }

    override fun getNode(key: K): V {
        return nodes[key]?.data ?: throw IllegalStateException("Vertex with this key is not exist")
    }

    override fun getEdge(firstKey: K, secondKey: K): H {
        return nodes[firstKey]?.edges?.first { edge ->
            edge.isKeyMatch(firstKey, secondKey)
        }?.data ?: throw IllegalStateException("Edge between inserted noted is not exist")
    }

    override fun removeNode(name: K) {
        nodes[name]?.edges?.toMutableList()?.forEach {
            removeEdge(it.sourceKey, it.destinationKey)
        }
        nodes.remove(name)
    }

    override fun removeEdge(firstKey: K, secondKey: K) {
        nodes[firstKey]?.edges?.filter { edge ->
            edge.isKeyMatch(firstKey, secondKey)
        }?.forEach { edge ->
            nodes[firstKey]?.edges?.remove(edge)
            nodes[secondKey]?.edges?.remove(edge)
        }
    }

    override fun getNodes(): List<V> {
        return nodes.entries.map { it.value.data }
    }

    override fun getEdges(key: K): List<H> {
        return nodes[key]?.edges?.map { it.data } ?: mutableListOf()
    }
}