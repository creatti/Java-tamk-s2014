package vk9_10;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class GameObject {
	int xCoord;
	int yCoord;
	int width;
	int height;
	int direction;
	int speed;
	Color color;
	
	public GameObject(int x, int y){
		xCoord = x;
		yCoord = y;
		// Luodaan muut randomilla...
		Random r = new Random();
		width = r.nextInt(100) + 5;
		height = r.nextInt(100) + 5;
		color = new Color( r.nextInt(255), r.nextInt(255), r.nextInt(255 ));
		direction = r.nextInt( 4 ) + 1;
		speed = r.nextInt( 5 ) + 3;	
	}
	
	void move() {
		switch (direction) {
		case 1:
			// East
			xCoord += speed;
			if(xCoord > 500 - width)
				direction = 2;
			break;
		case 2: 
			// West
			xCoord -= speed;
			if(xCoord < 0)
				direction = 1;
			break;
		case 3:
			// South
			yCoord += speed;
			if(yCoord > 500 - width)
				direction = 4;
			break;
		case 4: 
			// North
			yCoord -= speed;
			if(yCoord < 0)
				direction = 3;
			break;
		default:
			break;
		}
		
	}
	void setSpeed( int newSpeed ){
		speed = newSpeed;
	}
	void changeDirection( int newDirection ){
		direction = newDirection;
	}
	boolean isCollided( GameObject otherObject ){
		// Tarkasta, leikkaavatko objektit toisiaan
		// true, jos leikkaa. false, jos ei leikkaa.
		return false;
	}
	abstract void paint( Graphics g );
}


class Ball extends GameObject {	
	public Ball(int x, int y) {
		super(x, y);
	}

	void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillOval(xCoord, yCoord, height, width); // height ja width vaihdettu toisinpäin
		
	}
}
class Square extends GameObject {
	public Square(int x, int y) {
		super(x, y);
	}

	void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect(xCoord, yCoord, height, width);
	}
}