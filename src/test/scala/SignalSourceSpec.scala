import io.github.iltotore.iron.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SignalSourceSpec extends AnyFlatSpec with Matchers {
  
  "List[SignalSource]" should "have the correct string representation" in {
    val ps = List[Bit](0, 0, 1, 1)
    val qs = List[Bit](0, 1, 0, 1)
    val p = SimpleSignalSource("p", ps)
    val q = SimpleSignalSource("q", qs)
    val sources = List(p, q, ~p, ~p ∨ q)

    assert(
      sources.show
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