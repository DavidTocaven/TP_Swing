package window;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class FileExitAction extends AbstractAction{

	public FileExitAction(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Exit");
		System.exit(0);
		}

}
