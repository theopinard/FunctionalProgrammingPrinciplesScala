def abs(x: Double): Double=
  if (x > 0) x else -x

def sqrt(x: Double): Double={

  def improve(guess: Double): Double=
    (guess + x / guess ) / 2

  def isGoodEnough(guess: Double): Boolean=
    abs(guess * guess - x) / x < 0.0001

  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  sqrtIter(1.0)
}

sqrt(4)
sqrt(1e-6)
sqrt(1e50)