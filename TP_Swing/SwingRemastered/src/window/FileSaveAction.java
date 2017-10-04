package window;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import dialog.DialogFrame;
import dialog.SaveFile;

public class FileSaveAction extends AbstractAction{

	public FileSaveAction(String string, ImageIcon imageIcon)  {
		// TODO Auto-generated constructor stub
		super(string,imageIcon);
	}

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Save :");
		// Vérifier que le fichier existe sinon le crée
		SaveFile save = new SaveFile();
		save.checkFile();
		save.saveTheFile();
	}


}
