package drawable;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Connector_Drawable {
	
	private int x1, y1, x2, y2, barb, src, dest;
	private float width;
	private double edgeWeight, phi;
	private String text;
	private Line2D line;
	private Rectangle2D weightBox = null;
	private BasicStroke stroke;
	private Color color;
	
	public Connector_Drawable(int x1, int y1, int x2, int y2, int src, int dest, double edgeWeight) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.src = src;
		this.dest = dest;
		this.width = 5.0f;
		this.edgeWeight = edgeWeight;
		
		initialize();		
	}
	
	public void initialize() {
		
		phi = Math.toRadians(40);
        barb = 25;
		color = Color.black;
		stroke = new BasicStroke(width , BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		line = new Line2D.Double(x1, y1, x2, y2);		
		weightBox = new Rectangle2D.Double(0, 0, 0, 0);
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g; 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
		line.setLine(x1, y1, x2, y2);
		
		g2d.setColor(color);
		g2d.setStroke(stroke);
		g2d.draw(line);		
		
		if(edgeWeight > -1) {
			
			text = edgeWeight + "";
			
			double midX = middlePoint(x1, x2);
			double midY = middlePoint(y1, y2);			
			double textFix = (10 * text.length());
			
			weightBox.setFrame(midX - textFix/2, midY - 10, textFix, 20);
			
			g2d.draw(weightBox);
			g2d.setColor(Color.blue);
			g2d.fill(weightBox);
			g2d.setColor(Color.black);
			g2d.setFont(new Font("Calibri", Font.PLAIN, 19));
			g2d.drawString(text, (int)(midX - textFix/2) + 2, (int)midY + 7);
			drawArrowHead(g2d, getReasonPoint(new Point(x1, y1), new Point(x2, y2), 14), new Point(x1, y1), color);
		} else {
			
			drawArrowHead(g2d, new Point(x2, y2), new Point(x1, y1), color);
		}
	}
	
	public void changeColor(boolean op) {
		
		if(op) {
						
			color = Color.red;
			
		} else {
			
			color = Color.BLACK;
		}
	}
	
	private double middlePoint(int v1, int v2) {
		return ((v1 + v2)/2);
	}
	
	private Point getReasonPoint(Point p1, Point p2, double r) {
		
		double x = (p1.x + (p2.x * r))/(1 + r);
		double y = (p1.y + (p2.y * r))/(1 + r);
		
		return new Point((int)x, (int)y);
	}
    
	private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color) {
		
        g2.setPaint(color);
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        double theta = Math.atan2(dy, dx);
        //System.out.println("theta = " + Math.toDegrees(theta));
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++) {
        	
            x = tip.x - barb * Math.cos(rho);
            y = tip.y - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
            rho = theta - phi;
        }
    }
	
	public boolean isMouseOver(int x, int y) {
		
		return line.intersects(x - 5, y - 5, width + 5, width + 5) || weightBox.contains(x, y);
	}
	
	public void setCoords(int x1, int y1, int x2, int y2) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public double getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(double edgeWeight) {
		this.edgeWeight = edgeWeight;
	}
}
