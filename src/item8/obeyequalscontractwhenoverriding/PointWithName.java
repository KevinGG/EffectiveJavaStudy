package item8.obeyequalscontractwhenoverriding;

public class PointWithName {
	private final Point point;
	private String name;
	
	public PointWithName(final int x, final int y, String name){
		if(name == null){
			throw new NullPointerException();
		}
		point = new Point(x, y);
		this.name = name;
	}
	
	public Point asPoint(){
		return point;
	}
	
	@Override public boolean equals(Object object){
		if(!(object instanceof PointWithName)){
			return false;
		}
		PointWithName comparedPointWithName = (PointWithName) object;
		return comparedPointWithName.point.equals(point) && comparedPointWithName.name.equals(name);
		 
	}
}

class Point {
	private final int x;
	private final int y;

	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Point)) {
			return false;
		}
		Point comparedPoint = (Point) object;
		return comparedPoint.x == x && comparedPoint.y == y;
	}
}

class MainMethod{
	public static void main(String[] argv){
		PointWithName pointWithName1 = new PointWithName(1, 2, "1, 2Point");
		PointWithName pointWithName2 = new PointWithName(1, 2, "1, 2Point");
		PointWithName pointWithName3 = new PointWithName(1, 2, "no name");
		Point point = new Point(1,2);
		System.out.println(pointWithName1.equals(pointWithName2));
		System.out.println(pointWithName1.equals(pointWithName3));
		System.out.println(point.equals(pointWithName1));
		System.out.println(pointWithName1.equals(point));
	}
}