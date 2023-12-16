package com.soda.helper;

import javax.swing.*;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CheckoutCallback {
    private KieSession kSession;

    public CheckoutCallback(KieSession kSession) {
        this.kSession = kSession;
        // this.kSession.fireAllRules();
    }

	public void checkout() {
		kSession.fireAllRules();
		System.out.println("Rules fired");
    }
	
}
