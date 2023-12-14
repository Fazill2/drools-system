package com.soda.helper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.soda.helper.CheckoutCallback;

public class SodaUI extends JPanel {
    private JTextArea output;
    private CheckoutCallback callback;

    public SodaUI(CheckoutCallback callback) {
        super(new BorderLayout());
        this.callback = callback;
        JPanel checkoutPane = new JPanel();
        JButton button = new JButton( "Checkout" );

        button.addMouseListener( new CheckoutButtonHandler() );
        button.setActionCommand( "checkout" );
        checkoutPane.add( button );
        output = new JTextArea( 1,
                                    10 );
            output.setEditable( false );
        JScrollPane outputPane = new JScrollPane( output,
                                                      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                                      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        checkoutPane.add( outputPane );
        this.add(checkoutPane);
        this.callback.setOutput( this.output );
    }

    public void createAndShowGUI(boolean exitOnClose) {
        //Create and set up the window.
        JFrame frame = new JFrame( "Soda Helper" );
        frame.setDefaultCloseOperation(exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);

        setOpaque( true );
        frame.setContentPane( this );

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null); // Center in screen
        frame.setVisible( true );
    }
    
    private class CheckoutButtonHandler extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton) e.getComponent();
            callback.checkout( (JFrame) button.getTopLevelAncestor());
        }
    }

    
}
