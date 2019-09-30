import java.util.Stack;

public class StringReverse{

	public static void main(String []args){

		//create a new, empty stack
		Stack<String> lifo = new Stack<String>();
		String toBeReversed = "abcdefghijklmnop";

		//adding items to stack
		for(int i = 0;i<toBeReversed.length();i++){

			lifo.push(Character.toString(toBeReversed.charAt(i)));

		}

		//last in first out means reverse order

		System.out.println(lifo.size());

		while(!lifo.empty()){
			System.out.print(lifo.pop());
			if(!lifo.empty())
				System.out.print(',');
			else
				System.out.println();
		}








	}
}