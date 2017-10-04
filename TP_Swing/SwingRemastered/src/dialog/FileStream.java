package dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import diagram.CollaborationDiagram;

public class FileStream implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -65754931429418939L;
	/*	
	 * 
	 * */
	private CollaborationDiagram diagramSave;
	
	public int OpenStream(Object obj, File fileSTatic) throws FileNotFoundException {
		File file = fileSTatic;
		if (file == null) {
			return -1;
		}
		System.out.println("\tTry Savestream file : " + file.getAbsolutePath());
		FileInputStream fichierStream = new FileInputStream(file); // Ouverture du flux

		try {
			System.out.println("\tle fichier va etre ouvert");
			
			ObjectInputStream objInStream = new ObjectInputStream(fichierStream);
			// Ajouter le 03/10
			diagramSave = (CollaborationDiagram) objInStream.readObject();
			
			
			objInStream.close();
			fichierStream.close();
			System.out.println("\t fin OpenStream");
			return 1;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO
		
		
		

		return 0;
	}

	public int SaveStream(Object obj, File fileSTatic) throws FileNotFoundException {
		File file = fileSTatic;
		// Robustesse de la méthode
		if (file == null) {
			return -1;
		}
		System.out.println("\tTry Savestream file : " + file.getAbsolutePath());
		FileOutputStream fichierStream = new FileOutputStream(file); // Ouverture du flux
		try {
			// Robustesse devant existance TODO
			System.out.println("\tle fichier n'existe pas");
			
			diagramSave = CollaborationDiagram.getCollabo();
			ObjectOutputStream objOutStream = new ObjectOutputStream(fichierStream);
			objOutStream.writeObject(diagramSave); // TODO
			objOutStream.close();
			fichierStream.close();
			System.out.println("\t fin SaveStream");
			return 1;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
	
	public CollaborationDiagram getDiagram() {
		return diagramSave;
	}
}
