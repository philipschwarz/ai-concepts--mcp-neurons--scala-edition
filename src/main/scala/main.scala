import io.github.iltotore.iron.autoRefine

@main
def main(): Unit =

  val (ps: List[Bit], qs: List[Bit]) = List[(Bit,Bit)](
      ( 0,  0 ),
      ( 0,  1 ),
      ( 1,  0 ),
      ( 1,  1 )
  ).unzip

  val p = SimpleSignalSource("p", ps)
  val q = SimpleSignalSource("q", qs)

  List(
    List(p, q, p ∧ q),
    List(p, q, p ∨ q),
    List(p, q, ~p, ~p ∨ q),
    List(p, q, p ∧ q, ~(p ∧ q), ~p, ~ q, ~p ∨ ~q)
  ).map(_.show).foreach(print)
