object sorting {
	def main(args: Array[String]) = {
		println("Let's merge sort!")
		val testList = List(3,18,9,20,11,19,6,17,8,12,13,11,17)
		println("We begin with the unsorted " + testList)
		val sorted = msort((x: Int, y: Int) => x < y)(testList)
		println("After applying our msort function, the result is:")
		println(sorted)
	}

	def msort[A](less: (A,A) => Boolean)(xs: List[A]): List[A] = {
		def merge(xs1: List[A], xs2: List[A]): List[A] = {
			if (xs1.isEmpty) xs2
			else if (xs2.isEmpty) xs1
			else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2)
			else xs2.head :: merge(xs1, xs2.tail)
		}
		val n = xs.length/2
		if (n == 0) xs
		else merge(msort(less)(xs take n), msort(less)(xs drop n))
	}
}