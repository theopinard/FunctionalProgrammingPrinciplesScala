

val xs = Array(1, 4, 5)

xs map (x => x * 2 )

val s = "Hello Word"

s filter (c => c.isUpper)

val M = 4
val N = 3
(1 to M) flatMap (x => ((1 to N) map (y => (x, y))))


def isPrime(n: Int): Boolean = 2 until n forall(d => n%d != 0)

isPrime(4)
isPrime(11)