import io.github.iltotore.iron.*

case class Neuron(
  name: String,
  θ: Threshold,
  inhibitors: Count,
  inputs: List[List[Bit]]
) extends SignalSource:

  lazy val output: List[Bit] =
    process(inputs)

  private def process(inputs: List[List[Bit]]): List[Bit] =
    inputs.transpose.map { xs =>
      if xs.takeRight(inhibitors).contains(1) then 0
      else f(g(xs))
    }

  private def g(xs: List[Bit]): Int =
    xs.sum

  private def f(z: Int): Bit =
    if z < θ then 0 else 1

  override def show: String =
    val n = inputs.size
    val width = 4 * n + 5
    val space = width - 2 - name.size
    val leftPadding = " " * (space / 2)
    val rightPadding = " " * (space / 2 + space % 2)
    List(
      "\n╭──" + "────" * n + "─╮",
      "\n│" + leftPadding + name + rightPadding + "│",
      (inputs ++ List(output)).transpose.map(_.mkString(
      "\n│ ",   " │ ",       " │")).mkString(
      "\n├──" + "─┬──" * n + "─┤",
      "\n├──" + "─┼──" * n + "─┤",
      "\n╰──" + "─┴──" * n + "─╯")
    ).mkString

object Neuron:

  def apply(
    name: String,
    θ: Threshold,
    inhibitors: Count,
    signalSources: SignalSource*
  ): Neuron =
    Neuron(name, θ, inhibitors, signalSources.outputs)