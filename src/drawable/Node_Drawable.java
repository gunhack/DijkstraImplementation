package drawable;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

public class Node_Drawable {
	
	boolean selected;
	private int diameter;
	private int x, y;  
	private String text;
	private Ellipse2D.Double circle;
	private Stroke stroke;
	private Color background;
	
	public Node_Drawable() { this(0, 0, 10, ""); }
	
	public Node_Drawable(int x, int y, int diameter, String text) {
		
		this.selected = false;
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.text = text;
		
		initialize();
	}
	
	public void initialize() {
		
		background = Color.BLUE;
		circle = new Ellipse2D.Double(calculate(x), calculate(y), diameter, diameter);
		stroke = new BasicStroke(3.0f,  BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	}
	
	private double calculate(int val) {
		
		return ((double)val - diameter/2);
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
        g2d.setColor(background);        
        circle.setFrame(calculate(x), calculate(y), diameter, diameter);
        g2d.fill(circle);
        
        g2d.setStroke(stroke);
        g2d.setColor(Color.BLACK);
        g2d.draw(circle);
        
        double textFix = (8 * text.length());
        g2d.setFont(new Font("Calibri", Font.PLAIN, 19));
		g2d.drawString(text, x - ((int)textFix / 2), y + diameter);
	}
	
	private double middlePoint(int v1, int v2) {
		return ((v1 + v2)/2);
	}
	
	public void changeColor() {
		
		selected = !selected;
		
		if(selected) {
			
			background = Color.GREEN;
		}else {
			
			background = Color.BLUE;
		}
	}
	
	public boolean isMouseOver(double x, double y) {
		
		return circle.contains(x, y);
	}
	
	public void setPosition(int x, int y) {
			
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
