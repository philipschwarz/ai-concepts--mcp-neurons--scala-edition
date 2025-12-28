trait SignalSource:
  def name: String
  def output: List[Bit]
  def toString: String

  def ∧(that: SignalSource): Neuron =
    Neuron(name = s"${this.name} ∧ ${that.name}", θ = 2, inhibitors = 0, signalSources = this, that)

  def ∨(that: SignalSource): Neuron =
    Neuron(name = s"${this.name} ∨ ${that.name}", θ = 1, inhibitors = 0, signalSources = this, that)

  def unary_~ : Neuron =
    Neuron(name = s"~ ${this.name}", θ = 0, inhibitors = 1, signalSources = this)

object SignalSource:
  
  extension (signalSources: Seq[SignalSource])
    def outputs: List[List[Bit]] =
      signalSources.toList.map(_.output)
  
  extension (signalSources: List[SignalSource])
    def printSideBySide: Unit =
      signalSources
        .map(_.toString.split("\n").toList.tail)
        .transpose
        .map(_.mkString)
        .foreach(println)