def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (repetition, rest) = xs  span (_ == x)
    repetition :: pack(rest)

}

def encode[T](xs: List[T]): List[(T, Int)] = {
  pack(xs) map (ys => (ys.head, ys.length))
}

val data = List("a", "a", "a", "b", "c", "c", "a")
pack(data)
encode(data)