package diagram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class EditInstances {
	private JMenuItem item_name = new JMenuItem("Edit Instance");
	
	public EditInstances() {
		// Changer le Nom
		item_name.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Edit Instances");				
				}
		});
	}
	
	public JMenuItem getItem() {
		return item_name;
	}
	
	

}
