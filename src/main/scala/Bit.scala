import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.all.Positive0
import io.github.iltotore.iron.constraint.numeric.Interval.Closed

type Bit = Int :| Closed[0, 1]

type Count = Int :| Positive0

type Threshold = Int :| Positive0