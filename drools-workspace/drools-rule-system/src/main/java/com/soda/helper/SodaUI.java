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
    public boolean answerSubmitted = false;
    
    
    public SodaUI(CheckoutCallback callback) {
        super("Soda Expert System");
        this.callback = callback;
        initComponents();
        this.setVisible(true);
        this.callback.checkout();
    }
   
    
    public SodaUI(String questionString, String[] answers) throws HeadlessException {
		super();
		this.question = new JLabel(questionString);
		this.answerComboBox = new JComboBox<>(answers);
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        JButton nextButton = new JButton("Next");

        JPanel panel = new JPanel();
        panel.add(question);
        panel.add(answerComboBox);
        panel.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.checkout();
            }
        });

        getContentPane().add(panel);
    }
	
	public void showRecomendations(String recommendationText) {
        JOptionPane.showMessageDialog(this, recommendationText, "Recommendation", JOptionPane.INFORMATION_MESSAGE);
        dispose();
	}

	public String getQuestionString() {
		return question.getText();
	}
	
	public void setQuestionString(String text) {
		question.setText(text);
	}
	
	public void setPossibleAnswers(String[] answers) {
		this.answerComboBox = new JComboBox<>(answers);
	}
	
	public String getSelectedAnswer() {
		return (String) this.answerComboBox.getSelectedItem();
	}
	
	public void setAnswerSubmitted(boolean state) {
		answerSubmitted = state;
	}
	
    
    
}
