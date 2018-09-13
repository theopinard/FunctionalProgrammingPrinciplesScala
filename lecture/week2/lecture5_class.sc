class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational): Rational = {
    new Rational(
      x= numer * that.denom + denom * that.numer,
      y= denom * that.denom
    )
  }
  def neg: Rational = {
    new Rational(-numer, denom)
  }

  def sub(that: Rational): Rational = add(that.neg)

  override def toString: String = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.add(y)

x.sub(y).sub(z)
