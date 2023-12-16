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
    	    KieSession kSession = kContainer.newKieSession("ksession-rules");
            CheckoutCallback cc = new CheckoutCallback(kSession);
            SodaUI ui = new SodaUI(cc);
            kSession.insert(ui);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
