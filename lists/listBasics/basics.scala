object basics {
	def main(args: Array[String]) = {
		println("Basics of lists")
		println("The empty array is empty: " + empty.isEmpty)
		println("The head of fruit is " + fruit.head)
		println("The head of the tail of fruit is " + fruit.tail.head)
		println("The head of diag3 is " + diag3.head)
	}
	val fruit = List("apples", "oranges", "pears")
	val nums: List[Int] = List(1, 2, 3, 4)
	val diag3 = List(List(1,0,0), List(0,1,0), List(0,0,1))
	val empty = List()
	/*
	* All lists are built from two more fundamental constructors, Nil
	* and :: (pronounces "cons"). Nil represents an empty list. The
	* infix operator :: expreses list extension. That is, x :: xs
	* represents a list whose first element is x, which is followed
	* by (the elements of) list xs.
	*/
	val equivalentFruit = "apples" :: ("oranges" :: ("pears" :: Nil))
}