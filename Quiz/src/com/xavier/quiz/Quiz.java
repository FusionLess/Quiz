package com.xavier.quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener {
	
	String[] questions = {
							"Which internet company began life as an online bookstore called Cadabra?",
							"Whistler was the codename of this Microsoft Operating System?",
							"Moore's law originally stated that the number of transistors on a microprocessor chip would double every...",
							"Which programming language was developed by Sun Microsystems?",
							"Which of these people was NOT a founder of Apple Inc?",
							"What does the term GPU stand for?",
							"What was the first Android version specifically optimized for tablets?",
							"What is the number of keys on a standard Windows Keyboard?",
							"Unix Time is defined as the number of seconds that have elapsed since when?",
							"The name of technology company HP stands for what?",
							"What is the correct term for the metal object in between the CPU and the CPU fan within a computer system?",
							"In the programming language \"Python\", which of these statements would display the string \"Hello World\" correctly?",
							"In programming, the ternary operator is mostly defined with what symbol(s)?",
							"Which coding language was the #1 programming language in terms of usage on GitHub in 2015?",
							"Generally, which component of a computer draws the most power?"
						 }; // creates array of questions
	
	String[][] options = {
							{"eBay", "Overstock", "Shopify", "Amazon"},
							{"Windows 2000","Windows 7","Windows 95", "Windows XP"},
							{"Year", "Decade", "Month", "Four years"},
							{"Python", "C++", "Java", "Swift"},
							{"Jonathan Ive", "Steve Jobs","Ronald Wayne","Steve Wozniak"},
							{"Gaming Processor Unit","Graphite Producing Unit", "Graphics Processing Unit", "Graphical Proprietary Unit"},
							{"Eclair", "Honeycomb", "Froyo","Marshmellow"},
							{"104", "56", "69", "114"},
							{"Midnight, September 11, 2001","Midnight, April 20, 1969","Midnight, July 4, 1980", "Midnight, January 1, 1970"},
							{"Howard Packmann", "Hewlett-Packard", "Husker-Pollosk","Hellman-Pohl"},
							{"CPU Vent","Temperature Decipator","Heat Vent", "Heat Sink"},
							{"print(\"hello world\")", "console.log\"Hello World\")","echo \"Hello World\"","printf(\"Hello World\")"},
							{"??","if then","!", "?"},
							{"PHP", "C#", "JavaScript", "Python"},
							{"CPU", "Hard drive", "Power Supply", "Graphics Card"}
						 }; // creates array of selectable answers
	
	char[] answers = 	 {
							'D',
							'D',
							'A',
							'C',
							'A',
							'C',
							'B',
							'A',
							'D',
							'B',
							'D',
							'A',
							'D',
							'C',
							'C',
						 }; // creates the array of coorect answers

	
	char guess; 
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int results;
	int seconds = 10;
	
	Main main = new Main();
	
	JFrame frame = new JFrame(); 
	JTextField textfield = new JTextField(); 
	JTextArea textarea = new JTextArea(); 
	JButton buttonA = new JButton(); 
	JButton buttonB = new JButton(); 
	JButton buttonC = new JButton(); 
	JButton buttonD = new JButton(); 
	JLabel answer_labelA = new JLabel(); 
	JLabel answer_labelB = new JLabel(); 
	JLabel answer_labelC = new JLabel(); 
	JLabel answer_labelD = new JLabel(); 
	JLabel time_label = new JLabel(); 
	JLabel seconds_left = new JLabel(); 
	JTextField number_right = new JTextField(); 
	JTextField percentage = new JTextField();
	// sets up variables for the buttons, title, questions, the seconds left and percentage displayed at the end of the quiz
	
	Timer timer = new Timer(1000, new ActionListener() { //sets up the timer to decrement every 1000 milliseconds (one second)
		
		@Override
		public void actionPerformed(ActionEvent e) { 
			seconds--; 
			seconds_left.setText(String.valueOf(seconds)); 
			if(seconds <= 0) { 
				displayCorrectResult(); 
			} // decrements the timer until it hits zero in which it will call the displayCorrectResult method
		}
	});
	
	
	public Quiz() { 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(1000, 650); 
		frame.getContentPane().setBackground(new Color(0, 0, 0)); 
		frame.setLayout(null); 
		frame.setResizable(false); 
		// sets up the size of the window, the colour, whether it is resizable and its size.
		
		textfield.setBounds(0, 0, 1000, 45); 
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(255, 255, 255));
		textfield.setFont(new Font("Comic Sans",Font.PLAIN,30));
		textfield.setBorder(null);
		textfield.setHorizontalAlignment(JTextField.CENTER); 
		textfield.setEditable(false); 
		textfield.setText(""); 
		// sets up the title box, its colour, its size, its text, whether its editable and the alignment
		
		textarea.setBounds(0, 50, 1000, 90); 
		textarea.setLineWrap(true); 
		textarea.setBackground(new Color(25, 25, 25)); 
		textarea.setForeground(new Color(255, 255, 255)); 
		textarea.setFont(new Font("Comic Sans",Font.PLAIN,25));
		textarea.setBorder(null);
		textarea.setEditable(false);
		textarea.setText("");
		// sets up the question box with similar attributes to the title
		
		buttonA.setBounds(20, 160, 475, 100);
		buttonA.setFont(new Font("Comic Sans", Font.PLAIN, 35)); 
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("Ⓐ"); 
		buttonA.setBackground(new Color(80, 80, 80));
		buttonA.setForeground(new Color(255, 255, 255));
		buttonA.setBorder(BorderFactory.createBevelBorder(1));
		// sets the properties for the A button. Same as for buttonB, buttonC and buttonD
		
		buttonB.setBounds(490, 160, 475, 100);
		buttonB.setFont(new Font("Comic Sans", Font.PLAIN, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("Ⓑ"); 
		buttonB.setBackground(new Color(80, 80, 80));
		buttonB.setForeground(new Color(255, 255, 255));
		buttonB.setBorder(BorderFactory.createBevelBorder(1));
		
		buttonC.setBounds(20, 360, 475, 100); 
		buttonC.setFont(new Font("Comic Sans", Font.PLAIN, 35)); 
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("Ⓒ");
		buttonC.setBackground(new Color(80, 80, 80));
		buttonC.setForeground(new Color(255, 255, 255));
		buttonC.setBorder(BorderFactory.createBevelBorder(1));
		
		buttonD.setBounds(490, 360, 475, 100); 
		buttonD.setFont(new Font("Comic Sans", Font.PLAIN, 35)); 
		buttonD.setFocusable(false); 
		buttonD.addActionListener(this);
		buttonD.setText("Ⓓ");
		buttonD.setBackground(new Color(80, 80, 80));
		buttonD.setForeground(new Color(255, 255, 255));
		buttonD.setBorder(BorderFactory.createBevelBorder(1));
		
		answer_labelA.setBounds(20, 245, 500, 75); 
		answer_labelA.setBackground(new Color (50, 50, 50));
		answer_labelA.setForeground(new Color(132, 216, 198)); 
		answer_labelA.setFont(new Font("Comic Sans", Font.ITALIC, 35));
		// creates the label next to buttonA for display of the text. Same as for answer_labelB, C and D
		
		answer_labelB.setBounds(490, 245, 500, 75); 
		answer_labelB.setBackground(new Color (50, 50, 50)); 
		answer_labelB.setForeground(new Color(132, 216, 198)); 
		answer_labelB.setFont(new Font("Comic Sans", Font.ITALIC, 35)); 
		
		answer_labelC.setBounds(20, 445, 500, 75); 
		answer_labelC.setBackground(new Color (50, 50, 50)); 
		answer_labelC.setForeground(new Color(132, 216, 198)); 
		answer_labelC.setFont(new Font("Comic Sans", Font.ITALIC, 35));
		
		answer_labelD.setBounds(490, 445, 500, 75); 
		answer_labelD.setBackground(new Color (50, 50, 50)); 
		answer_labelD.setForeground(new Color(132, 216, 198)); 
		answer_labelD.setFont(new Font("Comic Sans", Font.ITALIC, 35)); 
		
		seconds_left.setBounds(875, 510, 100, 100); 
		seconds_left.setBackground(new Color(25, 25, 25)); 
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("Comic Sans", Font.PLAIN, 60)); 
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER); 
		seconds_left.setText(String.valueOf(seconds));
		// creates the seconds timer and its box for display
		
		time_label.setBounds(775, 540, 100, 25); 
		time_label.setBackground(new Color(50, 50, 50));
		time_label.setForeground(new Color(255, 0, 0)); 
		time_label.setFont(new Font("Comic Sans", Font.PLAIN, 28));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("Timer:");
		// creates the red "Timer:" label next to the seconds_left box
		
		number_right.setBounds(290, 50, 200, 90); 
		number_right.setBackground(new Color(25, 25, 25)); 
		number_right.setForeground(new Color(25, 255, 0)); 
		number_right.setFont(new Font("Comic Sans", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		// creates the number_right box at the end of the quiz
		
		percentage.setBounds(490, 50, 200, 90);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Comic Sans", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		// creates the percentage box at the end of the quiz for display next to the number_right box
		
		frame.setVisible(true); 
		frame.add(time_label); 
		frame.add(seconds_left);  
		frame.add(answer_labelA); 
		frame.add(answer_labelB); 
		frame.add(answer_labelC); 
		frame.add(answer_labelD); 
		frame.add(buttonA); 
		frame.add(buttonB); 
		frame.add(buttonC); 
		frame.add(buttonD); 
		frame.add(textarea); 
		frame.add(textfield); 
		// adds everything defined above it to the window
		
		nextQuestion(); // calls the nextQuestion() method
	}
	public void nextQuestion() { // method responsible for generating the next question
		
		if (index >= total_questions) {
			results(); // if the index is equal to 15, the method of results() will be called displaying the number_right and percentage right
		}
		else {
			textfield.setText("Question " + (index + 1)); 
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]); 
			answer_labelB.setText(options[index][1]); 
			answer_labelC.setText(options[index][2]); 
			answer_labelD.setText(options[index][3]); 
			timer.start();
			// modifies the "textarea" so it can display the next question
		}
		
	}
	@Override // interrupts the code to perform a specific action. In this case, to listen for a mouse click event
	public void actionPerformed(ActionEvent e) { 
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			// disables the buttons so you cannot click them twice once you've guessed an answer
			
			if(e.getSource() == buttonA) { 
				answer = 'A'; 
				if (answer == answers[index]) { 
					correct_guesses++; 
				} // if the answer is A, the amount of correct_guesses increments by one. As for B, C and D
			}
			
			if(e.getSource() == buttonB) { 
				answer = 'B'; 
				if (answer == answers[index]) { 
					correct_guesses++; 
				}
			}
			
			if(e.getSource() == buttonC) { 
				answer = 'C'; 
				if (answer == answers[index]) {
					correct_guesses++;
				}
			}
			
			if(e.getSource() == buttonD) { 
				answer = 'D';
				if (answer == answers[index]) { 
					correct_guesses++; 
				}
			}

			displayCorrectResult(); //calls the displayCorrectResult method
	}
	public void displayCorrectResult() { 
		
		timer.stop(); // stops the timer once a button has been pressed
		
		buttonA.setEnabled(false); 
		buttonB.setEnabled(false); 
		buttonC.setEnabled(false); 
		buttonD.setEnabled(false); 
		// disables the buttons once again to display the correct results so you cannot change your answer once you've selected your answer
		
		if(answers[index] != 'A') 
			answer_labelA.setForeground(new Color(255, 0, 0));
		// flips the colour of the answer_lablelA from turquoise (its original colour) to red in the even that A is not the answer. As for B, C and D
		
		if(answers[index] != 'B') 
			answer_labelB.setForeground(new Color(255, 0, 0)); 
		
		if(answers[index] != 'C') 
			answer_labelC.setForeground(new Color(255, 0, 0));

		if(answers[index] != 'D') 
			answer_labelD.setForeground(new Color(255, 0, 0));
		
		Timer pause = new Timer(2000, new ActionListener() { // creates a timer for flipping the colour back to turquoise in the event that colour was flipped to red. Changes the colour back after 2000 milliseconds or two seconds
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				
				answer_labelA.setForeground(new Color(132, 216, 198)); // defines the colour that the timer needs to flip back to after a button was pressed. As for A, B, C and D
				answer_labelB.setForeground(new Color(132, 216, 198)); 
				answer_labelC.setForeground(new Color(132, 216, 198)); 
				answer_labelD.setForeground(new Color(132, 216, 198)); 
				
				answer = ' '; 
				seconds = 10; 
				seconds_left.setText(String.valueOf(seconds)); // converts the integer value of seconds_left from an integer to a string for display  
				buttonA.setEnabled(true); 
				buttonB.setEnabled(true); 
				buttonC.setEnabled(true); 
				buttonD.setEnabled(true); 
				index++; // increments the index
				nextQuestion();
			}
		});
		pause.setRepeats(false); 
		pause.start(); 
		
	}
	public void results() { // results method
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		// disables the buttons once the quiz is over and shows the result
		
		results = (int)((correct_guesses / (double)total_questions) * 100);
		
		textfield.setText("RESULTS");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
		percentage.setText(results + "%");
		
		frame.add(percentage);
		frame.add(number_right);
		// adds the two functions to the window at the end
		
	}
}