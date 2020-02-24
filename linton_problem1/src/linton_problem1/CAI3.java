/*The program shall generate random numbers with a SecureRandom object
The program shall ask the student to solve 10 different multiplication problems
Multiplication problems shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
The program shall display a random positive message if the student provides a correct response
The program shall display a random negative message if the student provides an incorrect response
The program shall display the student's score after the student has attempted to solve 10 problems
The student's score shall be the percentage of problems correctly solved
The program shall display the message "Please ask your teacher for extra help." if the student's score is less than 75%
The program shall display the message "Congratulations, you are ready to go to the next level!" if the student's score is greater than or equal to 75%
The program shall ask the student if they want to solve a new problem set after the score message has been displayed
The program shall restart when the student agrees to solve a new problem set
The program shall terminate when the student declines to solve another problem set
Create a method called "quiz" that contains the program logic
Create a function called "askQuestion" that prints the problem to the screen
Create a function called "readResponse" that reads the answer from the student
Create a function called "isAsnwerCorrect" that checks to see if the student's answer matches the correct answer to the problem
Create a function called "displayCorrectResponse" that prints out the response when a student enters a correct answer
Create a function called "displayInorrectResponse" that prints out the response when a student enters an incorrect answer
Create a function called "displayCompletionMessage" that prints out the studen't score and appropriate score response
Create a main method that runs your program by calling the "quiz" method*/
package linton_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
		// initialize the secure random variable
		static SecureRandom rand = new SecureRandom();
		// Generate random numbers less than 4 for switch
		private static int switching = 1 + rand.nextInt(4);
		// Generate random numbers less than 10
		public static int num1 = rand.nextInt(10);
		public static int num2 = rand.nextInt(10);
		private static int studentResponse;
		private static int correctAnswers;
		private static int finalGrade;
		static boolean problemSetRepeat;
		
		public static void main(String[] args)
		{
			quiz();
		}		
	// create method to generate the arithmetic logic.
	public static void quiz()
	{
		int i =0;	
		for(i = 0; i<=10; i++) 
		{
			num1 = rand.nextInt(10);
			num2 = rand.nextInt(10);
			askQuestion();
			readResponse();	
			while(true) 
			{
				switching = 1 + rand.nextInt(4);
				if(studentResponse != (num1 * num2))
				{
					isAnswerCorrect();
					break;
				}
				else if(studentResponse == (num1 * num2))
				{
					isAnswerCorrect();
					break;
				}
					}
				}
		displayCompletionMessage();
		}		
	public static void readResponse()
	{
		// create scanner to enter inputs &
		Scanner sc = new Scanner(System.in);
		// ask the student for an answer &
		// record input.
		System.out.print("\nyour answer: ");
			studentResponse = sc.nextInt();		
		}
	 // call a method to generate the question
	public static void askQuestion()
	{
		 System.out.println("How much is " + num1 + " times " + num2 + "?");
		}
	public static void isAnswerCorrect()
	{
		if(studentResponse == num1 * num2) {
					++correctAnswers;
			displayCorrectResponse();
		}else {
			displayIncorrectResponse();
		}
	}
	public static void displayCorrectResponse()
	{
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
	public static void displayIncorrectResponse()
	{
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
	private static void displayCompletionMessage() 
	{
		finalGrade = (correctAnswers * 100) / 10;
		if(finalGrade >= 75) {
			System.out.printf("Congratulations, you are ready to go to the next level!\n You scored %d%% you a smart bitch!", finalGrade);
		}else {
			System.out.printf("Please ask your teacher for extra help.\nYou scored %d%%  you dumb as fuck bruh", finalGrade);
		}
	}
}



