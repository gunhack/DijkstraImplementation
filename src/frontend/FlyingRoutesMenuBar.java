package frontend;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class FlyingRoutesMenuBar extends JMenuBar {
	
	private PaintingPanel paintNodesPanel;
	
	public FlyingRoutesMenuBar(PaintingPanel paintNodesPanel) {
		
		this.paintNodesPanel = paintNodesPanel;
		
		initialize();
	}
	
	private void initialize() {
		
		JMenu opMenu1 =  new JMenu("Archivo");
		opMenu1.add(new ActionMenuBar("Salir", "Salir"));
		
		JMenu opMenu2 =  new JMenu("Ayuda");
		opMenu2.add(new ActionMenuBar("Acerca De", "Acerca De"));
		
		this.add(opMenu1);
		this.add(opMenu2);
	}
	
	private class ActionMenuBar extends AbstractAction {
		
		public ActionMenuBar(String nombre, String description) {
			
			putValue(NAME, nombre);
			putValue(SHORT_DESCRIPTION, description);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			switch((String)getValue(NAME)) {
				
				case "Salir":
					System.exit(0);
					break;
				case "Acerca De":
					JOptionPane.showMessageDialog(new JDialog(), "Elaborado por:\nJesus Alfonso Franco Duran", 
					"Acerca de", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:					
					break;
			}
		}
	}
}
