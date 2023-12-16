package com.soda.helper;

import org.kie.api.runtime.KieSession;

public class CheckoutCallback {
    private KieSession kSession;

    public CheckoutCallback(KieSession kSession) {
        this.kSession = kSession;
        // this.kSession.fireAllRules();
    }

	public void checkout() {
		kSession.fireAllRules();
    }
	
}
