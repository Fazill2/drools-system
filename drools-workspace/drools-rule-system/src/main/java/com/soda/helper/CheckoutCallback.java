package com.soda.helper;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CheckoutCallback {
    private KieSession kSession;
    private KieContainer kContainer;
    public CheckoutCallback(KieContainer kContainer) {
    	this.kContainer = kContainer;
        
        
        // this.kSession.fireAllRules();
    }

	public void checkout(SodaUI ui) {
		kSession = kContainer.newKieSession("ksession-rules");
		kSession.insert(ui);
		kSession.fireAllRules();
    }
	
}
