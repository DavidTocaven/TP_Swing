package window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowExit extends WindowAdapter{
	
	public void windowClosing(WindowEvent e){
		System.out.println("Fin");
		System.exit(0);
		
	}

}
