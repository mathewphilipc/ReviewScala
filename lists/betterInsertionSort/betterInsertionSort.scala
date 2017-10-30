object project {
	def main(args: Array[String]) {
		println("We implement insert sort on finite lists of integers")
		println("We start with the list List(17,16,5,3,18)")
		var unsorted = List(17, 16, 5, 3, 18)
		var sorted = isort(unsorted)
		println(sorted)
	}
	def isort(xs: List[Int]): List[Int] = xs match {
		case List() => List()
		case x :: xs1 => {
			println("We insert " + x + " into " + xs1)
			insert(x, isort(xs1))
		}
	}
	def insert(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
	}
}