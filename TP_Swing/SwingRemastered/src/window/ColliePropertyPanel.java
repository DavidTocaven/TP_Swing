/**
 *  The ColliePropertyPanel is a placeholder panel which will be used to
 *	display the properties of selected model elements.
 *
 *  This class implements the singleton design pattern.
 *
 *  @author	K Barclay
 */



package window;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.JTableHeader;



public final class ColliePropertyPanel 		extends JPanel {

    public static ColliePropertyPanel	getColliePropertyPanel()	{ return colliePropertyPanel; }
    
    
    
    protected 				ColliePropertyPanel() {
    	super();
    	//tableau.setValueAt(String , 1, 1);
    	this.add(tableau);
    }
    
    
    
    public void ShowProperties(/* ajouter le tab d'attrib later*/) {
    	
    	
    }
    

 // public 
    
// ---------- properties ----------------------------------

    private static ColliePropertyPanel	colliePropertyPanel = new ColliePropertyPanel();
    JTable tableau = new JTable(4,4);
}	// class ColliePropertyPanel

// ==================================================================
