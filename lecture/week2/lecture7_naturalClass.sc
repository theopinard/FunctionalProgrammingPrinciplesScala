
class Rational(x: Int, y: Int) {
  require(y != 0, "denominateur must be non zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b ,a % b)
  }
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def + (that: Rational): Rational = {
    new Rational(
      x= numer * that.denom + denom * that.numer,
      y= denom * that.denom
    )
  }
  def unary_- : Rational = {
    new Rational(-numer, denom)
  }

  def - (that: Rational): Rational = this + -that

  def < (that: Rational): Boolean = {
    numer * that.denom < denom * that.numer
  }

  def max(that: Rational): Rational = {
    if (this < that) that
    else this
  }

  override def toString: String = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

y + y
x - y - z
x < y
x.max(y)

new Rational(1)
