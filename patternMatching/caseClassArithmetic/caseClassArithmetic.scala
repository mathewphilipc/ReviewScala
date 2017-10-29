object caseClassArithmetic {
	def main(args: Array[String]) {
		println("Arithmetic with case classes!")
		//println("We calculate 5 + 7: " + Sum(Number(5),Number(7)).eval)
		println("Much easier!")
	}

/*	abstract class Expr {
		def eval: Int
	}
	case class Number(n: Int) extends Expr {
		def eval: Int = n
	}
	case class Sum(e1: Expr, e2: Expr) extends Expr {
		def eval: Int = e1.eval + e2.eval
	}*/

	abstract class Expr
	case class Number(n: Int) extends Expr
	case class Sum(e1: Expr, e2: Expr) extends Expr
	def eval(e: Expr): Int = e match {
		case Number(n) => n
//		case Sum(L,R) => eval(L) + eval(R)
		case Sum(l,r) => eval(l) + eval(r)
	}


	/*
	* Case classes and case objects implicitly come with
	* implementations of methods toString, equals, and hashCode,
	* which override the methods with the same name in class AnyRef
	*/
}