object sums {
	def main(args: Array[String]) = {
		println("let's do some summation")
		println("The sum of all integers from 5 to 9 is " + sumInts(5,9))
		println("The square of 9 is " + square(9))
		println("The sum of squares from 1^2 to 4^2 is " + sumSquares(1,4))
		println("The sum of powers of 2 from 2^0 to 2^4 is " + sumPowersOfTwo(0,4))
		println("Computed more nicely, that last sum is still " + sum(powerOfTwo, 0, 4))
	}

	def sumInts(a: Int, b: Int): Int = {
		if (a > b) 0
		else {
			a + sumInts(a+1, b)
		}
	}

	def square(a: Int): Int = a * a

	def sumSquares(a: Int, b: Int): Int = {
		if (a > b) 0
		else {
			a*a + sumSquares(a+1, b)
		}
	}

	def powerOfTwo(x: Int): Int = {
		if (x == 0) 1
		else 2 * powerOfTwo(x-1)
	}
	def sumPowersOfTwo(a: Int, b: Int): Int = {
		if (a > b) 0
		else powerOfTwo(a) + sumPowersOfTwo(a+1, b)
	}
	// And now the neat functional way
	def sum(f: Int => Int, a: Int, b: Int): Int = {
		if (a > b) 0
		else f(a) + sum(f, a+1, b)
	}
}