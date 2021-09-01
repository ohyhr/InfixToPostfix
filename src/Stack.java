public class Stack 
{
	private StackItem[] stack;
	
	public Stack() 
	{
		stack = new StackItem[15];
	}
	
	public void add(char character) 
	{
		StackItem item = new StackItem(character);
		for(int y = 0; y < stack.length; y++) 
		{
			if(stack[y] == null) 
			{
				stack[y] = item;
				break;
			}
		}
	}
	
	public boolean isEmpty() 
	{
		for(int y = 0; y < stack.length; y++) 
		{
			if(stack[y] != null) 
			{
				return false;
			}
		}
		return true;
	}
	
	public char pop() 
	{
		int index = 0;
		for(int y = 0; y < stack.length; y++) 
		{
			if(stack[y] == null) 
			{
				index = y-1;
				break;
			}
		}
		char character = stack[index].getItem();
		stack[index] = null;
		return character;
	}
	
	public char getNext() {
		int index = 0;
		for(int y = 0; y < stack.length; y++) 
		{
			if(stack[y] == null) 
			{
				index = y-1;
				break;
			}
		}
		char character = stack[index].getItem();
		return character;
	}
}

class StackItem 
{
	private char item;
	
	public StackItem(char item) 
	{
		this.item = item;
	}
	
	public char getItem() 
	{
		return item;
	}
}