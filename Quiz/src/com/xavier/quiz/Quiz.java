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
	int seconds = 10;
	
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
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0, 0, 1366, 50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(64,224,208));
		textfield.setFont(new Font("Sans Seriff",Font.PLAIN,30));
		textfield.setBorder(null);
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0, 50, 1366, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(64,224,208));
		textarea.setFont(new Font("Sans Seriff",Font.PLAIN,25));
		textarea.setBorder(null);
		textarea.setEditable(false);
		
		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("Ⓐ");
		
		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("Ⓑ");
		
		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("Ⓒ");
		
		buttonD.setBounds(0, 400, 100, 100);
		buttonD.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("Ⓓ");
		
		answer_labelA.setBounds(125, 100, 500, 100);
		answer_labelA.setBackground(new Color (50, 50, 50));
		answer_labelA.setForeground(new Color(25, 255, 0));
		answer_labelA.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		
		answer_labelB.setBounds(125, 200, 500, 100);
		answer_labelB.setBackground(new Color (50, 50, 50));
		answer_labelB.setForeground(new Color(25, 255, 0));
		answer_labelB.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		
		answer_labelC.setBounds(125, 300, 500, 100);
		answer_labelC.setBackground(new Color (50, 50, 50));
		answer_labelC.setForeground(new Color(25, 255, 0));
		answer_labelC.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		
		answer_labelD.setBounds(125, 400, 500, 100);
		answer_labelD.setBackground(new Color (50, 50, 50));
		answer_labelD.setForeground(new Color(25, 255, 0));
		answer_labelD.setFont(new Font("Sans Seriff", Font.PLAIN, 35));
		
		seconds_left.setBounds(535, 510, 100, 100);
		seconds_left.setBackground(new Color(25, 25, 25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("sans seriff", Font.PLAIN, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535, 475, 100, 25);
		time_label.setBackground(new Color(50, 50, 50));
		time_label.setForeground(new Color(255, 0, 0));
		time_label.setFont(new Font("Sans Seriff", Font.PLAIN, 20));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("Timer:");
		
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