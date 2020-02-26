import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Gpanel extends JPanel implements ActionListener,KeyListener {
	Brick b2[];
	Pad p2;
	Ball ba2;
	JDialog d3;
	JDialog d4;
	private static final int UPDATE_RATE = 30;
	public Gpanel(Brick b3[],Pad p3,Ball ba3,JDialog s1,JDialog s2) {
		b2=b3;
		p2=p3;
		ba2=ba3;
		d3=s1;
		d4=s2;
		super.setPreferredSize(new Dimension(730, 800));
        super.setBackground(Color.BLACK);
	}
	public void paint(Graphics g1) {
		Graphics2D g=(Graphics2D)g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		for (Brick i:b2) {
			if(i.getvisible()) {
				g.draw3DRect(i.getposition().x,i.getposition().y,i.getsize().width,i.getsize().height,true);
				g.setColor(i.getcolour());
				g.fillRect(i.getposition().x,i.getposition().y,i.getsize().width,i.getsize().height);
			}
		}
		g.setColor(Color.RED);
		//g.drawOval(p2.getposition().x-p2.getsize().width/2, p2.getposition().y-p2.getsize().height/2, p2.getsize().width, p2.getsize().height);
		g.fillOval(p2.getposition().x, p2.getposition().y, p2.getsize().width, p2.getsize().height);
		g.setColor(Color.yellow);
		g.drawOval(ba2.getposition().x, ba2.getposition().y, ba2.getsize(), ba2.getsize());
		g.fillOval(ba2.getposition().x, ba2.getposition().y, ba2.getsize(), ba2.getsize());
		move1();
	}
	public void actionPerformed(ActionEvent e) {
		p2.moveleft();
		System.out.println(p2.getposition().x);
		repaint();	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		;
		
	}
	int count=0;
	public void move1() {
		Thread ballthread=new Thread() {
		public void run() {
			while(true) {
				ba2.pos.x+=ba2.speedx;
				ba2.pos.y+=ba2.speedy;
				if((ba2.pos.x<10) ||(ba2.pos.x>680)) {
					ba2.speedx=-ba2.speedx;
				}
				if(ba2.pos.y<10) {
					ba2.speedy=-ba2.speedy;
				}
				if(ba2.pos.y>730) {
					System.out.println("Game Over");
					d3.setVisible(true);
					while(true) {}
					//System.exit(0);
				}
				
				for(Brick i:b2) {
					if((i.getposition().x-5<ba2.pos.x)&&(ba2.pos.x<(i.getposition().x+i.getsize().width))&&(ba2.getposition().y>=i.getposition().y)&&(ba2.getposition().y<=i.getposition().y+i.getsize().height)&&(i.getvisible()==true)) {
						i.setvisible(false);
						ba2.speedy=-ba2.speedy;
						ba2.speedx=-ba2.speedx;
						System.out.println("Brick");
						count++;
						System.out.println(count);
					}
				}
				if(count==24) {
					d4.setVisible(true);
					while(true) {}
				}
				
				if((20<(ba2.pos.x-p2.p.x)&&(80>(ba2.pos.x-p2.p.x))&&((p2.p.y-ba2.pos.y)<15))){
					ba2.speedy=-ba2.speedy;
				}
				if((0<(ba2.pos.x-p2.p.x)&&(20>(ba2.pos.x-p2.p.x))&&((p2.p.y-ba2.pos.y)<15))){
					ba2.speedy=-ba2.speedy;
					if(ba2.speedx>0) {
						ba2.speedx=-ba2.speedx;
					}
				}
				if((80<(ba2.pos.x-p2.p.x)&&(100>(ba2.pos.x-p2.p.x))&&((p2.p.y-ba2.pos.y)<15))){
					ba2.speedy=-ba2.speedy;
					if(ba2.speedx<0) {
						ba2.speedx=-ba2.speedx;
					}
				}
				repaint();
				try {
					Thread.sleep(9999999);
				}
				
				catch(Exception e) {}
				}
			}
		};
		ballthread.start();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==37) {
			p2.moveleft();
		}
		if(key==39) {
			p2.moveright();
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		;
		
	}

}
