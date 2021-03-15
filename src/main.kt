package nntei_jazyk

import java.io.IOException

object Main {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val finiteStateMachine = FiniteStateMachine()
        finiteStateMachine.generateGraph("automat2.txt")
        val resultOne = finiteStateMachine.test("-05.6218a41")
        val resultTwo = finiteStateMachine.test("-0218525.541541")
        val resultThree = finiteStateMachine.test("+056218a41")
    }
}