object betterArithmetic {
	def main(args: Array[String]) = {
		println("better arithmetic! For example: ")
		def a = new Number(3)
		def b = new Number(12)
		def c = new Number(25)
		println("Let a = 3, b = 12, and c = 25")
		println("Then (a+b)+c comes out to: ")
		def sumExpr = new Sum(new Sum(a,b), c)
		println(sumExpr.eval)
		println("Or with our printing method:")
		sumExpr.print
		Console.print(" comes out to " + sumExpr.eval)
	}
	/*
	* Instead of defining a function `eval` that takes in `expr`s,
	* which necessarily acts casewise in the type of `expr` and thus
	* requires methods isSum, isNum, etc, we define eval as a
	* parameter-free method of the `expr` class!
	*/
	abstract class Expr {
		def eval: Int
		def print
	}
	class Number(n: Int) extends Expr {
		def eval: Int = n
		def print {
			Console.print(n)
		}
	}
	class Sum(e1: Expr, e2: Expr) extends Expr {
		def eval: Int = e1.eval + e2.eval
		def print {
			Console.print("(")
			e1.print
			Console.print("+")
			e2.print
			Console.print(")")
		}
	}
}