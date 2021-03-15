package nntei_jazyk

import nntei_jazyk.model.FSMData
import nntei_jazyk.model.RuleEdge
import nntei_jazyk.model.StateNode
import nntei_jazyk.structures.Graph
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class FiniteStateMachine {

    companion object {
        val fsmData = FSMData(Graph(), mutableSetOf(), "")
    }

    //test zda automat přijimá řetězec + výpis použitých pravidel
    // precten znak, pouzito pravidlo xx ze stavu xx do stavu xx
    fun test(text: String): Boolean {
        var node = fsmData.graph.getNode(fsmData.startPosition)
        var edges = fsmData.graph.getEdges(node.key)

        text.forEach { char ->
            val validEdge = edges.filter { it.regex.matches(char.toString()) }

            if (validEdge.isNotEmpty()) {
                println("Char: " + char + "  is match -> " + validEdge.first().regex)
                node = fsmData.graph.getNode(validEdge.first().secondKey)
                edges = fsmData.graph.getEdges(node.key)

            } else {
                println("Char: " + char + "  is NOT match any of possible rules ->" + edges.map { it.regex })
                println()
                return false
            }
        }

        println()
        return true
    }

    fun generateGraph(fileName: String) {
        val fileInputStream = FileInputStream("src/$fileName")
        val inputStreamReader = InputStreamReader(fileInputStream, "UTF-8")
        val source = BufferedReader(inputStreamReader)
        var line: String

        line = source.readLine() // skip number
        line = source.readLine() // end points

        fsmData.endPoints = line.split(" ".toRegex()).toSortedSet()

        line = source.readLine() // first path
        fsmData.startPosition = line.split(" ".toRegex()).toTypedArray().first() // Start position
        generateNodes(line) // add to graph

        while (source.readLine()?.also { line = it } != null) {
            generateNodes(line)
        }
    }

    private fun generateNodes(line: String) {
        val line = line.split(" ".toRegex()).toTypedArray()

        val firstState = StateNode(line.first(), fsmData.endPoints.contains(line.first()))
        val lastState = StateNode(line.last(), fsmData.endPoints.contains(line.last()))
        val edgeRule = RuleEdge(line.first(), line.last(), line[1].toRegex())

        fsmData.graph.addNode(line.first(), firstState)
        fsmData.graph.addNode(line.last(), lastState)
        fsmData.graph.addEdge(line.first(), line.last(), edgeRule)
    }
}