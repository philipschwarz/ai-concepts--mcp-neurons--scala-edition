import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import io.github.iltotore.iron.*

class SimpleSignalSourceSpec extends AnyFlatSpec with Matchers {

  "SimpleSource.toString" should "return the correct string representation" in {
    val ps = List[Bit](0, 1, 1, 0, 1)
    val p = SimpleSignalSource("p", ps)

    assert(
      p.show
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