import java.awt.Color;

public class CueBall extends Ball {
	public CueBall(int x, int y) {
		super(x, y, Color.white);
		this.size = PoolBall.size;
	}
	
	/**
	 * @param power no maximum power set yet
	 * @param direction in radians
	 */
	public void shoot(int power, double direction) {
		if (power <= 0 || power > MAX_POWER) {
			System.err.println("Power is not in the range of 1-" + MAX_POWER);
			System.exit(0);
		}
		if (direction < 0 || direction >= PI2) {
			System.err.println("Direction is not in the range of 0-2 PI (radian)");
			System.exit(0);
		}

		this.power = power;
		this.direction = direction;
	}
}
