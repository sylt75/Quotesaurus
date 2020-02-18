import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
/*
 * Sylvia Tang
 * 
 * This class displays the second question to the survey
 */
public class QuotesAppSurvey2 extends JFrame implements ActionListener {

		//contents of the panel
		JPanel surveyGUIPanel = new JPanel();
		JButton quoteButton = new JButton("Get your quote!");
		JLabel surveyPanelLabel = new JLabel("Survey Time!");
		
		JLabel question2Label = new JLabel("What kind of quote are you looking for?");
		JButton backButton = new JButton(new ImageIcon(new ImageIcon("Pics/arrow2.png").getImage().getScaledInstance(50, 50, 0)));
		JRadioButton[] question2RadioButton = new JRadioButton[4];
		ButtonGroup question2ButtonGroup = new ButtonGroup();
		JButton helpButton = new JButton(new ImageIcon(new ImageIcon("Pics/questionMark.jpg").getImage().getScaledInstance(30, 30, 0)));

		//image placed on the panel
		JLabel images1 = new JLabel();
		
		//stores the user's selection from radio buttons
		private static int answer = 4;
		
		//constructor
		public QuotesAppSurvey2() {
			
			frameSetup();
			surveyPanelSetup();
		
		}
		
		//sets the size of frame and makes it visible
		private void frameSetup() {

			setLayout(null);
			setSize(1366, 725);
			setTitle("QUOTESAURUS");
			add(surveyGUIPanel);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//getContentPane().setBackground(Color.PINK);
			
		}

		//creates and places components of the panel (eg. labels, button)
		private void surveyPanelSetup() {
			
			//determines the background image used on the panel
			Random rand = new Random();
			int index = rand.nextInt(4) + 1;
			
			setLayout(null);
			setBounds(50, 50, 1000, 700);
			add(surveyGUIPanel);
			setVisible(true);
			
			//button to go to next panel
			add(quoteButton);
			quoteButton.setBounds(400, 550, 200, 50);		
			quoteButton.addActionListener(this);
			
			add(surveyPanelLabel);
			surveyPanelLabel.setFont(new Font("serif", Font.BOLD, 18));
			surveyPanelLabel.setBounds(25, 0, 200, 100);
			
			images1 = new JLabel(new ImageIcon("Pics/image1.gif"));
			images1.setBounds(50, 300, 240, 160);
			add(images1);
			
			//button to go to previous panel
			add(backButton);
			backButton.setContentAreaFilled(false);
			backButton.setBorderPainted(false);
			backButton.setBounds(300, 550, 50, 50);
			backButton.addActionListener(this);
			
			add(helpButton);
			helpButton.setBounds(953, 0, 30,30);
			
			//https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
			helpButton.setToolTipText("click the arrow button below to go to the previous page");
			
			setupAnswerRadioButtons();

			//sets background image
			JLabel background = new JLabel(new ImageIcon("Pics/background" + index + ".jpg"));
			background.setBounds(0, 0, 1000, 700);
			add(background);
			System.out.println(index);
			
		}

		//creates and places the radio buttons on the panel
		private void setupAnswerRadioButtons() {
			
			//the question to ask the user
			add(question2Label);
			question2Label.setBounds(350, 100, 350, 80);
			question2Label.setFont(new Font("serif", Font.BOLD, 20));
			
			//answers
			question2RadioButton[0] = new JRadioButton("Motivational/Inspirational");
			question2RadioButton[1] = new JRadioButton("For when you're feeling sad");
			question2RadioButton[2] = new JRadioButton("A funny meme");
			question2RadioButton[3] = new JRadioButton("For perfectionists");
			
			//sets the location of the radio buttons on the panel
			for(int qNum = 0; qNum < question2RadioButton.length; qNum++) {
				question2ButtonGroup.add(question2RadioButton[qNum]);
				question2RadioButton[qNum].setBounds(400, 250 + qNum * 60, 300, 25);
				question2RadioButton[qNum].setOpaque(false);
				add(question2RadioButton[qNum]);
				question2RadioButton[qNum].addActionListener(this);	
				
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent event) {
						
			//assigns a number or score to the user's choice
			if (event.getSource() == question2RadioButton[0])
				answer = 0;
			else if (event.getSource() == question2RadioButton[1])
				answer = 1;
			else if (event.getSource() == question2RadioButton[2])
				answer = 2;
			else if (event.getSource() == question2RadioButton[3])
				answer = 3;
			
			//if the quote button is clicked, go to the next panel
			if (event.getSource() == quoteButton) {
			
				setVisible(false);
				new QuoteGUI(answer);
				 
			}
			//if back button is clicked, go to previous panel
			else if (event.getSource() == backButton) {
			
				setVisible(false);
				dispose();
				new QuotesAppSurvey1();
				
			}
			
		}

	}