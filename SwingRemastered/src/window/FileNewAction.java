package window;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class FileNewAction extends AbstractAction{


	public FileNewAction(String string, ImageIcon imageIcon) {
		// TODO Auto-generated constructor stub
		super(string, imageIcon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("New");
		
	}

	

}
