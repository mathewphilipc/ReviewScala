object arithmetic {
	def main(args: Array[String]) = {
		println("Let's implement arithmetic expressions")
		println("What is 5 + 7?")
		def five = new Number(5)
		def seven = new Number(7)
		println("The first term evaluates to " + eval(five))
		println("The second term evaluates to " + eval(seven))
		def fivePlusSeven = eval(new Sum(five, seven))
		println("Their sum evaluates to " + fivePlusSeven)
	}

	abstract class Expr {
		def isNumber: Boolean
		def isSum: Boolean
		def numValue: Int
		def leftOp: Expr
		def rightOp: Expr
	}

	class Number(n: Int) extends Expr {
		def isNumber: Boolean = true
		def isSum: Boolean = false
		def numValue: Int = n
		def leftOp: Expr = throw new Exception("Number.leftOp")
		def rightOp: Expr = throw new Exception("Number.rightOp")
	}

	class Sum(e1: Expr, e2: Expr) extends Expr {
		def isNumber: Boolean = false
		def isSum: Boolean = true
		def numValue: Int = throw new Exception("Sum.numValue")
		def leftOp: Expr = e1
		def rightOp: Expr = e2
	}

	def eval(e: Expr): Int = {
		if (e.isNumber) e.numValue
		else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
		else throw new Exception("unrecognized expression")
	}
}