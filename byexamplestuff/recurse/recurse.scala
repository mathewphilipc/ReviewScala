import math.abs
/*
* From Scala By Example (Odersky):
* More generally, if the last action of a function is to call another
* (possibly the same) function, only a single stack frame is needed
* for both functions. Such called are called "tail calls."
* In principle, tail calls can always re-use the stack frame of the
* calling function. However, some run-time environments (such as the
* Java VM) lack the primitives to make stack frame re-use for tail
* calls efficient. A production quality Scala implementation is
* therefore only require to re-use the stack frame of a directly
* tail-recursive function whose last action is a call to itself.
* Other tail calls might be optimized also, but one should not rely
* on this across implementations.
*/
object recurse {
	def modNum = 21 % 19
	def gcd(a: Int, b: Int): Int = {
		if (b == 0) a
		else gcd(b, a % b)
	}

	def factorial(a: Int): Int = {
		if (a < 0) -1
		else {
			if (a == 0) 1
			else a*factorial(a-1)
		}
	}

	def main(Args: Array[String]) = {
		println("hello world. 21%19 is " + modNum + ".")
		println("Now that that's out of the way, let's compute the gcd of 14 and 21")
		println("The greatest common divisor of 14 and 21 is " + gcd(14,21))
		println("Now let's compute a factorial:")
		println("5! comes out to " + factorial(5))
		println("1! comes out to " + factorial(1))
		println("0! comes out to " + factorial(0))
		println("And conventionally, (-137)! comes out to " + factorial(-1))
	}
}