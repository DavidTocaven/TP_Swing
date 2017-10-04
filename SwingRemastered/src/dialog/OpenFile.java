package dialog;

import java.io.File;
import java.io.FileNotFoundException;

import diagram.CollaborationDiagram;
import window.CollieModelPanel;

public class OpenFile {

	public void getFileOpen() {
		openFrame = new DialogFrame();
		file = openFrame.DialogFrameFile("Ouvrir un fichier :", DialogFrame.getINPUT_FILE());
		if (file != null) {
			SaveFile.setSaveFichierEnCours(file);
			// load.
		}
	}

	public void openFile() {
		try {
			if (openStream.OpenStream(CollieModelPanel.getCollieModelPanel(), file) == -1) {
				System.out.println("\t\t Error in SaveStream ");
				
			}
			else
			{
				// reset le diagramme avec ce qui a été ouvert
				openStream.getDiagram().resetDiagram(openStream.getDiagram());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private FileStream openStream = new FileStream();
	private DialogFrame openFrame = new DialogFrame();
	private File file;

}
