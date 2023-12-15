package com.soda.helper;

import javax.swing.*;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SodaUI extends JFrame {

	private static final long serialVersionUID = 125549691685141816L;
	private JLabel question = new JLabel("Are you ready? ");
	private JComboBox<String> answerComboBox = new JComboBox<>(new String[]{"Yes", "No"});
    private CheckoutCallback callback;

    public SodaUI(CheckoutCallback callback) {
        super("Soda Expert System");
        this.callback = callback;
        initComponents();
    }
    
    

    public SodaUI(JLabel question, JComboBox<String> answerComboBox) throws HeadlessException {
		super();
		this.question = question;
		this.answerComboBox = answerComboBox;
	}
    
    public SodaUI(String questionString) throws HeadlessException {
		super();
		this.question = new JLabel(questionString);
		this.answerComboBox = new JComboBox<>(new String[]{"Yes", "No"});
	}

	private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        answerComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        JButton nextButton = new JButton("Next");

        JPanel panel = new JPanel();
        panel.add(question);
        panel.add(answerComboBox);
        panel.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAnswer = (String) answerComboBox.getSelectedItem();
                callback.processUserAnswer(selectedAnswer);
                System.out.println("Question: "+ question.getText() + "| Answer: "+selectedAnswer);
            }
        });

        getContentPane().add(panel);
    }

	public String getQuestionString() {
		return question.getText();
	}
	
	public void setQuestionString(String text) {
		question.setText(text);
	}
    
    
}
