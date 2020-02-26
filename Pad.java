import java.awt.*;
public class Pad {
	private Dimension d=new Dimension();
	Point p=new Point();
	private String colour;
	public Pad(int x1,int y1,int h1,int w1,String b) {
		d.height=h1;
		d.width=w1;
		p.x=x1;
		p.y=y1;
		colour=b;
	}
	public Dimension getsize() {
		return d;
	}
	public Point getposition() {
		return p;
	}
	public String getcolor() {
		return colour;
	}
	void moveleft() {
		p.x-=20;
	}
	void moveright() {
		p.x+=20;
	}
}
