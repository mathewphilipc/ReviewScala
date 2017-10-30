object project {
	def main(args: Array[String]) {
		println("Let's compute the length of a list in two ways")
		println("As an example, consider the list List(2,4,6,8).")
		val testList = List(2, 4, 6, 8)
		println(testList + " has length " + listLength(testList))
		println("Our tail-recursive calculator finds it has length " + tailRecursiveListLength(testList,0))
	}

	def listLength(myList: List[Int]): Int = {
		if (myList.isEmpty) 0
		else 1 + listLength(myList.tail)
	}

	def tailRecursiveListLength(myList: List[Int], x: Int): Int = {
		if (myList.isEmpty) x
		else tailRecursiveListLength(myList.tail,x+1)
	}
}