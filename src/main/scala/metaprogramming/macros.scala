package metaprogramming

import scala.quoted._

object macros {
  inline def forToExample: Int => String = ${ forToExampleImpl }
  def forToExampleImpl(using QuoteContext): Expr[Int => String] =
    to((x: Expr[Int]) => '{ $x.toString })

  inline def forToWithLiftingTypeManuallyExample: Int => String = ${ forToWithLiftingTypeManuallyExampleImpl }
  def forToWithLiftingTypeManuallyExampleImpl(using QuoteContext): Expr[Int => String] =
    to1((x: Expr[Int]) => '{ $x.toString })

  inline def forFromExample: String = ${ forFromExampleImpl }
  def forFromExampleImpl(using QuoteContext): Expr[String] = {
    val exprFunc: Expr[Int] => Expr[String] = from('{ (x: Int) => x.toString })
    exprFunc('{2})
  }
  
  // BetaReduce example:
  inline def limitationOfFrom: String = ${ limitationOfFromImpl }
  def limitationOfFromImpl(using QuoteContext): Expr[String] =
    Expr(forFromExampleImpl.show)

  inline def forBetaReduceExample: String = ${ forBetaReduceExampleImpl }
  def forBetaReduceExampleImpl(using QuoteContext): Expr[String] = {
    val afterBetaReduction = Expr.betaReduce('{ (x: Int) => x.toString })('{2})
    Expr(afterBetaReduction.show)
  }
}
