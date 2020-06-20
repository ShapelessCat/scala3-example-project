package metaprogramming

import scala.quoted._
import scala.quoted.staging._

object multiStage {

  given Toolbox = Toolbox.make(getClass.getClassLoader)

  val runf1: Int => String = run {
    to((x: Expr[Int]) => '{ $x.toString })
  }

  val runf2: String = run {
    val f2: Expr[Int] => Expr[String] = from('{ (x: Int) => x.toString })
    f2('{2})
  }
}
