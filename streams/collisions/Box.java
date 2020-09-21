package streams.collisions;
import java.util.Random;


// No encapsulation, similar to android.graphics.Rect
public class Box {
	// (x1,y1) is the corner that is closer to the origin
	// (x2,y2) is the opposite corner
	// So, x1<=x2 and y1<=y2
	public final int x1, y1, x2, y2;
	
	public Box(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public static boolean areOverlapping(Box a, Box b) {
		return !(a.x2 < b.x1 || b.x2 < a.x1 || a.y2 < b.y1 || b.y2 < a.y1);  
	}

	
	
	private static Random rand = new Random();
	
	public static Box newRandom(int maxX, int maxY, int maxWidth, int maxHeight) {
		int x1 = rand.nextInt(maxX),
		    x2 = x1 + rand.nextInt(Math.min(maxWidth, maxX - x1)),
		    y1 = rand.nextInt(maxY),
		    y2 = y1 + rand.nextInt(Math.min(maxHeight, maxY - y1));
		return new Box(x1, y1, x2, y2);
	}
}
