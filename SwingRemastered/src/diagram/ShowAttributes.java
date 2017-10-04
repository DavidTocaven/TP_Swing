package diagram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ShowAttributes{

	JMenuItem item_Sattributs = new JMenuItem("Show Attributes");
	public ShowAttributes() {
    	// Afficher les attributs
    	item_Sattributs.addActionListener(
    		new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Show Attributes");				
				}
		});
	}
	
	public JMenuItem getItem() {
		return item_Sattributs;
	}
}
