case class SimpleSignalSource(
  name: String,
  output: List[Bit]
) extends SignalSource :

  override def show: String =
    List(
      "\n╭───╮",
      "\n│ " + name + " │",
      output.map("\n│ "+_+" │").mkString(
        "\n├───┤",
        "\n├───┤",
        "\n╰───╯"
      )
    ).mkString