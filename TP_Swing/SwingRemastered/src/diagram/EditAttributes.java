package diagram;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class EditAttributes{

	JMenuItem item_Sattributs = new JMenuItem("Edit Attributes");
	public EditAttributes() {
    	// Afficher les attributs
    	item_Sattributs.addActionListener(
    		new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Edit Attributes");				
				}
		});
	}
	
	public JMenuItem getItem() {
		return item_Sattributs;
	}
}