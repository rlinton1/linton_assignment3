// The program shall generate random numbers with a SecureRandom object
// The program shall ask the student to solve a multiplication problem
// A multiplication problem shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
// The program shall display the message "Very good!" if the student provides a correct response
// The program shall display the message "No. Please try again." if the student provides an incorrect response
// The program shall terminate when a correct response is provided by the student
// The program shall continue to ask the student to solve the original multiplication problem until the student provides the correct answer
// Create a method called "quiz" that contains the program logic
// Create a method called "askQuestion" that prints the problem to the screen
// Create a method called "readResponse" that reads the answer from the student
// Create a method called "isAsnwerCorrect" that checks to see if the student's answer matches the correct answer to the problem
// Create a method called "displayCorrectResponse" that prints out the response when a student enters a correct answer
// Create a method called "displayInorrectResponse" that prints out the response when a student enters an incorrect answer
// Create a main method that runs your program by calling the "quiz" method
package linton_problem1;
import java.security.SecureRandom;

import java.util.Scanner;
import java.util.*;

public class CAI1 {
	public static void main(String[] args)
	{
		quiz();
		int correctAnswer;
		int answer;
		String decision;
	}		
// create method to generate the arithmetic logic.
public static void quiz()
		{
	// initialize the secure random variable
	SecureRandom rand = new SecureRandom();
	int num1, num2;		

	// Generate random numbers less than 10
	 num1 = rand.nextInt(10);
	 num2 = rand.nextInt(10);

	// to determine the expected answer
	int correctAnswer = num1 * num2;
	int studentResponse = 0;
	
	 while(true)
	 {
	 askQuestion(num1,num2);
	 // read the response of the student
	 studentResponse = readResponse();
	 if(isAnswerCorrect(correctAnswer,studentResponse))
	 {
		 displayCorrectResponse(); 
	 break;
	 }
	 else 
	 {
		displayIncorrectResponse(); 
	 }
	 }
		}	
public static int readResponse()
{
	// create scanner to enter inputs &
	// declare variables for this method
	Scanner sc = new Scanner(System.in);
	// ask the student for an answer &
	// record input.
	System.out.print("\nyour answer: ");
	int	answer = sc.nextInt();
			return answer;
	}
 // call a method to generate the question
public static void askQuestion(int num1, int num2)
{
	 System.out.println("How much is " + num1 + " times " + num2 + "?");
	}
public static boolean isAnswerCorrect(int correctAnswer,int studentResponse)
{
	return correctAnswer == studentResponse;
	
}
public static void displayCorrectResponse()
{
	System.out.println("Very Good! ");	
	}
public static void displayIncorrectResponse()
{
	System.out.println("No. Please try again. ");
	}
}
