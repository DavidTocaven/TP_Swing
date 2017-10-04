package dialog;

import javax.swing.JOptionPane;

import window.CollieDiagramPanel;

public class DeleteInstanceDialog {
	
	/*	Instancie
	 * **/
	public DeleteInstanceDialog() {
		System.out.println("Delete dialog");
		choice = JOptionPane.showConfirmDialog(CollieDiagramPanel.getCollieDiagramPanel(), "Voulez_vous supprimer cette instance ?",
				"Supprimer ?!?", JOptionPane.WARNING_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		
	}
	
	public int isChoice() {
		return choice;
	}

	private int choice;
}
