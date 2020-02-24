	/*The program shall generate random numbers with a SecureRandom object
	 * The program shall ask the student to enter a difficulty level of 1, 2, 3, or 4
	 * A difficulty level of 1 shall limit random numbers to the range of 0-9, inclusive
	 * A difficulty level of 2 shall limit random numbers to the range of 0-99, inclusive
	 * A difficulty level of 3 shall limit random numbers to the range of 0-999, inclusive
	 * A difficulty level of 4 shall limit random numbers to the range of 0-9999, inclusive
	 * The program shall ask the student to enter a problem type of 1, 2, 3, 4, or 5 with an appropriate human-readable label
	 * The program shall ask the student to solve 10 different problems, as determined by the problem type
	 * A problem type of 1 shall limit the program to generating only addition problems
	 * A problem type of 2 shall limit the program to generating only multiplication problems
	 * A problem type of 3 shall limit the program to generating only subtraction problems
	 * A problem type of 4 shall limit the program to generating only division problems
	 * A problem type of 5 shall result questions that are a randomly mixture of addition, multiplication, subtraction, and division problems
	 * Problems shall contain two numbers sampled from a uniform random distribution with bounds determined by the problem difficulty
	 * The program shall display a random positive message if the student provides a correct response
	 * The program shall display a random negative message if the student provides an incorrect response
	 * The program shall display the student's score after the student has attempted to solve 10 problems
	 * The student's score shall be the percentage of problems correctly solved
	 * The program shall display the message "Please ask your teacher for extra help." if the student's score is less than 75%
	 * The program shall display the message "Congratulations, you are ready to go to the next level!" if the student's score is greater than or equal to 75%
	 * The program shall ask the student if they want to solve a new problem set after the score message has been displayed
	 * The program shall restart when the student agrees to solve a new problem set
	 * The program shall terminate when the student declines to solve another problem set
	 * Create a method called "quiz" that contains the program logic
	 * Create a method called "readDifficulty" that reads the difficulty level from the student
	 * Create a method called "readProblemType" that reads the difficulty level from the student
	 * Create a method called "generateQuestionArgument" that uses the difficulty level to generate a random number
	 * Create a method called "askQuestion" that prints the problem to the screen
	 * Create a method called "readResponse" that reads the answer from the student
	 * Create a method called "isAnswerCorrect" that checks to see if the student's answer matches the correct answer to the problem
	 * Create a method called "displayCorrectResponse" that prints out the response when a student enters a correct answer
	 * Create a method called "displayIncorrectResponse" that prints out the response when a student enters an incorrect answer
	 * Create a method called "displayCompletionMessage" that prints out the studen't score and appropriate score response
	 * Create a main method that runs your program by calling the "quiz" method*/

package linton_problem1;
import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.security.SecureRandom;	
import java.util.Scanner;


public class CAI5 
	{
		static SecureRandom  rand = new SecureRandom();
		private static int num1 = rand.nextInt(10);
		private static int num2 = rand.nextInt(10);
		private static int arithmeticOption5 = 1 + rand.nextInt(4);
		private static int switching = 1 + rand.nextInt(4);
		private static int Studentresponse;
		private static int correctAnswers;
		private static int finalGrade;
		private static int difficultyResponse;
		private static int arithmeticOption;
		private static String responseDivisionError;
		static boolean problemSetRepeat;
		private static double divisionAnswer, responseDivision;
		
		public static void main(String[] args) {			
			quiz();		
			}
private static void quiz()
{
			do 
			{
				readDifficulty();
				readProblemType();
				if(arithmeticOption == 5) 
				{
					for(int i = 0; i < 10; i++)
					{
						arithmeticOption = 1 + rand.nextInt(4);
						generateQuestionArgument();
						while(true) 
						{
							switching = 1 + rand.nextInt(4);
							isAnswerCorrect();
							break;
						}
					}
				}
				else if(arithmeticOption != 5) {
				
					for(int i = 0; i < 10; i++) {
						generateQuestionArgument();
						while(true) {
							switching = 1 + rand.nextInt(4);
							isAnswerCorrect();
							break;
						}
					}
				}
				displayCompletionMessage();
				}
			while(problemSetRepeat == true);
		}	
		private static void isAnswerCorrect() {
			if(arithmeticOption == 1) {
				if(Studentresponse == (num1 + num2)) {
					++correctAnswers;
					displayCorrectResponse();
				}else {
					displayIncorrectResponse();
				}
			}
			else if(arithmeticOption == 2) {
				if(Studentresponse == (num1 * num2)) {
					++correctAnswers;
					displayCorrectResponse();
				}else {
					displayIncorrectResponse();
				}
			}
			else if(arithmeticOption == 3) {
				if(Studentresponse == (num1 - num2)) {
					++correctAnswers;
					displayCorrectResponse();
				}else {
					displayIncorrectResponse();
				}
			}
			else if (arithmeticOption == 4) {
				//double doubleResponse = (double) response;
				double newNum1 = (double) num1;
				double newNum2 = (double) num2;
				divisionAnswer = (newNum1 / newNum2);
				if(newNum2 == 0) {
					//String divisionAnswer;
					//divisionAnswer = divisionAnswer.equalsIgnoreCase("yes");
					if(responseDivisionError.equalsIgnoreCase("error")) {
						++correctAnswers;
						displayCorrectResponse();
					}else {
						displayIncorrectResponse();
					}
				}	
				else if(Math.abs(divisionAnswer - responseDivision) < .1) {
					++correctAnswers;
					displayCorrectResponse();
				}else {
					displayIncorrectResponse();
				}
			}
			else if(arithmeticOption == 5) {
				arithmeticOption = arithmeticOption5;
				isAnswerCorrect();
			}
		}	
		private static void displayCorrectResponse() {
			switch(switching) {
			case 1:
				System.out.println("Very Good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
			}
		}
		private static void displayIncorrectResponse() {
			switch(switching) {
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more");
				break;
			case 3:
				System.out.println("Don't give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
			}
		}
		
		private static void readProblemType(){
			String [] arithmeticTypeArray = {"addition", "multiplication", "subtraction", "division", "random operation"};
			System.out.println("Please select an arithmetic type between 1 and 5?");
			int x = 0;
			for(int i = 1; i < 6; i++) {
				
				System.out.printf("%d is for %s\n", i, arithmeticTypeArray[x]);
				x++;
			}
			Scanner sc = new Scanner(System.in);
			arithmeticOption = sc.nextInt();
			int arithmeticChoice = arithmeticOption - 1;
			System.out.printf("\nYou chose a %s problem:\n", arithmeticTypeArray[arithmeticChoice]);
		}
		
		private static void readDifficulty() {
			System.out.println("Please select a difficulty level between 1 and 4?");
			Scanner sc = new Scanner(System.in);
			difficultyResponse = sc.nextInt();
		}
		
		private static void generateQuestionArgument() {
			if(difficultyResponse == 1) {
				num1 = rand.nextInt(10);
				num2 = rand.nextInt(10);
				askQuestion();
				readResponse();
			}
			else if(difficultyResponse == 2) {
				num1 = rand.nextInt(100);
				num2 = rand.nextInt(100);
				askQuestion();
				readResponse();
			}
			else if(difficultyResponse == 3) {
				num1 = rand.nextInt(1000);
				num2 = rand.nextInt(1000);
				askQuestion();
				readResponse();
			}
			else if(difficultyResponse == 4) {
				num1 = rand.nextInt(10000);
				num2 = rand.nextInt(10000);
				askQuestion();
				readResponse();
			}else {
				System.out.println("\nPlease try again and enter a correct choice\n\n");
				readDifficulty();
				generateQuestionArgument();
			}
		}
		
		public static void askQuestion() {
			if(arithmeticOption == 1) {
				System.out.printf("How much is %d plus %d?%n(Hint: use integer answer only.)%n", num1, num2);
			}
			else if(arithmeticOption == 2) {
				System.out.printf("How much is %d times %d?%n(Hint: use integer answer only.)%n", num1, num2);
			}
			else if(arithmeticOption == 3) {
				System.out.printf("How much is %d minus %d?%n(Hint: use integer answer only.)%n", num1, num2);
			}
			else if (arithmeticOption == 4) {
				System.out.printf("How much is %d divided by %d?%n(Hint 1: if it is a number divided by 0 the answer is error.)%n"
						+ "(Hint 2: you may use double answers.)%n", num1, num2);
			}
		}	
		private static void readResponse() {
			if(arithmeticOption == 4) {
				if(num2 == 0) {
					Scanner sc = new Scanner(System.in);
					responseDivisionError = sc.nextLine();
				}
				else {
					Scanner sc = new Scanner(System.in);
					responseDivision = sc.nextDouble();
				}
			}
			else {
				Scanner sc = new Scanner(System.in);
				Studentresponse = sc.nextInt();
			}
		}
		// Create a method called "displayCompletionMessage" that prints out 
		// the studen't score and appropriate score response
		private static void displayCompletionMessage() {
			finalGrade = (correctAnswers * 100) / 10;
			if(finalGrade >= 75) {
				System.out.printf("Congratulations, you are ready to go to the next level!\nYour score is %d%%", finalGrade);
			}else {
				System.out.printf("Please ask your teacher for extra help.\nYour score is %d%%", finalGrade);
			}
		}
		
}
