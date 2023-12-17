package com.soda.helper;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class SodaHelper {
	
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	    
            CheckoutCallback cc = new CheckoutCallback(kContainer);
            SodaUI ui = new SodaUI(cc);
            // kSession.insert(ui);
            // kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
