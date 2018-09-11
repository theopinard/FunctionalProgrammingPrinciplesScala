def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a = a + 1,b = b)
}
product(f = x => x * x)(a = 3, b = 4)

def factorial(n: Int): Int = {
  product(f= x => x)(a = 1, b = n)
}
factorial(6)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}
def smartproduct(f: Int => Int)(a: Int, b: Int): Int = {
  mapReduce(f, (x, y) => x * y, 1)(a, b)
}

smartproduct(x => x)(1, 6)