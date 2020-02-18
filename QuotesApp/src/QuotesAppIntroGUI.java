import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/*
 * Sylvia Tang
 * 
 * this GUI panel introduces the app to user
 */
public class QuotesAppIntroGUI extends JFrame implements ActionListener {

	//contents of the panel 
	JPanel introGUIPanel = new JPanel();
	JLabel titleLabel = new JLabel("Welcome to Quotesaurus!");
	
	//html editing for labels and changing their font taught by Tammy
	JLabel instructionLabel = new JLabel("<html>Take a small survey and choose the category <br> of quotes you want for a personalized one! <br> Hover over the question mark during the survey <br> for help<html>");
	JLabel introImage = new JLabel(new ImageIcon("Pics/introImage.gif"));
	JLabel background = new JLabel(new ImageIcon("Pics/background0.jpg"));
	JButton surveyButton = new JButton("Start the survey");
	
	//constructor
	public QuotesAppIntroGUI() {
		
		frameSetup();
		introGUIPanelSetup();

	}

	private void frameSetup() {
		
		//sets the size and makes the frame visible
		setSize(1366, 725);
		setTitle("QUOTESAURUS");
		setLayout(null);
		add(introGUIPanel);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setBackground(Color.PINK);

	}
	
	//sets up the panel and its contents 
	private void introGUIPanelSetup() {
		
		//creates the panel in the frame
		setLayout(null);
		setBounds(50, 50, 1000, 700);
		add(introGUIPanel);
		setVisible(true);
		
		//setup title label and add it to the panel 
		add(titleLabel);
		titleLabel.setBounds(350, 15, 400, 50);
		titleLabel.setFont(new Font("serif", Font.BOLD, 24));
		
		//sets up label for description of the program
		add(instructionLabel);
		instructionLabel.setFont(new Font("serif", Font.PLAIN, 22));
		instructionLabel.setBounds(300, 30, 500, 200);

		//setup the survey button that goes to the next GUI panel
		add(surveyButton);
		surveyButton.setBounds(400, 600, 200, 50);
		surveyButton.addActionListener(this);
		
		add(introImage);
		introImage.setBounds(150, 200, 700, 400);
		
		add(background);
		background.setBounds(0, 0, 1000, 700);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		//if the button is clicked, go to the next panel
		if (event.getSource() == surveyButton) {
			
			setVisible(false);
			new QuotesAppSurvey1();
			
		}
	
	}
	
}
