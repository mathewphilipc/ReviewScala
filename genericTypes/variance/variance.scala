object variance {
	def main(args: Array[String]) {
		println("Variance annotations")
	}
	/* 
	* The combination of type parameters and subtyping poses some
	* interesting questions. For instance, should Stack[String] be a
	* subtype of Stack[AnyRef]? Intuitively, this seems OK, since a
	* stack of Strings is a special case of a Stack of AnyRefs. More
	* generally, if T is a subtype of type S then Stack[T] should be
	* a subtype of Stack[S]. This property is called co-variant
	* subtyping.
	*
	* In Scala, generic types have by default non-variant subtyping.
	* That is, with Stack as defined in generalStack.scala, stacks
	* with different element types would never be in a subtype
	* relationship. However, we can enforce co-variant subtyping of
	* stacks by changing the first line of the definition of class
	* Stack as follows:
	*
	* class Stack[+A] { 
	*/
	abstract class Stack[+A] {
		def push[B >: A](x: B): Stack[B] = new NonEmptyStack(x, this)
		def isEmpty: Boolean
		def top: A
		def pop: Stack[A]
	}
	class EmptyStack[+A] extends Stack[A] {
		def isEmpty = true
		def top = throw new Exception("EmptyStack.top")
		def pop = throw new Exception("EmptyStack.pop")
	}
	class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A] {
		def isEmpty = false
		def top = elem
		def pop = rest
	}

}