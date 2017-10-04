package diagram;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dialog.DeleteInstanceDialog;

public class DeleteInstance{

	JMenuItem item_DeleteInstance = new JMenuItem("Delete Instance");
	
	public DeleteInstance() {
    	// Afficher les attributs
    	item_DeleteInstance.addActionListener(
    		new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					DeleteInstanceDialog deleteDialog = new DeleteInstanceDialog();
					if(deleteDialog.isChoice() == JOptionPane.OK_OPTION) {
						System.out.println("Delete Instance");
						//  TODO
						
					}
				}
		});
	}
	
	public JMenuItem getItem() {
		return item_DeleteInstance;
	}
}