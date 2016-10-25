
public class Shape2 implements Agreeable {
	
	private int width;
	private int height;
	
	Shape2(){
	}
	Shape2(int x, int y){
		this.width=x;
		this.height=y;
	}
	
	public boolean isSmallerThan(Agreeable theo){
		Shape2 yo = (Shape2) theo;
		return( this.calcArea() >  yo.calcArea() );
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int calcArea(){
		return this.width*this.height;
	}

}