package nntei_jazyk.model

import nntei_jazyk.interfaces.IAbstractGraph
import nntei_jazyk.structures.Graph

data class FSMData(
    val graph: IAbstractGraph<String, StateNode, RuleEdge>,
    var endPoints: MutableSet<String>,
    var startPosition: String
)

data class StateNode(
    val key: String,
    val startPosition: Boolean
)

data class RuleEdge(
    val firstKey: String,
    val secondKey: String,
    val regex: Regex
)

