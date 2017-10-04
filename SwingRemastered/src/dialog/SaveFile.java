package dialog;

import java.io.File;
import java.io.FileNotFoundException;

import window.CollieModelPanel;

public class SaveFile {
	
	public SaveFile() {
						
	}
	
	
	/*	checkFile :Si le fichier n'existe pas
	 * 								ouvre une fenetre de dialogue est met en place le fichier
	 * 								retourne 1 si le fichier en cours n'existe pas
	 * 			sinon : 	suprimme le fichier
	 * 						retourne 0
	 * */
	public boolean checkFile() { 
		System.out.println("Fichier en cours : " +fichierEncours.getAbsolutePath());
		if (!fichierEncours.exists()) { // V�rification du fichier existant
			sauveframe= new DialogFrame();
			
			// Actualisation 
			fichierEncours = sauveframe.DialogFrameFile("Enregistrer : ", DialogFrame.getOUTPUT_FILE());
			return true;
		}
		else {
			fichierEncours.delete();
			System.out.println("\tFichier Supprim�e : "+fichierEncours.getAbsolutePath());
			return false;
		}
	}
	/*
	 *   S�curise la sauvegarde de fichier
	 * */
	public void saveTheFile() {
		try {
			System.out.println("\tSauver objet");
			if(sauveStream.SaveStream(CollieModelPanel.getCollieModelPanel(), fichierEncours)==-1) {
				System.out.println("\t\t Error in SaveStream ");
				fichierEncours = new File("");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setSaveFichierEnCours(File f) {
		fichierEncours = f;
	}
	
	private FileStream sauveStream = new FileStream();
	private static File fichierEncours = new File("");
	private DialogFrame sauveframe = new DialogFrame();

}
