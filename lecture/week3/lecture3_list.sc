import java.util
import java.util.NoSuchElementException

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}
class Nil[T] extends List[T]{
  override def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

def nth[T](n: Int, list: List[T]):T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) list.head
  else nth[T](n-1, list.tail)
}

val xs = new Cons(1, new Cons(2, new Cons (3, new Nil)))
nth(2, xs)
nth(-1, xs)