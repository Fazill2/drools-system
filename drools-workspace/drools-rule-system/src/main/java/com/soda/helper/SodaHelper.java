package com.soda.helper;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

import com.sample.DroolsTest.Message;

public class SodaHelper {
	
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            CheckoutCallback cc = new CheckoutCallback(kContainer);
            SodaUI ui = new SodaUI(cc);
            ui.createAndShowGUI(true);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
