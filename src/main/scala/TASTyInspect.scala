import scala.quoted._
import scala.tasty.inspector._


class Consumer extends TastyInspector:
   protected def processCompilationUnit(using Quotes)(tree: quotes.reflect.Tree): Unit =
      import quotes.reflect._
      // Do something with the tree
      ???

object Test:
  def main(args: Array[String]): Unit =
    val classpath = dotty.tools.dotc.util.ClasspathFromClassloader(this.getClass.getClassLoader).split(java.io.File.pathSeparator).find(_.contains("runWithCompiler")).get
    val allTastyFiles = dotty.tools.io.Path(classpath).walkFilter(_.extension == "tasty").map(_.toString).toList
    val tastyFiles = allTastyFiles.filter(_.contains("Foo"))
    (new Consumer).inspectTastyFiles(tastyFiles)
    // new Consumer().inspectTastyFiles("", List("foo.Bar"), new Consumer)