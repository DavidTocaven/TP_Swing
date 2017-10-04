package dialog;

import java.io.File;

public class SaveFileAs {

	public SaveFileAs() {
		
		setFile();
		
		//sauvegarde.checkFile();
		
	}
	
	/*setFile 
	 * 	Ouvre la frame de choix de fichier
	 * 			Si l'utilisateur a choisit un fichier, il le remplace dans la classe SaveFile
	 * */
	public void setFile() { 
		sauvegardeframe = new DialogFrame();
		File file  = sauvegardeframe.DialogFrameFile("Enregistrer sous: ", DialogFrame.getOUTPUT_FILE());
		if(file != null) {
			SaveFile.setSaveFichierEnCours(file);
			sauvegarde.saveTheFile();
		}
		
	}

	
	private SaveFile sauvegarde  = new SaveFile();
	
	private DialogFrame sauvegardeframe = new DialogFrame();

}


