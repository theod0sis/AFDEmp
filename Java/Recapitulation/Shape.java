
public abstract class Shape {
	int sides;
	
	public abstract void setSides(int sides);
	public abstract int getSides();
	
	Shape(int side){
		this.sides=side;
	}
	public abstract String toString();
	public abstract double area();
	public abstract double perimeter();
	public abstract void draw();
}
