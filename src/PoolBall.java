import java.awt.Color;

public class PoolBall extends Ball {
	public static int size = 20;

	public PoolBall(int x, int y, Color color) {
		super(x, y, color);
		this.size = PoolBall.size;
	}
}
