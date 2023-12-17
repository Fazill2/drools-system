package com.soda.helper;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SodaUI extends JFrame {

	private static final long serialVersionUID = 125549691685141816L;
    private CheckoutCallback callback;
    public boolean answerSubmitted = false;
    public SodaUI t = this;
    
    public SodaUI(CheckoutCallback callback) {
        super("Soda Expert System");
        this.callback = callback;
        initComponents();
        this.setVisible(true);
        // this.callback.checkout();
    }
   
    

	private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        JButton nextButton = new JButton("Proceed to choosing the best drink");

        JPanel panel = new JPanel();
        panel.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.checkout(t);
            }
        });

        getContentPane().add(panel);
    }
	
	public void showRecomendations(String recommendationText) {
        JOptionPane.showMessageDialog(this, recommendationText, "Recommendation", JOptionPane.INFORMATION_MESSAGE);
        // dispose();
	}
	
	public void setAnswerSubmitted(boolean state) {
		answerSubmitted = state;
	}
	
    
    
}
