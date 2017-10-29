object Factorial {
	def main(args: Array[String]) {
		println("let's calculate!")
		println("The sum of integers from 1 to 5 is " + sum(x => x, 1, 5))
		println("The product of integers from 1 to 5 is " + prod(x => x, 1, 5))
		println("By tail recursion, that last product is still " + tailFact(5))
	}
	def sum(f: Int => Int, a: Int, b: Int): Int = {
		if (a > b) 0
		else f(a) + sum(f, a+1, b)
	}
	def prod(f: Int => Int, a: Int, b: Int): Int = {
		if (a > b) 1
		else f(a)*prod(f,a+1,b)
	}
	def tailFact(x: Int): Int = {
		def iter(a: Int, output: Int): Int = {
			if (a == 0) output
			else iter(a - 1, output*a)
		}
		iter(x, 1)
	}
}