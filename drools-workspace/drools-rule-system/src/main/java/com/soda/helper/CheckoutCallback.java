package com.soda.helper;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CheckoutCallback {
    KieContainer kcontainer;
    JTextArea output;

    public CheckoutCallback(KieContainer kcontainer) {
        this.kcontainer = kcontainer;
    }
    
    public void setOutput(JTextArea output) {
        this.output = output;
    }
    
    public String checkout(JFrame frame) {

        //add the JFrame to the ApplicationData to allow for user interaction

        // From the container, a session is created based on  
        // its definition and configuration in the META-INF/kmodule.xml file 
        KieSession ksession = kcontainer.newKieSession("Soda");
        
        ksession.setGlobal( "frame",
                            frame );
        ksession.setGlobal( "textArea",
                            this.output );

        ksession.fireAllRules();

        //returns the state of the cart
        return "Yes";
    }
}
