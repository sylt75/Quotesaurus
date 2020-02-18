import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/*
 * Sylvia Tang
 * 
 * This class displays the first survey question to the user
 */
public class QuotesAppSurvey1 extends JFrame implements ActionListener {

	//contents of the panel
	JPanel surveyGUIPanel = new JPanel();
	JButton surveyButton = new JButton("Next");
	JLabel surveyPanelLabel = new JLabel("Survey Time!");
	
	JLabel question1Label = new JLabel("How are you feeling right now?");
	JRadioButton[] question1RadioButton = new JRadioButton[3];
	ButtonGroup question1ButtonGroup = new ButtonGroup();
	
	JLabel image1 = new JLabel(new ImageIcon(new ImageIcon("Pics/smiling.gif").getImage().getScaledInstance(100, 100, 0))); 
	JLabel image2 = new JLabel(new ImageIcon(new ImageIcon("Pics/sad.gif").getImage().getScaledInstance(100, 100, 0)));
		
	//constructor
	public QuotesAppSurvey1() {
		
		frameSetup();
		surveyPanelSetup();
	
	}
	
	//sets the size of frame and makes it visible
	private void frameSetup() {
		
		setVisible(true);
		setLayout(null);
		setSize(1366, 725);
		setTitle("QUOTESAURUS");
		add(surveyGUIPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	//sets up the panel and places it on the frame
	private void surveyPanelSetup() {
		
		//generates a random number to determine the background image placed on the panel
		Random rand = new Random();
		int index = rand.nextInt(4) + 1;
		
		//set up panel
		setLayout(null);
		setBounds(50, 50, 1000, 700);
		add(surveyGUIPanel);
		surveyGUIPanel.setVisible(true);
		
		//set up the button
		add(surveyButton);
		surveyButton.setBounds(400, 550, 200, 50);
		surveyButton.addActionListener(this);
		
		add(surveyPanelLabel);
		surveyPanelLabel.setFont(new Font("serif", Font.BOLD, 18));
		surveyPanelLabel.setBounds(25, 0, 200, 60);
		
		setupAnswerRadioButtons();

		add(image1);
		image1.setBounds(700, 200, 100, 100);
		
		add(image2);
		image2.setBounds(160, 350, 100, 100);
		
		//adds background image to panel
		JLabel background = new JLabel(new ImageIcon("Pics/background" + index + ".jpg"));
		background.setBounds(0, 0, 1000, 700);
		add(background);
		System.out.println(index);

	}

	//creates the radio buttons and places them onto the panel
	private void setupAnswerRadioButtons() {
		
		//displays the question to ask the user
		add(question1Label);
		question1Label.setBounds(355, 100, 280, 80);
		question1Label.setFont(new Font("serif", Font.BOLD, 20));
		
		//sets the choices for the answer to the question
		question1RadioButton[0] = new JRadioButton("Sad");
		question1RadioButton[1] = new JRadioButton("Unmotivated");
		question1RadioButton[2] = new JRadioButton("Burned Out/Frustrated");

		//sets location of the radio buttons on the panel
		for(int qNum = 0; qNum < question1RadioButton.length; qNum++) {
			question1ButtonGroup.add(question1RadioButton[qNum]);
			question1RadioButton[qNum].setBounds(400, 250 + qNum * 60, 300, 25);
			question1RadioButton[qNum].setOpaque(false);
			add(question1RadioButton[qNum]);
			question1RadioButton[qNum].addActionListener(this);	
			
		}
			
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		int answer1;
		
		//assigns a number or score to the user's choice 
		if (event.getSource() == question1RadioButton[0])
			answer1 = 0;
		else if (event.getSource() == question1RadioButton[1])
			answer1 = 1;
		else if (event.getSource() == question1RadioButton[2])
			answer1 = 2;
		
		//if the button is clicked, go to the next panel
		if (event.getSource() == surveyButton) {
			setVisible(false);
			new QuotesAppSurvey2();
			
		}
		
	}

}
