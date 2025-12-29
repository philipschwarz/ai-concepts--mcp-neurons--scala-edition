import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.numeric.Interval.Closed

type Bit = Int :| Closed[0, 1]

trait SignalSource:
  def name: String
  def output: List[Bit]
  def show: String

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
    def show: String =
      signalSources
        .map(_.show.split("\n").toList.tail)
        .transpose
        .map(_.mkString)
        .mkString("\n","\n","")