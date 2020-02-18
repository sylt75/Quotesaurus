import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

/*
 * Sylvia Tang
 * 
 * This class displays the quote chosen for the user
 */
public class QuoteGUI extends JFrame implements ActionListener{

	JPanel quoteGUIPanel = new JPanel();
	JLabel quote = new JLabel();
	JLabel errorLabel = new JLabel("Error- you made an invalid selection");
	
	JLabel[] motivationalQuoteLabelArray = new JLabel[11];
	JLabel[] funnyQuoteLabelArray = new JLabel[6];
	JLabel[] upliftQuoteLabelArray = new JLabel[10];
	JLabel[] perfectionistQuoteLabelArray = new JLabel[5];
	JButton error = new JButton("Error");

	JButton backButton = new JButton(new ImageIcon(new ImageIcon("Pics/arrow2.png").getImage().getScaledInstance(50, 50, 0)));
	
	//constructor
	public QuoteGUI(int answer) {
		
		frameSetup();
		quoteGUIPanelSetup(answer);

	}

	//sets up the szie 
	private void frameSetup() {
		
		setLayout(null);
		setSize(1366, 725);
		setTitle("QUOTESAURUS");
		add(quoteGUIPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	//sets the size of panel and adds it to the frame
	private void quoteGUIPanelSetup(int answer) {
		
		Random rand = new Random();
		int index = rand.nextInt(4) + 1;
		
		setLayout(null);
		setBounds(50, 50, 1000, 700);
		add(quoteGUIPanel);
		setVisible(true);
		
		displayQuote(answer);

		add(backButton);
		
		//https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(100, 550, 50, 50);
		backButton.addActionListener(this);
		
		//background image
		JLabel background = new JLabel(new ImageIcon("Pics/background" + index + ".jpg"));
		background.setBounds(0, 0, 1000, 700);
		add(background);
		
	}
	
	//determines the quote to be displayed to the user
	private void displayQuote(int answer) {
		
		Random randIndex = new Random();
		
		setupQuotes();
		
		System.out.println("Answer:" + answer);

		//displays the quote based on the category chosen in the QuotesAppSurvey2 class
		if (answer == 0) {
			
			int quoteIndex = randIndex.nextInt(11);
			
			motivationalQuoteLabelArray[quoteIndex].setBounds(0, 0, 1000, 700);
			add(motivationalQuoteLabelArray[quoteIndex]);
			
		}
		else if (answer == 1) {
			
			int quoteIndex = randIndex.nextInt(10);
			
			upliftQuoteLabelArray[quoteIndex].setBounds(0, 0, 1000, 700);
			add(upliftQuoteLabelArray[quoteIndex]);

		}
		else if (answer == 2) {
			
			int quoteIndex = randIndex.nextInt(6);
			
			funnyQuoteLabelArray[quoteIndex].setBounds(0, 0, 1000, 700);
			add(funnyQuoteLabelArray[quoteIndex]);

		}
		else if (answer == 3) {
			
			int quoteIndex = randIndex.nextInt(5);
			
			perfectionistQuoteLabelArray[quoteIndex].setBounds(0, 0, 1000, 700);
			add(perfectionistQuoteLabelArray[quoteIndex]);

		}
		else if (answer == 4) {
			
			//displays error message to user
			add(errorLabel);
			errorLabel.setBounds(300, 200, 500, 200);
			errorLabel.setFont(new Font ("san serif", Font.BOLD, 24));
			
		}
		
	}
	
	//assigns quote images to the arrays
	private void setupQuotes() {
				
		//assigns motivational quote images to the label array
		motivationalQuoteLabelArray[0] = new JLabel(new ImageIcon("Pics/motivational0.jpg"));
		motivationalQuoteLabelArray[1] = new JLabel(new ImageIcon("Pics/motivational1.jpg"));
		motivationalQuoteLabelArray[2] = new JLabel(new ImageIcon("Pics/motivational2.jpg"));
		motivationalQuoteLabelArray[3] = new JLabel(new ImageIcon("Pics/motivational3.jpg"));
		motivationalQuoteLabelArray[4] = new JLabel(new ImageIcon("Pics/motivational4.jpg"));
		motivationalQuoteLabelArray[5] = new JLabel(new ImageIcon("Pics/motivational5.jpg"));
		motivationalQuoteLabelArray[6] = new JLabel(new ImageIcon("Pics/motivational6.jpg"));
		motivationalQuoteLabelArray[7] = new JLabel(new ImageIcon("Pics/motivational7.jpg"));
		motivationalQuoteLabelArray[8] = new JLabel(new ImageIcon("Pics/motivational8.jpg"));
		motivationalQuoteLabelArray[9] = new JLabel(new ImageIcon("Pics/motivational9.jpg"));
		motivationalQuoteLabelArray[10] = new JLabel(new ImageIcon("Pics/motivational10.jpg"));
	
		//assigns funny quote images to the label array
		funnyQuoteLabelArray[0] = new JLabel(new ImageIcon("Pics/funnyMeme0.jpg"));
		funnyQuoteLabelArray[1] = new JLabel(new ImageIcon("Pics/funnyMeme1.png"));
		funnyQuoteLabelArray[2] = new JLabel(new ImageIcon("Pics/funnyMeme2.jpg"));
		funnyQuoteLabelArray[3] = new JLabel(new ImageIcon("Pics/funnyMeme3.jpg"));
		funnyQuoteLabelArray[4] = new JLabel(new ImageIcon("Pics/funnyMeme4.jpg"));
		funnyQuoteLabelArray[5] = new JLabel(new ImageIcon("Pics/funnyMeme5.gif"));
	
		//assigns uplifting quote images to the label array
		upliftQuoteLabelArray[0] = new JLabel(new ImageIcon("Pics/uplifting0.jpg"));
		upliftQuoteLabelArray[1] = new JLabel(new ImageIcon("Pics/uplifting1.jpg"));
		upliftQuoteLabelArray[2] = new JLabel(new ImageIcon("Pics/uplifting2.jpg"));
		upliftQuoteLabelArray[3] = new JLabel(new ImageIcon("Pics/uplifting3.jpg"));
		upliftQuoteLabelArray[4] = new JLabel(new ImageIcon("Pics/uplifting4.jpg"));
		upliftQuoteLabelArray[5] = new JLabel(new ImageIcon("Pics/uplifting5.jpg"));
		upliftQuoteLabelArray[6] = new JLabel(new ImageIcon("Pics/uplifting6.jpg"));
		upliftQuoteLabelArray[7] = new JLabel(new ImageIcon("Pics/uplifting7.jpg"));
		upliftQuoteLabelArray[8] = new JLabel(new ImageIcon("Pics/uplifting8.png"));
		upliftQuoteLabelArray[9] = new JLabel(new ImageIcon("Pics/uplifting9.jpg"));

		//assigns perfectionist quote images to the label array
		perfectionistQuoteLabelArray[0] = new JLabel(new ImageIcon("Pics/perfection0.jpg"));
		perfectionistQuoteLabelArray[1] = new JLabel(new ImageIcon("Pics/perfection1.jpg"));
		perfectionistQuoteLabelArray[2] = new JLabel(new ImageIcon("Pics/perfection2.png"));
		perfectionistQuoteLabelArray[3] = new JLabel(new ImageIcon("Pics/perfection3.png"));
		perfectionistQuoteLabelArray[4] = new JLabel(new ImageIcon("Pics/perfection4.jpg"));

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		//go to previous panel if clicked
		if (event.getSource() == backButton) {
			
			setVisible(false);
			dispose();
			new QuotesAppSurvey2();
			
		}
			
	}
	
}
