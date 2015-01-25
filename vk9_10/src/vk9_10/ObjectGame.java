package vk9_10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class ObjectGame {
	public static void main(String[] args) {
		// Luo JFrame, johon content paneksi GameSurface
		
		JFrame mainWindow = new JFrame("ObjectGame");
		
		JMenuBar menuBar = new JMenuBar();
		JMenuItem pause = new JMenuItem("Pause");
		JMenu menu = new JMenu("Pause");
		menu.add(pause);
		menuBar.add(menu);
		mainWindow.setJMenuBar(menuBar);
		
		GameSurface GameSurface = new GameSurface();
		mainWindow.setContentPane(GameSurface);
		mainWindow.setSize(500,550);
		mainWindow.setVisible(true);
	}

}

class GameSurface extends JPanel implements MouseListener, ActionListener, KeyListener {
	ArrayList<GameObject> gameObjects;
	Timer gameTimer;
	int points = 0;
	boolean paussi = false;
	public GameSurface(){
		this.setMinimumSize(new Dimension(500, 500));
		this.addMouseListener( this );
		this.addKeyListener(this);
		this.setFocusable(true);
		gameObjects = new ArrayList<GameObject>();
		
		addSquare(25, 25);
		
		gameTimer = new Timer(50, this);
		gameTimer.setInitialDelay(1000);
		gameTimer.start(); 
	}
	
	void Tick() {
		// T‰t‰ kutsutaan s‰ikeest‰ esim 30x sekunnissa
		// Ns pelisilmukka.
		Iterator<GameObject> iterator = gameObjects.iterator();
		while(iterator.hasNext()) {
		  GameObject obj = (GameObject)iterator.next();
		  obj.move();
		}
		repaint();
	}
	
	public void paint( Graphics g ){
		points += 1;
		// Piirr‰ tausta mustalla
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.white);
		g.drawString("Score: " + points, 100 , 25);
		// Peliobjektit piirt‰v‰t itse itsens‰
		// v‰litet‰‰n vain Graphics g
		Iterator<GameObject> iterator = gameObjects.iterator();
		while(iterator.hasNext()) {
		  GameObject obj = (GameObject)iterator.next();
		  obj.paint(g);
		}
	}
	
	void addBall(int x, int y) {
		// Luodaan ja lis‰t‰‰n arrayhin uusi Ball -objekti
		gameObjects.add(new Ball( x, y ));
	}
	
	void addSquare( int x, int y) {
		// Luodaan ja lis‰t‰‰n arrayhin uusi Square -objekti
		gameObjects.add(new Square( x, y ));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		addBall(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Ajastin...
			Tick();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            gameObjects.get(0).changeDirection(4);
	            break;
	        case KeyEvent.VK_DOWN:
	        	gameObjects.get(0).changeDirection(3);
	            break;
	        case KeyEvent.VK_LEFT:
	        	gameObjects.get(0).changeDirection(2);
	            break;
	        case KeyEvent.VK_RIGHT :
	        	gameObjects.get(0).changeDirection(1);
	            break;
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}