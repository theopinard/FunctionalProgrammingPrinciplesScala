import math.abs

val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) / x < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    println("Guess = "+ guess)
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

def sqrt(x: Double): Double = {
  fixedPoint(y => (y + x / y) / 2)(1.0)
}
sqrt(2)

def averageDamp(f: Double => Double)(x: Double):Double ={
  (f(x) + x) / 2
}

def sqrtAvg(x: Double): Double = {
  fixedPoint(averageDamp(y => x / y))(1)
}
sqrtAvg(2)
