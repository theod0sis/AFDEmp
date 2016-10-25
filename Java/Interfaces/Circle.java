
public class Circle implements Shape{
	
	private double parameter;
	private double area;
	protected double radius;
	
	
	public void setRadius(double x){
		this.radius=x;
	}
	
	public double getRadius(){
		return this.radius;
	}
	@Override
	public double getParameter() {
		
		return this.parameter;
	}


	@Override
	public double getArea() {
		return this.area;
	}
	
	
}
