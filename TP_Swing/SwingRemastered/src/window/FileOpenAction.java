package window;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import dialog.OpenFile;

public class FileOpenAction extends AbstractAction {

	public FileOpenAction(String string, ImageIcon imageIcon) {
		// TODO Auto-generated constructor stub
		super(string, imageIcon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Open");
		OpenFile loadFile = new OpenFile();
		loadFile.getFileOpen();
		loadFile.openFile();
	}

}
