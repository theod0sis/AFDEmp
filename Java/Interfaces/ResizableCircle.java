
public class ResizableCircle extends Circle implements Resizable{

	public void resize( int x){
		
		super.setRadius( super.getRadius() * x);
	}
	
}
