import java.util.Scanner;

/**
* There is a goat behind two doors and a car behind one. User picks a door, then a goat is revealed from one of the two doors not selected, then user switches or stays in hopes to win the car
* @author Jack Gambello
* @version 1.0
*/


public class MontyHallGame
{
	public static void main(String[] args)
	{
		//welcome message
		welcome();
		
		game();
		
	}
	
	public static void welcome()
	{
		System.out.println("Monty Hall Game");
		System.out.print("Pick a door number first. ");
		System.out.print("You will have a chance to switch ");
		System.out.println("after a door has been revealed. ");
		// print 3 doors
	}	
	public static void game()
	{
		Scanner keyboard = new Scanner(System.in);
		int car = ((int) (Math.random() * 3 + 1));
		
		System.out.print("Please choose a door (1, 2 or 3): ");
		int user_pick = keyboard.nextInt();
		// get rid of the newline from the buffer
		keyboard.nextLine();
		
		//testing
		System.out.println("You chose door #: " + user_pick);
		
		int reveal = doorToReveal1(car, user_pick);
		
		//test
		System.out.println("Open door #: " + reveal);
		
		//ask user if they want to switch
		System.out.print("Do you want to switch?: ");
		String answer = keyboard.nextLine();
		
		//testing
		System.out.println("The user wants to switch " + answer);
		
		if (answer.equals("yes"))
		{
			user_pick = doorToReveal1(user_pick, reveal);
		}
		
		if ( car == user_pick )
			System.out.println("You win a car!");
		else
			System.out.println("Get wrecked. No car for you!");
		
	}
	
	
	/**
	*This method goes through the ints 1-3 in a for loop and returns the int if it doesn't equal the car and the user picked door
	*@param c
	*@param u
	*/
	

	public static int doorToReveal(int c, int u)
	{
		for (int i = 1; i < 4; i++)
		{
			if (i != c && i != u)
				return i;
		}
		return -1;
		
	}
	
	
	/**
	*This method creates a random int from 1-3 in a while loop that continues as long as the random int (g) is equal to c or u.	*
	*Exits the while loop and returns g when g isn't equal to c or u
	*@param c
	*@param u
	*/
	public static int doorToReveal1(int c, int u)
	{
	
		int g = (int) (Math.random() * 3 + 1);
		while (g == c || g == u)
		{
			 g = (int) (Math.random() * 3 + 1);
		}
		return g;
		
	}
	
	
	
	
	
	
	
}