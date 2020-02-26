import java.awt.Point;
public class Ball {
	private String colour;
	int size;
	Point pos=new Point();
	double speedx=0.0,speedy=0.0;
	Ball(String a,int s,int x,int y,double sx,double sy){
		colour=a;
		size=s;
		pos.x=x;
		pos.y=y;
		speedx=sx;
		speedy=sy;
	}
	String getcolour() {
		return colour;
	}
	int getsize() {
		return size;
	}
	Point getposition() {
		return pos;
	}
}
