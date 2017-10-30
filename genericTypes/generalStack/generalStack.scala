object project {
	def main(args: Array[String]) = {
		println("Hello world!")
		val x = new EmptyStack[Int]
		val y = x.push(1).push(2)
		val result = y.pop.top
		println("Let's take an empty stack, push 1, push 2, then pop.")
		println("The result has one element (its top): " + result)
		val s1 = new EmptyStack[String].push("abc")
		val s2 = new EmptyStack[String].push("abx").push(s1.top)
		println("Let's make a string stack: s1 -> [abc]")
		println("Let's make a second: s2 -> [abx, abc]")
		println("Note the convention that the top is the right end")
		println("Is s1 and prefix of s2? " + isPrefix[String](s1,s2))
		println("We computed that by evaluating the expresion `isPrefix[String](s1,s2)`")
		println("But since s1 and s2 are both String objects, we can let Scala infer the argument [String]")
		println("Indeed, `isPrefix(s1,s2) evaluates to " + isPrefix(s1,s2))
	}
	abstract class Stack[A] {
		def push(x: A): Stack[A] = new NonEmptyStack[A](x, this)
		def isEmpty: Boolean
		def top: A
		def pop: Stack[A]
	}
	class EmptyStack[A] extends Stack[A] {
		def isEmpty = true
		def top = throw new Exception("EmptyStack.top")
		def pop = throw new Exception("EmptyStack.pop")
	}
	class NonEmptyStack[A](elem: A, rest: Stack[A]) extends Stack[A] {
		def isEmpty = false
		def top = elem
		def pop = rest
	}
	/*
	* Method to determine whether stack p is a prefix of stack s
	* I.e., the top few elements of s are the element of p (in order)
	*/
	def isPrefix[A](p: Stack[A], s: Stack[A]): Boolean = {
		if (p.isEmpty) true
		else {
			(p.top == s.top && isPrefix[A](p.pop, s.pop))
		}
	}
}