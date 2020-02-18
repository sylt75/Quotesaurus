/*
 * Sylvia Tang
 * Monday June 4, 2018
 * ICS3U1-03 Mr.Fernandes
 * Program Name: Quotesaurus
 * 
 * This program allows users to take a short survey asking what kind of quote they are looking for and generates a quote for 
 * the user based on their choices
 * 
 * Features: help hover button, back button to go to previous panel, survey to make quotes more personalized 
 * 
 * Major Skills: the use of arrays, the random function, selection statements, resizing images, 
 * and setting up the GUI along with all its contents
 * 
 * Areas of Concern: The answer for the user's selection of the first question of the survey does not get passed on to the quoteGUI class
 * (when attempted to pass the answer from the survey1 panel to survey2 panel then the quote panel an error occurs, so the program does not 
 * use the answer from survey question 1 to determine which quote to display) 
 */

//test class executes the program
public class QuotesAppTest {
	
	public static void main (String [] args) {
		
		new QuotesAppIntroGUI();
		
	}
}
