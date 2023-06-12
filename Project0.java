/**
 * Date: 2/13/2023
 * Name: Maira Bermeo
 * This program serves as a counter for lower and upper case e's. In a for loop a user will be asked to input
 * a sentence. The code will then call the method labeled "counter" to look at each individual character 
 * in order to see if any words contain a lower or upper case "e" and add it to its respected counter. 
 * At the end of each user input it will tell  them how many of each were in the sentence and then reset
 * so it can count the next sentence input. In order to stop the program the user must type in "Stop"
 * but the cases will be ignored so any form of the word "Stop" the code will break from the for loop and 
 * stop running. 
 */
import javax.swing.*;

public class Project0{
	public static void main(String[] args){
		//ask for an an input from the user
		String sentence = JOptionPane.showInputDialog(null, "Please enter a sentence:");
		//utilizes while loop to allow the code to continuously run and ends it when condition isn't met
		while (!(sentence.equalsIgnoreCase("Stop"))) {
			// when user inputs any version of "Stop" the program will stop
			if(sentence.equalsIgnoreCase("Stop")) {
				break;
			}
			counter(sentence);
			//input new sentence 
			sentence = JOptionPane.showInputDialog(null, "Please enter a sentence:");

		}
	}
	// method to count all of the lower and upper case e's
	public static void counter(String input) {
		int upperC = 0, lowerC=0;
		//goes through each character entered 
		for(int i=0; i<input.length(); i++){
			//checks if there is an upper case "E" and adds it upper case counter
			if(input.charAt(i)=='E'){
					upperC++;
			}
			//checks if there is a lower case "e" and adds it lower case counter
			if(input.charAt(i)=='e'){
				lowerC++;
			}
		}
		// outputs the amount of lower and upper case e's
		JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowerC + "\n" +"Number of upper case case e's: "+ upperC);
		//reset counters
		upperC = 0; 
		lowerC=0;
	}
		
}
