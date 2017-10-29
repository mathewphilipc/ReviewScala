object arithmetic {
	def main(args: Array[String]) = println("Let's implement arithmetic expressions")

	abstract class Expr {
		def isNumber: Boolean
		def isSum: Boolean
		def numValue: implement
		def leftOp: Expr
		def rightOp: Expr
	}

	class Number(n: Int) extends Expr {
		def isNumber: Boolean = true
		def isSum: Boolean = false
		def numValue: Int = n
		def leftOp: Expr = error("Number.leftOp")
		def rightOp: Expr = error("Number.rightOp")
	}

	def Sum(e1: Expr, e2: Expr) extends Expr {
		def isNumber: Boolean = false
		def isSum: Boolean = true
		def numValue: Int = error("Sum.numValue")
		def leftOp: Expr = e1
		def rightOp: Expr = e2
	}
}