import java.util.Scanner;
import java.util.Random;

class Game{
	
	int min = 1;
    int max = 100;
    int attempts = 10;
    int score = 0;
    int noOfattempts=0;
    int guess,number;

	// generating random number in default constructor
    Game(){
    	Random random = new Random();
    	number = random.nextInt(max - min + 1) + min;
    }
    
    // method to take user guesses
    public boolean UserInput() {
		if ( noOfattempts < attempts ) {
			System.out.println("Guess the number between " + min + " to " + max + " in " + attempts + " attempts");
			System.out.println("Attemp#"+ (noOfattempts + 1) + ":");
			this.guess = GuessTheNumber.takeIntegerInput(100);
			noOfattempts++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
		}
	}

	//method to check user guess status
    public boolean isCorrectGuess() {
		
		if (guess == number) {
		   System.out.println("Congratulations, you guessed the number in " + noOfattempts + " attempts!");
		   score = 100 - ((noOfattempts - 1) * 10);
		   System.out.println("Your score is " + score + ".");
		   return true;
		} 
		else if ( noOfattempts < attempts && guess > number ) {
			System.out.println("The Number is lower than " + guess +".");
		}
		else if ( noOfattempts < attempts && guess < number ) {
			System.out.println("The Number is higher than " + guess +".");
		}
		return false;
	}
}

//main class
public class GuessTheNumber {
	
	// static method to take integer input without any limit and exception error
	// exception handling and input limit handling
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	// main method
	public static void main(String[] args) { 
		
		// input for start the game
		System.out.println("WellCome ");
		System.out.println("1. For Start the Gussing Game \n2. For Exit");
		System.out.print("Enter your choice : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			// to check next round is there or not
			while ( nextRound == 1 ) {
				
				// creating object of Game class
				Game game = new Game();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++noOfRound);
				
				// to check correct guess and limit cross
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.UserInput();
					isMatched = game.isCorrectGuess();
				}
				
				// input for next round
				
				System.out.println("do you want to paly again?\npress 1");
				System.out.println("Enter your choice : ");
				nextRound = takeIntegerInput(2);
				
				if ( nextRound != 1 ) {
					System.out.println("Thank You for palying the Gussing game!!\nSee you next time!!");
					System.exit(0);
				}
			}
		}
		else {
			System.out.println("See you next time");
			System.exit(0);
		}
	}
}