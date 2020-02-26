import java.awt.*;
public class Brick {
	private Point pos=new Point();
	private Dimension d=new Dimension();
	private Color c1;
	private boolean isvisible=true;
	public Brick(int x1,int y1,int h1,int w1,Color c) {
		this.pos.x=x1;
		this.pos.y=y1;
		this.d.height=h1;
		this.d.width=w1;
		this.c1=c;
	}
	public Point getposition() {
		return pos;
	}
	public Dimension getsize() {
		return d;
	}
	public Color getcolour() {
		return c1;
	}
	public void setvisible(boolean x) {
		isvisible=x;
	}
	public boolean getvisible() {
		return isvisible;
	}
}
