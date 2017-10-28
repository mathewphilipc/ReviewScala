object rationalStuff {
	def main(args: Array[String]) {
		println("hello world")
		println("Implement rationals")
		println("Consider the rational number " + top + "/" + bottom + ".")
		println("In reduced form this becomes " + testNumer + "/" + testDenom + ".")
		println("With the overriden toString method: " + testRational.toString())
	}
	class Rational(n: Int, d: Int) {
		// rational numbers have the form n/d for d !== 0
		private def gcd(x: Int, y: Int): Int = {
			if (x == 0) y
			else if (x < 0) gcd(-x, y)
			else if (y < 0) gcd(x, -y)
			else gcd(y % x, x)
		}
		// `Private` works in the familiar way
		private val g = gcd(n,d)
		val numer: Int = n/g
		val denom: Int = d/g
		def +(that: Rational) =
			new Rational(numer * that.denom + that.numer * denom,
				denom * that.denom)
		def -(that: Rational) =
			new Rational(numer * that.denom - that.numer * denom,
				denom * that.denom)
		override def toString = "" + numer + "/" + denom
	}
	val top = 12
	val bottom = 8
	def testRational = new Rational(top, bottom)
	def testNumer = testRational.numer
	def testDenom = testRational.denom
}