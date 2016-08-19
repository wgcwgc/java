package wgc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings({ "serial", "unused" })
public class Wgc extends JFrame implements KeyListener{
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	public static final int NORTH = 4;
	public static final int MOVING = 5;
	public static final int DEAD = 6;

	private int state;
	private int direction;
	private int headx;
	private int heady;
	private int tailx;
	private int taily;
	private int foodx;
	private int foody;
	private int score;
	private int[][] blocks;
	private int sleepTime = 500;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawString("·ÖÊý£º" + this.score, 30, 40);
		g.fillRect(foodx * 25 + 5, foody * 25 + 5, 25, 25);
		
		g.setColor(Color.YELLOW);
//		g.fillRect(25 * headx + 5,  25 * heady + 5, 25, 25);
		g.fillRoundRect(25 * headx + 5,  25 * heady + 5, 25, 25, 100 , 100);
//		g.fill3DRect(25 * headx + 5,  25 * heady + 5, 25, 25, true);
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				if(blocks[i][j] != 0){
					g.fillRect(25 * i + 5,  25 * j + 5, 25, 25);
				}
			}
		}
	}
	
	public Wgc(){
		this.addKeyListener(this);
		this.setSize(510, 510);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ì°³ÔÉß");
	}

	public void startMoving(){
		this.state = MOVING;
		this.direction = EAST;
		this.headx = 3;
		this.heady = 10;
		this.tailx = 1;
		this.taily = 10;
		this.score = 0;
		this.blocks = new int[20][20];
		blocks[1][10] = EAST;
		blocks[2][10] = EAST;
		locateFood();
		while(this.state == MOVING){
			try {
				
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(this.foodx == this.headx && this.foody == this.heady){
				locateFood();
				score ++;
				if(sleepTime > 100 && score % 2 == 0)
					sleepTime -= 200;
			}else{
				int d = this.blocks[tailx][taily];
				this.blocks[tailx][taily] = 0;
				switch (d) {
				case EAST:
					tailx++;
					break;
				case WEST:
					tailx--;
					break;
				case SOUTH:
					taily++;
					break;
				case NORTH:
					taily--;
					break;
				}
			}
			
			this.blocks[headx][heady] = this.direction;
			switch (this.direction) {
			case EAST:
				headx++;
				break;
			case WEST:
				headx--;
				break;
			case SOUTH:
				heady++;
				break;
			case NORTH:
				heady--;
				break;
			}
			
			if(headx < 0 || headx > 19 || heady < 1 || heady > 19 || blocks[headx][heady] != 0){
				this.state = DEAD;
				break;
			}
			
			
			repaint();
		}
		
		JOptionPane.showMessageDialog(null, "GAME OVER!");
	}
	
	public void locateFood(){
		do{
			this.foodx = (int)(Math.random() * 20);           //      0<=(int)(x*20)<=19
			this.foody = (int)(Math.random() * 19 + 1);
		}while(this.foodx == this.headx && this.foody == this.heady || blocks[foodx][foody] != 0);
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			if(this.direction != SOUTH)
				this.direction = NORTH;
			break;
		case KeyEvent.VK_DOWN:
			if(this.direction != NORTH)
				this.direction = SOUTH;
			break;
		case KeyEvent.VK_LEFT:
			if(this.direction != EAST)
				this.direction = WEST;
			break;
		case KeyEvent.VK_RIGHT:
			if(this.direction != WEST)
				this.direction = EAST;
			break;
		case KeyEvent.VK_C:
			sleepTime += 200;
			break;
		}
	}
	
	public static void main(String[] args) {
		Wgc game = new Wgc();
		game.setVisible(true);
		game.startMoving();
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
}
