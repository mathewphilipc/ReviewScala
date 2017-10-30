object project {
	def main(args: Array[String]) = {
		println("Int stacks!")
	}

	abstract class IntStack {
		def push(x: Int): IntStack = new IntNonEmptyStack(x, this)
		def isEmpty: Boolean
		def top: Int
		def pop: IntStack
	}
	class IntEmptyStack extends IntStack {
		def isEmpty = true
		def top = throw new Exception("EmptyStack.top")
		def pop = throw new Exception("EmptyStack.pop")
	}
	class IntNonEmptyStack(elem: Int, rest: IntStack) extends IntStack {
		def isEmpty = false
		def top = elem
		def pop = rest
	}
}