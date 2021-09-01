import java.util.Scanner;

public class InfixToPostfix 
{

	public static void main(String[] args) 
	{
		receiveInfix();
	}

	private static void receiveInfix()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input the Infix statement");
		String input = scanner.nextLine();
		if(input.length() <= 20) 
		{
			try 
			{
				InfixConverter infixConverter = new InfixConverter();
				String postfix = infixConverter.infixInputConverter(input);
				System.out.println("Your postfix result: " + postfix);
			}
			catch(Exception exception)
			{
				System.out.println(exception);
				receiveInfix();
			}
		}
		else
		{
			System.out.println("Please input 20 characters or less and try again.");
		}
		scanner.close();
	}
}