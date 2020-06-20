package metaprogramming

import scala.quoted._

def to[T: Type, R: Type](f: Expr[T] => Expr[R])(using QuoteContext): Expr[T => R] =
  '{ (x: T) => ${ f('x) } }

def from[T: Type, R: Type](f: Expr[T => R])(using QuoteContext): Expr[T] => Expr[R] =
  (x: Expr[T]) => '{ $f($x) }

// Manually lift types
def to1[T, R: Type](f: Expr[T] => Expr[R])(using t: Type[T])(using QuoteContext): Expr[T => R] =
  '{ (x: $t) => ${ f('x) } }
