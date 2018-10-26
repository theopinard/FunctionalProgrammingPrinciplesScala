
trait Expr
case class Number(n: Int) extends Expr
case class Var(l: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr


def show(e: Expr): String = e match {
  case Number(x) => x.toString
  case Var(l) => l
  case Sum(l, r) => show(l) + " + " + show(r)
//  case Prod(l, r) => show(l) + " * " + show(r)
  case Prod(e1, e2) => (e1, e2) match {
    case (Sum(e11, e12), e2) => "(" + show(e1) + ") * " + show(e2)
    case (e1, Sum(e21, e22)) => show(e1) +  " * (" + show(e2) + ")"
    case (e1, e2) => show(e1) + " * " + show(e2)
  }
}

show(Sum(Prod(Number(2), Var("x")), Var("y")))
show(Prod(Sum(Number(2), Var("x")), Var("y")))
show(Sum(Number(1), Number(2)))

