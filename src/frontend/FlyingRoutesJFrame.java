package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlyingRoutesJFrame extends JFrame{

	public FlyingRoutesJFrame() {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (ClassNotFoundException | InstantiationException 
        		| IllegalAccessException | UnsupportedLookAndFeelException ex) {}
		
		this.setTitle("Flying Routes");
		this.setBounds(500, 300, 800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setJMenuBar(new FlyingRoutesMenuBar(null));
		
		add(new FlyingRoutesJPanel());
		
		this.setVisible(true);
	}
}

class FlyingRoutesJPanel extends JPanel {
	
	private PaintingPanel paintingPanel;
	private JScrollPane spPaintingPanel;
	private JTextArea taPath;
	
	public FlyingRoutesJPanel() {
		
		initialize();
	}
	
	private void initialize() {
		
		this.setLayout(new BorderLayout());
		
		taPath = new JTextArea("Da click en el panel para agregar un nodo, "
				+ "al crearlo da click al boton derecho sobre el nodo para abrir el menu desplegable",1, 1);
		taPath.setFont(new Font("Calibri", Font.PLAIN, 20));
		taPath.setEditable(false);
		taPath.setBackground(Color.white);
		taPath.setLineWrap(true);
		
		
		paintingPanel = new PaintingPanel(taPath);
		spPaintingPanel = new JScrollPane(paintingPanel, 
				                       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				                       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.add(taPath, BorderLayout.NORTH);
		this.add(spPaintingPanel, BorderLayout.CENTER);
	}
}
