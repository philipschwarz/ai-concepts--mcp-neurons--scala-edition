import io.github.iltotore.iron.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SimpleSignalSourceSpec extends AnyFlatSpec with Matchers {

  "SimpleSource" should "have the correct string representation" in {
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