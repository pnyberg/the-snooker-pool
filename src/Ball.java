import java.awt.Color;
import java.awt.Graphics;

public abstract class Ball {
	public static int MAX_POWER = 50;
	protected final double PI2 = (2 * Math.PI);

	protected int x, y, size, power;
	protected double direction;
	protected Color color;
	
	public Ball(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	protected void setPower(int power) {
		this.power = power;
	}
	
	protected void setDirection(double direction) {
		this.direction = direction;
	}
	
	public void bounce(Ball other) {
		int xPosDiff = x - other.getX();
		int yPosDiff = y - other.getY();
		
		// direction-calculation
		double pushDirection = Math.atan(yPosDiff / xPosDiff);
		
		if (xPosDiff < 0) {
			pushDirection += Math.PI;
		}
		
		double mirrorDirection = (pushDirection + Math.PI) % PI2;
		double backwardDirection = (direction + Math.PI) % PI2;
		double newDirection = mirrorDirection + (mirrorDirection - backwardDirection);

		// power-calculation
		double pushAngle = pushDirection - direction;
		int pushPower = (int)(power * Math.sin(pushAngle));

		int newPower = (int)Math.round(Math.sqrt(Math.pow(power, 2) - Math.pow(pushPower, 2)));  

		other.setDirection(pushDirection);
		other.setPower(pushPower);
		
		direction = newDirection;
		power = newPower;
	}
	
	public void move() {
		int xMoveDiff = (int)(Math.cos(direction) * power);
		int yMoveDiff = (int)(Math.sin(direction) * power);
		
		x += xMoveDiff;
		y += yMoveDiff;
		power--;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	public int getPower() {
		return power;
	}

	public double getDirection() {
		return direction;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, size, size);
		g.setColor(Color.black);
		g.drawOval(x, y, size, size);
	}
}
