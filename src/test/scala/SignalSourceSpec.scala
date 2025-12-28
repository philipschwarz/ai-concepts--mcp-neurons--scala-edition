import io.github.iltotore.iron.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SignalSourceSpec extends AnyFlatSpec with Matchers {
  
  "List[SignalSource].asString " should "return the correct string representations side by side" in {
    val ps = List[Bit](0, 0, 1, 1)
    val qs = List[Bit](0, 1, 0, 1)
    val p = SimpleSource("p", ps)
    val q = SimpleSource("q", qs)
    val sources = List(p, q, ~p, ~p ∨ q)

    assert(
      sources.asString
        ==
        """|
           |╭───╮╭───╮╭───────╮╭───────────╮
           |│ p ││ q ││  ~ p  ││  ~ p ∨ q  │
           |├───┤├───┤├───┬───┤├───┬───┬───┤
           |│ 0 ││ 0 ││ 0 │ 1 ││ 1 │ 0 │ 1 │
           |├───┤├───┤├───┼───┤├───┼───┼───┤
           |│ 0 ││ 1 ││ 0 │ 1 ││ 1 │ 1 │ 1 │
           |├───┤├───┤├───┼───┤├───┼───┼───┤
           |│ 1 ││ 0 ││ 1 │ 0 ││ 0 │ 0 │ 0 │
           |├───┤├───┤├───┼───┤├───┼───┼───┤
           |│ 1 ││ 1 ││ 1 │ 0 ││ 0 │ 1 │ 1 │
           |╰───╯╰───╯╰───┴───╯╰───┴───┴───╯""".stripMargin)
  }
}