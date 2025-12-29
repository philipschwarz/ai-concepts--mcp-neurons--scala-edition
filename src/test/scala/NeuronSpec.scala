import io.github.iltotore.iron.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NeuronSpec extends AnyFlatSpec with Matchers {

  "~p Neuron.toString" should "return the correct string representation" in {
    val ps = List[Bit](0, 1, 1, 0, 1)
    val p = SimpleSignalSource("p", ps)
    val not_p: Neuron = ~p

    assert(
      not_p.show
      ==
      """|
         |╭───────╮
         |│  ~ p  │
         |├───┬───┤
         |│ 0 │ 1 │
         |├───┼───┤
         |│ 1 │ 0 │
         |├───┼───┤
         |│ 1 │ 0 │
         |├───┼───┤
         |│ 0 │ 1 │
         |├───┼───┤
         |│ 1 │ 0 │
         |╰───┴───╯""".stripMargin)
  }

  "~p ∨ q Neuron.toString" should "return the correct string representation" in {
    val ps = List[Bit](0, 0, 1, 1)
    val qs = List[Bit](0, 1, 0, 1)
    val p = SimpleSignalSource("p", ps)
    val q = SimpleSignalSource("q", qs)
    val not_p_or_q: Neuron = ~p ∨ q

    assert(
      not_p_or_q.show
        ==
        """|
           |╭───────────╮
           |│  ~ p ∨ q  │
           |├───┬───┬───┤
           |│ 1 │ 0 │ 1 │
           |├───┼───┼───┤
           |│ 1 │ 1 │ 1 │
           |├───┼───┼───┤
           |│ 0 │ 0 │ 0 │
           |├───┼───┼───┤
           |│ 0 │ 1 │ 1 │
           |╰───┴───┴───╯""".stripMargin)
  }

}