package com.soda.helper;

import javax.swing.*;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CheckoutCallback {
    private int questionNumber = 1;
    private KieSession kSession;

    public CheckoutCallback(KieSession kSession) {
        this.kSession = kSession;
        // this.kSession.fireAllRules();
    }
    

	public void checkout() {
		if (this.kSession == null)
			System.out.println("AAAAAAAAA");
		System.out.println(kSession.toString());
    	this.kSession.fireAllRules();

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


	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
}
