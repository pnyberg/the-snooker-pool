import java.awt.Color;

public class PoolGame {
	private CueBall cueBall;
	private PoolBall poolBall;
	
	public PoolGame() {
		cueBall = new CueBall(5, 5);
		poolBall = new PoolBall(10, 10, Color.green);
		
		System.out.println("CueBall: " + cueBall.getX() + "," + cueBall.getY());
		System.out.println("PoolBall:"  + poolBall.getX() + "," + poolBall.getY());
		System.out.println();
		
		cueBall.shoot(20, 3*Math.PI/2);
		
		for (int i = 0 ; i < 5 ; i++) {
			handleMovement(cueBall);
			handleMovement(poolBall);
			System.out.println("-----------------------------");
			System.out.println("CueBall #2: " + cueBall.getX() + "," + cueBall.getY());
			System.out.println("PoolBall #2:"  + poolBall.getX() + "," + poolBall.getY());
		}
	}
	
	public void handleMovement(Ball ball) {
		boolean collisionOnCourse = checkCollision(ball);
		
		if (!collisionOnCourse) {
			ball.move();
			return;
		}
		
		// TODO - if collision then get it fixed
	}
	
	public boolean checkCollision(Ball ball) {
		return false;
	}

	public static void main(String[] args) {
		new PoolGame();
	}
}
