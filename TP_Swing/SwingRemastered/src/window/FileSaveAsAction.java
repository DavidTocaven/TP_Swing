package window;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import dialog.*;

public class FileSaveAsAction extends AbstractAction{

	public FileSaveAsAction(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SaveAs");
		SaveFileAs saveAs = new SaveFileAs();	
	
	}

}
