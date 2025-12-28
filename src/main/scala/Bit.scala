import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.numeric.Interval.Closed

type Bit = Int :| Closed[0, 1]
