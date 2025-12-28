import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import io.github.iltotore.iron.*

class SimpleSourceSpec extends AnyFlatSpec with Matchers {

  "SimpleSource.toString" should "return the correct string representation" in {
    val ps = List[Bit](0, 1, 1, 0, 1)
    val p = SimpleSource("p", ps)

    assert(
      p.toString
      ==
      """|
         |╭───╮
         |│ p │
         |├───┤
         |│ 0 │
         |├───┤
         |│ 1 │
         |├───┤
         |│ 1 │
         |├───┤
         |│ 0 │
         |├───┤
         |│ 1 │
         |╰───╯""".stripMargin)
  }

}