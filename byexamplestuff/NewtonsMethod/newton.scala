import math.abs
object newtonRoot {
	def sqrt(x: Double) = {
		def improve(currentGuess: Double, x: Double) =
			(currentGuess + x / currentGuess) / 2
		def sqrtIter(guess: Double, x: Double): Double = 
			if (isGoodEnough(guess, x)) guess
			else sqrtIter(improve(guess, x), x)
		def isGoodEnough(guess: Double, x: Double) =
			abs(guess*guess - x) < 0.001
		sqrtIter(1.0,x)
	}
	def main(args: Array[String]) = println(sqrt(16))
}

