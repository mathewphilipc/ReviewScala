// Computing cube roots by functional methods
import math.abs
object rootFun {
	def main(args: Array[String]) = {
		println("let's find cube roots")
		def a = 5.0;
		println("The average of " + a + " and " + a + "^2 is " + averageDamp(x => x*x)(5))
		println("Now let's compute a cube root:")
		println("For general x, the cube root of x is the unique num y such that y^3 == x")
		println("In other words, it satisfies y == x / (y^2)")
		println("In other other words, it is the unique fixed point of a => x / (a^2)")
		println("For convergence, we equivalently compute it as the !fp of a => (a + x/a^2)/2")
		println("We find the cube root of 64 to be " + cubeRoot(64))
	}

	// define general fixedPoint finder
	val tolerance = 0.0001
	def isCloseEnough(x: Double, y: Double) = abs((x-y)/x) < tolerance
	def fixedPoint(f: Double => Double)(firstGuess: Double) = {
		def iterate(guess: Double): Double = {
			val next = f(guess)
			if (isCloseEnough(guess,next)) next
			else iterate(next)
		}
		iterate(firstGuess)
	}
	def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2
	def cubeRoot(x: Double) = fixedPoint(averageDamp(a => x / (a*a)))(1.0)
}