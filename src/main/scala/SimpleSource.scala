case class SimpleSource(
  name: String,
  output: List[Bit]
) extends SignalSource :

  override def toString: String =
    List(
      "\n╭───╮",
      "\n│ " + name + " │",
      output.map(
        "\n│ "+_+" │"
      ).mkString(
        "\n├───┤",
        "\n├───┤",
        "\n╰───╯"
      )
    ).mkString