package http4s

import org.parboiled2.Parser.DeliveryScheme.Throw
import org.parboiled2._

object Tester {
  trait Helpers { this: Parser => /* will link if we change to `trait Helpers extends Parser` */
    def a = rule { 3.times(b) }
    def b = rule { capture(CharPredicate.Digit) }
  }

  def one(s: String): Seq[String] =
    new Parser with Helpers {
      override def input = s
    }.a.run()

  def two(s: String): String =
    new Parser /* will link if we add `with Helpers` (even though not used) */ {
      def input = s
      def c = rule { capture("foo") }
    }.c.run()

  def main(argv: Array[String]): Unit = {
    /* will link if one of two `println`s is commented out */
    println(one("123"))
    println(two("foo"))
  }
}
