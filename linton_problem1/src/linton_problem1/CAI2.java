/*The program shall generate random numbers with a SecureRandom object
The program shall ask the student to solve a multiplication problem
A multiplication problem shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
The program shall display a random positive message if the student provides a correct response
The program shall display a random negative message if the student provides an incorrect response
The program shall terminate when a correct response is provided by the student
The program shall continue to ask the student to solve the original multiplication problem until the student provides the correct answer
Create a method called "quiz" that contains the program logic
Create a function called "askQuestion" that prints the problem to the screen
Create a function called "readResponse" that reads the answer from the student
Create a function called "isAsnwerCorrect" that checks to see if the student's answer matches the correct answer to the problem
Create a function called "displayCorrectResponse" that prints out the response when a student enters a correct answer
Create a function called "displayInorrectResponse" that prints out the response when a student enters an incorrect answer
Part 1: Create a main method that runs your program by calling the "quiz" method
 */
package linton_problem1;

import java.security.SecureRandom;
//import java.util.Random;
import java.util.Scanner;

public class CAI2 {
	// initialize the secure random variable
	static SecureRandom rand = new SecureRandom();
	// Generate random numbers less than 4 for switch
	private static int switching = 1 + rand.nextInt(4);
	// Generate random numbers less than 10
	public static int num1 = rand.nextInt(10);
	public static int num2 = rand.nextInt(10);
	private static int studentResponse;
	public static void main(String[] args)
	{
		quiz();
	}		
// create method to generate the arithmetic logic.
public static void quiz()
{
	askQuestion();
	// declare variables for this method
	int correctAnswer = num1 * num2;
	readResponse();
	while(true) {
		switching = 1 + rand.nextInt(4);
		//System.out.println(switchChoice);
		if(studentResponse != (correctAnswer)) {
			displayIncorrectResponse();
			askQuestion();
			readResponse();
			continue;
		}
		else if(studentResponse == correctAnswer) {
			isAnswerCorrect();
			break;
		}
	}
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
}

