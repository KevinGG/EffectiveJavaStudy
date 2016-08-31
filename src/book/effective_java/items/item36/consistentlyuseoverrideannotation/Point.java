package book.effective_java.items.item36.consistentlyuseoverrideannotation;

import java.util.HashSet;
import java.util.Set;
import static utility.ObjectOutputUtility.console;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object object) {
		if(object == this) return true;
		if(object instanceof Point) {
			Point b = (Point)object;
			return b.x == this.x && b.y == this.y;
		}
		return false;
	}

	public int hashCodeOhMyMy() {
		return 31 * x + y;
	}
}

class MainMethod{
	public static void main(String[] argv){
		Set<Point> s =new HashSet<Point>();
		for(int i = 0; i < 10; i++){
			for (int j = 1; j <= 10; j++){
				s.add(new Point(j, j));
			}
		}
		console(s.size());
	}
}