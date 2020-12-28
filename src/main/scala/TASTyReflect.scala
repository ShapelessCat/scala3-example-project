import scala.quoted._

object TASTyReflect:
  // def collectPatternVariables(using Quotes)(tree: quotes.reflect.Tree): List[Symbol] =
  //   import quotes.reflect._

  //   val acc = new TreeAccumulator[List[Symbol]]:
  //       def apply(syms: List[Symbol], tree: Tree)(using Quotes): List[Symbol] =
  //         tree match
  //           case Bind(_, body) => apply(tree.symbol :: syms, body)
  //           case _             => foldOver(syms, tree)

  //   acc.apply(Nil, tree)

  // def collectPatternVariables(tree: Tree)(using ctx: Context): List[Symbol] =
  //   val acc = new TreeAccumulator[List[Symbol]]:
  //       def apply(syms: List[Symbol], tree: Tree)(using ctx: Context): List[Symbol] = tree match
  //         case Bind(_, body) => apply(tree.symbol :: syms, body)
  //         case _             => foldOver(syms, tree)
  //   acc(Nil, tree)