package book.effective_java.items.item9.alwaysoverridehashcodewhenoverrideequals;

import java.util.HashSet;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import utility.ObjectOutputUtility;

public class Point {
	private final int x;
	private final int y;

	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object object) {
		return EqualsBuilder.reflectionEquals(this, object, new String[] {});
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, new String[] {});
	}
}

class MainMethod {
	public static void main(String[] argv) {
		Point point1 = new Point(1, 2);
		Point point2 = new Point(1, 2);
		ObjectOutputUtility.outputInstanceToConsole("point1", point1);
		ObjectOutputUtility.outputInstanceToConsole("point2", point2);
		System.out.println(point1.equals(point2));

		HashSet<Point> pointSet = new HashSet<>();
		pointSet.add(point1);
		pointSet.add(point2);
		ObjectOutputUtility.outputCollectionToConsole(pointSet);
	}
}
