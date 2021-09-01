public class InfixConverter 
{
	// Data storage
	private Stack operatorStack;
	
	public InfixConverter()
	{
		operatorStack = new Stack();
	}
	public String infixInputConverter(String infixInput)
	{
		String postfix = "";
		for(int index = 0; index < infixInput.length(); index++) 
		{
			char character = infixInput.charAt(index);
			if(character == ' ') { } 
			else if(Character.isLetter(character)) 
			{
				postfix = postfix + character;
			} else if(character == '+' || character == '*' || character == '/') 
			{
				if(!operatorStack.isEmpty()) 
				{
					if(!isLowerPrecedence(character)) 
					{
						operatorStack.add(character);
					} else {
						postfix = postfix + operatorStack.pop();
						operatorStack.add(character);
					}
				} else {
					operatorStack.add(character);
				}
			} else if(character == '(')
				operatorStack.add(character);
			else if(character == ')') {
				char charPopped = operatorStack.pop();
				while(charPopped != '(')
				{
					postfix += charPopped;
					charPopped = operatorStack.pop();
				}
			}
		}
		while(!operatorStack.isEmpty()) 
		{
			postfix += operatorStack.pop();
		}
		return postfix;
	}
	
	private int getPrecedenceValue(char character) 
	{
		int valueChar = 0;
		switch(character) 
		{
			case '+':
				valueChar = 1;
				break;
			case '*':
				valueChar = 2;
				break;
			case '/':
				valueChar = 3;
				break;
		}
		return valueChar;
	}
	
	private boolean isLowerPrecedence(char character)
	{
		int valueLastOperator = getPrecedenceValue(operatorStack.getNext());
		int valueChar = getPrecedenceValue(character);

		if(valueChar < valueLastOperator)
			return true;
		return false;
	}
}
