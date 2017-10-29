object sets {
	def main(args: Array[String]) {
		println("We start with an empty set.")
		println("Just to be safe, let's check a few things:")
		def setA = new EmptySet;
		println("Does it contain 1, 3, 5, 7?")
		println(setA.contains(1) + ", " + setA.contains(3) + ", " + setA.contains(5) + ", " + setA.contains(7))
		println("Now we add 5 and check again:")
		def setB = setA.incl(5)
		println(setB.contains(1) + ", " + setB.contains(3) + ", " + setB.contains(5) + ", " + setB.contains(7))
		println("Now we add 1 and check again:")
		def setC = setB.incl(1)
		println(setC.contains(1) + ", " + setC.contains(3) + ", " + setC.contains(5) + ", " + setC.contains(7))
		println("Now we introduce a new set containing only 3 and 5. Just to check:")
		def otherSet = (new EmptySet).incl(3)
		println(otherSet.contains(1) + ", " + otherSet.contains(3) + ", " + otherSet.contains(5) + ", " + otherSet.contains(7))
		println("Is the first set empty? " +  setC.isEmpty)
		println("Is the second set empty? " +  otherSet.isEmpty)
		def newSet = setC.union(otherSet)
		println("Does their union contain 1, 3, 5, 7?")
		println(newSet.contains(1) + ", " + newSet.contains(3) + ", " + newSet.contains(5) + ", " + newSet.contains(7))
	}

	abstract class IntSet {
		def incl(x: Int): IntSet
		def contains(x: Int): Boolean
		def isEmpty: Boolean
		def union(other: IntSet): IntSet
	}

	class EmptySet extends IntSet {
		def contains(x: Int): Boolean = false
		def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
		def isEmpty: Boolean = true
		def union(other: IntSet): IntSet = other
	}

	class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
		def isEmpty: Boolean = false
		def contains(x: Int): Boolean = 
			if (x < elem) left contains x
			else if (x > elem) right contains x
			else true
		def incl(x: Int): IntSet =
			if (x < elem) new NonEmptySet(elem, left incl x, right)
			else if (x > elem) new NonEmptySet(elem, left, right incl x)
			else this
		def union(other: IntSet): IntSet = {
			if (this.isEmpty) other
			else {
				right.union(left.union(other.incl(elem)))
			}
		}
	}
}