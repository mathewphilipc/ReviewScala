object curry {
	def main(args: Array[String]) {
		println("hello world")
		println("The sum of squares from 0 to 10 is " + sumSquares(0,10))
	}
	/* nice functional way to implement sum:
	def sum(f: Int => Int): (Int, Int) => Int = {
		def sumF(a: Int, b: Int): Int =
			if (a > b) 0 else sumF(a+1, b)
		sumF
	}*/
	// Even nicer functional way
	def sum(f: Int => Int)(a: Int, b: Int): Int =
		if (a > b) 0 else f(a) + sum(f)(a + 1, b)

	def sumSquares = sum(x => x*x)(_,_)
}