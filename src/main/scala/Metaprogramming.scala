import scala.quoted._
import metaprogramming._

object Metaprogramming {
  def test: Unit = {
    println("Macros:\n")
    println(f"- To: ${macros.forToExample(2)}")
    println(f"- To (manually lift types): ${macros.forToWithLiftingTypeManuallyExample(2)}")
    println(f"- From: ${macros.forFromExample}")
    println(f"- Limitation of From: ${macros.limitationOfFrom}")
    println(f"- Overcode The Limitation of From with BetaReduce: ${macros.forBetaReduceExample}")
    println()

    println(f"Multi-Stage Programming:\n")
    println(f"- To: ${multiStage.runf1(2)}")
    println(f"- From: ${multiStage.runf2}")
  }
}
  
