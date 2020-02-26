import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.*;
public class UIManager {
	public static void main(String args[]) {
		JFrame f1=new JFrame();
		f1.setBackground(new Color(0,0,0));
		f1.setSize(730,800);
		Brick brr[]=new Brick[24];
		int x=0;
		int y=10,h=20,w=80;
		final Random r=new Random();
		for (int i=0;i<24;i++) {
			Color c=new Color(r.nextInt(156)+100,r.nextInt(156)+100,r.nextInt(156)+100,r.nextInt(156)+100);
			Brick b1=new Brick(x,y,h,w,c);
			brr[i]=b1;
			x+=90;
			if(x==720) {
				x=0;
				y+=30;
			}
		}
		Pad p1=new Pad(300,700,50,150,"red");
		Ball b1=new Ball("yellow",30,300,300,2.0,1.0);
		JDialog d = new JDialog(f1, "Sorry"); 
        JLabel l = new JLabel("GAME OVER",SwingConstants.CENTER);
        l.setFont(new Font("serif", Font.BOLD, 20));
        d.add(l);
        d.setSize(200, 100);
        d.setLayout(new FlowLayout());
        d.setLocation(400, 400);
        d.setVisible(false); 
    	JDialog d1 = new JDialog(f1, "Congratulations"); 
        JLabel l1 = new JLabel("YOU WON",SwingConstants.CENTER);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        d1.add(l1);
        d1.setSize(200, 100);
        d1.setLayout(new FlowLayout());
        d1.setLocation(400, 400);
        d1.setVisible(false);
		Gpanel p=new Gpanel(brr,p1,b1,d,d1);	
		p.addKeyListener(p);
		p.setFocusable(true);
		//p.setSize(200,200);
		System.out.println(p);
		f1.add(p);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);		
	}

}
