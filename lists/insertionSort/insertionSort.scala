object project {
	def main(args: Array[String]) {
		println("We implement insertion sort on finite lists of integers")
		println("We start with the list List(17,16,5,3,18)")
		var unsorted = List(17, 16, 5, 3, 18)
		var sorted = isort(unsorted)
		println(sorted)
	}
	def isort(inputList: List[Int]): List[Int] = {
		if (inputList.isEmpty) Nil
		else insert(inputList.head, isort(inputList.tail))
	}
	def insert(newElem: Int, listSoFar: List[Int]): List[Int] = {
		// We assume listSoFar is sorted
		// First check for trivial case of empty listSoFar
		if (listSoFar.isEmpty) {
			newElem :: Nil
		} else {
			/*
			* If newElem is smaller than the first element of listSoFar,
			* we want newElem + listSoFar
			* Otherwise, listSoFar[0] + (newElem inserted into rest of ListSoFar)
			*/
			if (newElem < listSoFar.head) {
				newElem :: listSoFar
			} else {
				listSoFar.head :: (insert(newElem,listSoFar.tail))
			}
		}

	}
}