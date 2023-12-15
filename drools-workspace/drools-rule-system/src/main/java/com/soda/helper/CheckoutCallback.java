package com.soda.helper;

import javax.swing.*;

public class CheckoutCallback {
    private SodaUI sodaUI;
    private int questionNumber = 1;

    public CheckoutCallback() {
        this.sodaUI = new SodaUI(this);
    }

    public void processUserAnswer(String answer) {
        // Logic to process the user's answer
        // Depending on the answer, ask the next question or suggest a soda
        // For example:
        // if (answer.equals("Yes")) {
        //     askNextQuestion();
        // } else {
        //     suggestSoda();
        // }
        setQuestionNumber(getQuestionNumber() + 1);
        askNextQuestion();
    }

    private void askNextQuestion() {
        // Logic to display the next question based on the questionNumber
        // Set the content of the question in the Question object
        // For example:
        // sodaUI.displayQuestion(new Question("Next question content"));
    }

    private void suggestSoda() {
        // Logic to suggest a soda based on the user's answers
        // For example:
        // sodaUI.displaySuggestedSoda("Suggested Soda: Mountain Dew");
    }

    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sodaUI.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new CheckoutCallback().start();
    }

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
}
