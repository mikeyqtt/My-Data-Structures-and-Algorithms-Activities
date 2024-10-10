class StackNode {
	int data;
	StackNode next;

		public StackNode(int data){
	 		this.data = data;
	 		this.next = null;

}
}

		class Stack{
			private StackNode top;

			public  Stack (){
				this.top = null;
	}


		public void push(int data){
			StackNode newNode = new StackNode(data);
			newNode.next = top;
			top = newNode;
			System.out.println(data + "pushed to stack.");
		}


		public int pop(){
			if(isEmpty()){
				System.out.println("Stack is Empty");
				return - 1;
			}

		int poppedData = top.data;
		top = top.next;
		return poppedData;
		}


	public int peek(){
		if (isEmpty()){
			System.out.println("Stack is Empty");
			return -1;
		}
		return top.data;
	}
		public boolean isEmpty(){
		return (top == null);
}

	public void ReversedStack(int data){
		Stack stack = new Stack ();
		while (!isEmpty()){
			stack.push(this.pop);
		}

		while (!stack.isEmpty()){
			this.push(Stack.pop());
		}
	}
}






public class StackWithLinkedList{
	public static void main(String []args){
		Stack stack = new Stack();
		System.out.println("Stock in Original Order");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Stock in Reversed Order");
		stack.ReversedStack();


	}
}