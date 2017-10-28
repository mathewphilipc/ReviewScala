import math.abs
object fixedPoints {
	def main(args: Array[String]) {
		println("hello world")
		println("The sqrt of 25 is " + sqrt(25))
	}
	val tolerance = 0.001
	def isCloseEnough(x: Double, y: Double) = ((abs(x-y)/x)) < tolerance
	def fixedPoint(f: Double => Double)(firstGuess: Double) = {
		def iterate(guess: Double): Double = {
			val next = f(guess)
			if (isCloseEnough(guess, next)) next
			else iterate(next)
		}
		iterate(firstGuess)
	}
	def sqrt(x: Double) = fixedPoint(y => (y + x / y)/2)(1.0)
}