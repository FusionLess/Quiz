package com.xavier.quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {
	
	String[] questions = {
							"",
							""
						 }; //sets up the question for the quiz
	
	String[][] options = {
							{"", "", "", ""},
							{"", "", "", ""}
						 }; //creates a two-dimensional array for the options to the question
	
	char[] answers = 	 {
							' ',
							' '
						 }; //creates the array for the correct answers to every question
	
	char guess; 
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int results;
	int seconds_remaining = 10;
	
	//^ creates the variables that will be needed
	
	JFrame frame = new JFrame(); //creates a window for the code to run within
	JTextField textfield = new JTextField(); //creates the varaiable for the text field which the questions and any other relating text will go
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
	
	
	public Quiz() { //creates the Quiz constructor (a fancy way of saying a method that will always run when a new object is created)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(true);
		
		textfield.setBounds(0,0,1366,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(64,224,208));
		textfield.setFont(new Font("Sans Seriff",Font.PLAIN,30));
		textfield.setBorder(null);
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textfield.setText("Hello World!");
		
		
		frame.setVisible(true);
		frame.add(textfield);
	}
	public void nextQuestion() { //emthod for generating the next question
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void displayCorrectResult() { //method for displaying the correct result when the answer is either incorrect or correct
		
	}
	public void results() { //method for diplaying the results at the end of the quiz
		
	}

}