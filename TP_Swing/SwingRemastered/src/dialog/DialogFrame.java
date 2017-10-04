package dialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class DialogFrame {
	
	public DialogFrame() {
		frame = new JFrame();
		fChoice = new JFileChooser();
	}
	/*	DialogFrameFile : permet l'ouverture d'une fenetre de choix de fichier
	 * 						in : titre de la fenetre
	 * 						in : IO pour entrees ou sortie
	 * 								1 pour input file (choixir un fichier)
	 * 								2 pour out file (créer un fichier)
	 * 						out : File 
	 * */
	public File DialogFrameFile(String titre, int IO) {
		File file = null;
		fChoice.setDialogTitle(titre);
		// Filtrage des fichiers
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte (.txt)", "txt");
		fChoice.addChoosableFileFilter(filter);
		fChoice.setAcceptAllFileFilterUsed(false);
		fChoice.setFileFilter(filter);
		switch(IO)
		{
		case(1) :
			fChoice.setDialogType(fChoice.OPEN_DIALOG);
		break;
		case(2) : 
			fChoice.setDialogType(fChoice.SAVE_DIALOG);
			break;
		default :
			return null;
		}
		
		// Ouverture de la fenêtre
		userSelection = fChoice.showOpenDialog(frame);
		
				// Vérification du choix de l'utilisateur
		if(userSelection == JFileChooser.APPROVE_OPTION) {
			System.out.println("\t adresse et nom:" + fChoice.getSelectedFile().getAbsolutePath());
			file = new File(fChoice.getSelectedFile().getAbsolutePath());
			return file;
		}
		else {
			return null;
		}
		
		
	}
	

	
	public static int getOUTPUT_FILE() {
		return OUTPUT_FILE;
	}

	public static int getINPUT_FILE() {
		return INPUT_FILE;
	}
	private int userSelection;
	private JFrame frame;
	private JFileChooser fChoice;
	private static int OUTPUT_FILE = 2;
	private static int INPUT_FILE = 1;
	
}

