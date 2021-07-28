package com.xavier.quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {
	
	String[] questions = {
							"What is the greatest programming language of all?",
							""
						 }; //sets up the question for the quiz
	
	String[][] options = {
							{"Python", "Java", "Web Assembly", "Rust"},
							{"", "", "", ""}
						 }; //creates a two-dimensional array for the options to the question
	
	char[] answers = 	 {
							'B',
							' '
						 }; //creates the array for the correct answers to every question
	
	char guess; 
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int results;
	int seconds = 10;
	
	//^ creates the variables that will be needed
	
	Main main = new Main();
	
	JFrame frame = new JFrame(); //creates a window for the code to run within
	JTextField textfield = new JTextField(); //creates the varaiable for the text field which the questions and any other relating text will go
	JTextArea textarea = new JTextArea(); //creates a variable for area where text will be filled
	JButton buttonA = new JButton(); //creates a variable for the A button
	JButton buttonB = new JButton(); //creates a variable for the B button
	JButton buttonC = new JButton(); //creates a variable for the C button
	JButton buttonD = new JButton(); //creates a variable for the D button
	JButton playAgain = new JButton();
	JLabel answer_labelA = new JLabel(); //creates a variable for the label for button A
	JLabel answer_labelB = new JLabel(); //creates a variable for the label for button B
	JLabel answer_labelC = new JLabel(); //creates a variable for the label for button C
	JLabel answer_labelD = new JLabel(); //creates a variable for the label for button D
	JLabel time_label = new JLabel(); //creates a variable for the word "timer" above the amount of time you have left
	JLabel seconds_left = new JLabel(); //creates the variable for the countdown timer (the seconds you have left)
	JTextField number_right = new JTextField(); //creates a variable for the number of questions you got correct
	JTextField percentage = new JTextField(); //creates a variable for telling you what percentage of the quiz you got correct
	
	Timer timer = new Timer(1000, new ActionListener() { //when the timer reaches 1000 miliseconds, it will execute the @Override method
		
		@Override
		public void actionPerformed(ActionEvent e) { //this method is performed or used for flipping the colour back to its original colour after the colour has been changed from red to green (this is to ensure it doesn't show the correct answer)
			seconds--; //decrements seconds every one second
			seconds_left.setText(String.valueOf(seconds)); //converts the integer "seconds_left" to a string for display
			if(seconds <= 0) { // once the seconds hit zero, the program calls the "displayCorrectAnswer" method
				displayCorrectResult(); //calls the displayCorrectAnswer method
			}
		}
	});
	
	
	public Quiz() { //creates the Quiz constructor (a fancy way of saying a method that will always run when a new object is created)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //tells the program to exit on pressing the x button
		frame.setSize(650, 650); //sets the size of the window (formatted as width, height in pixels)
		frame.getContentPane().setBackground(new Color(50,50,50)); //sets the background colour of the window(formatted as R, G, B in the brackets)
		frame.setLayout(null); //allows the program to have defined sizes for objects such as the window sizes, button sizes etc.
		frame.setResizable(false); //doesn't allow the window to be resized (just allows for neater formatting)
		
		textfield.setBounds(0, 0, 650, 45); //sets the size of the title boundaries for the title text (formatted as x, y, width, height)
		textfield.setBackground(new Color(25,25,25)); //sets the colour of the title background (formatted as R, G, B)
		textfield.setForeground(new Color(255, 255, 255)); //sets the colour of the text (the foreground)
		textfield.setFont(new Font("Comic Sans",Font.PLAIN,30)); //sets the font, the font style and the font size
		textfield.setBorder(null); //sets the border around the title box (of which there is none)
		textfield.setHorizontalAlignment(JTextField.CENTER); //aligns the text in within the title box
		textfield.setEditable(false); //defines if the text can be edited, this case it is false therefore the text cannot be
		textfield.setText(""); //sets the text to be displayed in the title box of the program
		
		textarea.setBounds(0, 50, 650, 45); //sets the size of the quesion box (just below the title box (formmated as x, y, width, height))
		textarea.setLineWrap(true); //defines if the text can be wrapped in the given boundaries (in this case it can be)
		textarea.setBackground(new Color(25, 25, 25)); //sets the colour of the background the text will go on (formatted as R, G, B)
		textarea.setForeground(new Color(255, 255, 255)); //sets the colour of the text (formatted as R, G, B)
		textarea.setFont(new Font("Comic Sans",Font.PLAIN,25)); //sets the font, the style of the font and thje size
		textarea.setBorder(null); //sets the border around the the question box (in this case it is null)
		textarea.setEditable(false); //defines if the text within the box can be edited (in this case it cannot be)
		textarea.setText(""); //sets the text within the given boundaries
		
		buttonA.setBounds(0, 100, 100, 100); //sets the size of the the box for button A (formatted as x, y, width, height)
		buttonA.setFont(new Font("Comic Sans", Font.PLAIN, 35)); //sets the font used the text within the given boundaries of the A box
		buttonA.setFocusable(false); //more of a cosmetic thing; doesn't allow for the text inside the box to be "focused" on or for windows or the operating system to take away your focus from a foreground app
		buttonA.addActionListener(this); //listens for the action of clicking on the set boundaries or the clicking on the button within the set boundaries
		buttonA.setText("Ⓐ"); //sets the text within the box of A
		buttonA.setBackground(new Color(80, 80, 80));
		buttonA.setForeground(new Color(255, 255, 255));
		buttonA.setBorder(BorderFactory.createBevelBorder(1));
		
		buttonB.setBounds(535, 100, 100, 100); //as for the A button
		buttonB.setFont(new Font("Comic Sans", Font.PLAIN, 35)); //as for the A button
		buttonB.setFocusable(false); //as for the A button
		buttonB.addActionListener(this); //as for the A button
		buttonB.setText("Ⓑ"); //as for the A button
		buttonB.setBackground(new Color(80, 80, 80));
		buttonB.setForeground(new Color(255, 255, 255));
		buttonB.setBorder(BorderFactory.createBevelBorder(1));
		
		buttonC.setBounds(0, 300, 100, 100); //as for the A button
		buttonC.setFont(new Font("Comic Sans", Font.PLAIN, 35)); //as for the A button
		buttonC.setFocusable(false); //as for the A button
		buttonC.addActionListener(this); //as for the A button
		buttonC.setText("Ⓒ"); //as for the A button
		buttonC.setBackground(new Color(80, 80, 80));
		buttonC.setForeground(new Color(255, 255, 255));
		buttonC.setBorder(BorderFactory.createBevelBorder(1));
		
		buttonD.setBounds(535, 300, 100, 100); //as for the A button
		buttonD.setFont(new Font("Comic Sans", Font.PLAIN, 35)); //as for the A button
		buttonD.setFocusable(false); //as for the A button
		buttonD.addActionListener(this); //as for the A button
		buttonD.setText("Ⓓ"); //as for the A button
		buttonD.setBackground(new Color(80, 80, 80));
		buttonD.setForeground(new Color(255, 255, 255));
		buttonD.setBorder(BorderFactory.createBevelBorder(1));
		
		playAgain.setBounds(400, 400, 100, 100); //x, y, width, height
		playAgain.setFont(new Font("Comic Sans", Font.PLAIN, 35)); 
		playAgain.setFocusable(false); 
		playAgain.addActionListener(this); 
		playAgain.setText("Play Again");
		playAgain.setBackground(new Color(80, 80, 80));
		playAgain.setForeground(new Color(255, 255, 255));
		playAgain.setBorder(BorderFactory.createBevelBorder(1));
		
		answer_labelA.setBounds(0, 200, 500, 75); //defines the boundaries for the answer next to the A button (formatted as a x, y, width, height in pixels)
		answer_labelA.setBackground(new Color (50, 50, 50)); //sets the colour for the rectangle (in this case it is the same as the background for blending purposes (formatted as R, G, B))
		answer_labelA.setForeground(new Color(132, 216, 198)); //sets the colour of the text (foramtted as R, G, B)
		answer_labelA.setFont(new Font("Comic Sans", Font.ITALIC, 35)); //sets the font, the style and the size
		
		answer_labelB.setBounds(535, 200, 500, 75); //as for answer_labelA
		answer_labelB.setBackground(new Color (50, 50, 50)); //as for answer_labelA
		answer_labelB.setForeground(new Color(132, 216, 198)); //as for answer_labelA
		answer_labelB.setFont(new Font("Comic Sans", Font.ITALIC, 35)); //as for answer_labelA
		
		answer_labelC.setBounds(0, 375, 500, 100); //as for answer_labelA
		answer_labelC.setBackground(new Color (50, 50, 50)); //as for answer_labelA
		answer_labelC.setForeground(new Color(132, 216, 198)); //as for answer_labelA
		answer_labelC.setFont(new Font("Comic Sans", Font.ITALIC, 35)); //as for answer_labelA
		
		answer_labelD.setBounds(535, 375, 500, 100); //as for answer_labelA
		answer_labelD.setBackground(new Color (50, 50, 50)); //as for answer_labelA
		answer_labelD.setForeground(new Color(132, 216, 198)); //as for answer_labelA
		answer_labelD.setFont(new Font("Comic Sans", Font.ITALIC, 35)); //as for answer_labelA
		
		seconds_left.setBounds(535, 510, 100, 100); //sets the boundaries for the timer rectangle (formatted as x, y, width, height)
		seconds_left.setBackground(new Color(25, 25, 25)); //sets the colour of the timer box (formatted as R, G, B)
		seconds_left.setForeground(new Color(255, 0, 0)); //sets the colour of the text within the box (in this case the time left (formatted as R, G, B))
		seconds_left.setFont(new Font("Comic Sans", Font.PLAIN, 60)); //sets the font, size and style of the time remaining
		seconds_left.setBorder(BorderFactory.createBevelBorder(1)); //creates a border around the timer rectangle defined earlier (not a very noticeable effect)
		seconds_left.setOpaque(true); //sets the rectangle defined to be opaque or not (the value is true meaning the rectangle is opaque)
		seconds_left.setHorizontalAlignment(JTextField.CENTER); //aligns the text within the box (in this case it is centered)
		seconds_left.setText(String.valueOf(seconds)); //converts the integer "seconds" (defined on line 30) to a string for display purposes
		
		time_label.setBounds(535, 475, 100, 25); //sets the boundaries for label of the timer (formatted as x, y, width, height)
		time_label.setBackground(new Color(50, 50, 50)); //sets the background of the rectangle (formatted as R, G, B)
		time_label.setForeground(new Color(255, 0, 0)); //sets the colour of the text "timer:" (formatted as R, G, B)
		time_label.setFont(new Font("Comic Sans", Font.PLAIN, 20)); //sets the font, style and size 
		time_label.setHorizontalAlignment(JTextField.CENTER); //centers the text within the rectangle of the boundaries
		time_label.setText("Timer:"); //prints the text with the given defintions to where it is supposed to go
		
		number_right.setBounds(225, 225, 200, 100); //sets the boundaries for the amount of questions correct rectangle that will show at the end of the quiz
		number_right.setBackground(new Color(25, 25, 25)); //sets the colour of the rectangle
		number_right.setForeground(new Color(25, 255, 0)); //sets the colour of the text
		number_right.setFont(new Font("Comic Sans", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Comic Sans", Font.BOLD, 50));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.setVisible(true); //allows the window to be seen and become visible
		frame.add(time_label); //adds the time_label boundaries set to the window 
		frame.add(seconds_left); //adds the seconds_left boundaries set to the window
		frame.add(answer_labelA); //adds the label or answer for the A button to the window
		frame.add(answer_labelB); //adds the label or answer for the B button to the window
		frame.add(answer_labelC); //adds the label or answer for the C button to the window
		frame.add(answer_labelD); //adds the label or answer for the D button to the window
		frame.add(buttonA); //adds the A button to the window with it's defined values to the window
		frame.add(buttonB); //adds the A button to the window with it's defined values to the window
		frame.add(buttonC); //adds the A button to the window with it's defined values to the window
		frame.add(buttonD); //adds the A button to the window with it's defined values to the window
		frame.add(textarea); //adds the the question text and its rectangle to the window
		frame.add(textfield); //adds the title and its rectangle to the the window
		
		nextQuestion();
	}
	public void nextQuestion() { //emthod for generating the next question
		
		if (index >= total_questions) {
			results(); //if the amount of questions that have been asked are now equal to the amount of questions there are in the quiz, the quiz will call the results method and display how well you did
		}
		else {
			textfield.setText("Question " + (index + 1)); //increments the question (changes the textfield variable (the area where the question is displayed) and changes the question to the next one) if the previous statement is false
			textarea.setText(questions[index]); //displays the question from the "questions" array
			answer_labelA.setText(options[index][0]); //accesses the first object in the two-dimensional array "options" for display next to the "Ⓐ" button
			answer_labelB.setText(options[index][1]); //accesses the second object in the two-dimensional array "options" for display next to the "Ⓑ" button
			answer_labelC.setText(options[index][2]); //accesses the third object in the two-dimensional array "options" for display next to the "Ⓒ" button
			answer_labelD.setText(options[index][3]); //accesses the fourth object in the two-dimensional array "options" for display next to the "Ⓓ" button
			timer.start();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) { //method for listening for when a button is pressed
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource() == buttonA) { //checks if the user clicked on button A
				answer = 'A'; //sets the users answer to A
				if (answer == answers[index]) { //checks to see if the users answer is the same as the answer stored in the index
					correct_guesses++; //increments the number earlier defined for "correct_guesses" by one
				}
			}
			
			if(e.getSource() == buttonB) { //checks if the user clicked on button B
				answer = 'B'; //sets the users answer to B
				if (answer == answers[index]) { //checks to see if the users answer is the same as the answer stored in the index
					correct_guesses++; //increments the number earlier defined for "correct_guesses" by one
				}
			}
			
			if(e.getSource() == buttonC) { //checks if the user clicked on button C
				answer = 'C'; //sets the users answer to C
				if (answer == answers[index]) { //checks to see if the users answer is the same as the answer stored in the index
					correct_guesses++; //increments the number earlier defined for "correct_guesses" by one
				}
			}
			
			if(e.getSource() == buttonD) { //checks if the user clicked on button D
				answer = 'D'; //sets the users answer to D
				if (answer == answers[index]) { //checks to see if the users answer is the same as the answer stored in the index
					correct_guesses++; //increments the number earlier defined for "correct_guesses" by one
				}
			}
			
			if (e.getSource() == playAgain) {
				answer = 'P';
				if (answer == 'p') {
					return;
				}
			}
			displayCorrectResult(); //calls "displayCorrectResult" method for the display of the correct answer
	}
	public void displayCorrectResult() { //method for displaying the correct result when the answer is either incorrect or correct
		
		timer.stop();
		
		buttonA.setEnabled(false); //disables button A so you can't click on the button multiple times and answer the question multiple times
		buttonB.setEnabled(false); //disables button B so you can't click on the button multiple times and answer the question multiple times
		buttonC.setEnabled(false); //disables button C so you can't click on the button multiple times and answer the question multiple times
		buttonD.setEnabled(false); //disables button D so you can't click on the button multiple times and answer the question multiple times
		
		if(answers[index] != 'A') //if the answer in the index does not equal 'A', this method will execute
			answer_labelA.setForeground(new Color(255, 0, 0)); //changes the color of the label next to A to red if the answer is incorrect
		
		if(answers[index] != 'B') //if the answer in the index does not equal 'B', this method will execute
			answer_labelB.setForeground(new Color(255, 0, 0)); //changes the color of the label next to B to red if the answer is incorrect
		
		if(answers[index] != 'C') //if the answer in the index does not equal 'C', this method will execute
			answer_labelC.setForeground(new Color(255, 0, 0)); //changes the color of the label next to C to red if the answer is incorrect

		if(answers[index] != 'D') //if the answer in the index does not equal 'D', this method will execute
			answer_labelD.setForeground(new Color(255, 0, 0)); //changes the color of the label next to D to red if the answer is incorrect
		
		Timer pause = new Timer(2000, new ActionListener() { //when the timer reaches 2000 miliseconds, it will execute the @Override method
			
			@Override
			public void actionPerformed(ActionEvent e) { //this method is performed or used for flipping the colour back to its original colour after the colour has been changed from red to green (this is to ensure it doesn't show the correct answer)
				
				answer_labelA.setForeground(new Color(132, 216, 198)); //changes the colour back to green
				answer_labelB.setForeground(new Color(132, 216, 198)); //changes the colour back to green
				answer_labelC.setForeground(new Color(132, 216, 198)); //changes the colour back to green
				answer_labelD.setForeground(new Color(132, 216, 198)); //changes the colour back to green
				
				answer = ' '; //resets the answer to the question
				seconds = 10; //resets timer
				seconds_left.setText(String.valueOf(seconds)); //converts the seconds_left variable back to a string for display once more
				buttonA.setEnabled(true); //re-enables the button for answering of the next question
				buttonB.setEnabled(true); //re-enables the button for answering of the next question
				buttonC.setEnabled(true); //re-enables the button for answering of the next question
				buttonD.setEnabled(true); //re-enables the button for answering of the next question
				index++; //displays the next question by incrementing the index counter by one
				nextQuestion(); //calls the nextQuestion method 
			}
		});
		pause.setRepeats(false); //stops the timer (for switching colours from red to green) from running every two seconds and displaying the correct answer
		pause.start(); //starts the timer again
		
	}
	public void results() { //method for diplaying the results at the end of the quiz
		
		buttonA.setEnabled(false); //disables the buttons to stop people from pressing the buttons once the results have been displayed
		buttonB.setEnabled(false); //disables the buttons to stop people from pressing the buttons once the results have been displayed
		buttonC.setEnabled(false); //disables the buttons to stop people from pressing the buttons once the results have been displayed
		buttonD.setEnabled(false); //disables the buttons to stop people from pressing the buttons once the results have been displayed
		
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
		frame.add(playAgain);
		
	}

}