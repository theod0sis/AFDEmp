
public class Rectangle extends Shape {
	
	private int a;
	private int b;
	
	Rectangle(){
		super(4);
	}
	Rectangle(int a,int b){
		super(4);
		this.a=a;
		this.b=b;
	}
	
	public void setA(int a){
		this.a=a;
	}
	public int getA(){
		return this.a;
	}
	public void setB(int b){
		this.b=b;
	}
	public int getB(){
		return b;
	}
	
	public String toString(){
		return (this.a + " " + this.b);	
	}
	
	
	public boolean areEqual(Rectangle x){
		if (this.a==x.getA() && this.b==x.getB() ){
			return true;
		}
		else{
			return false ;
		}
	}
	
	
	public boolean isSquare (){
		if (this.a==this.b){
			return true;
		}
		else return false;
	}
	
	public void draw(){
		for ( int i=0; i<=a;i++){
			System.out.print("-");
		}
		System.out.println();
		for ( int j=0; j<=b;j++){
			for ( int i=0; i<=a;i++){
				if (i==0){
			System.out.print("|");
				}
			else if( i==a){
				System.out.print("|");
				System.out.println();
			}
			else{	
			System.out.print(" ");
			}
			}
		}
		for ( int i=0; i<=a;i++){
			System.out.print("-");
		}
	}
	
	
	public Rectangle copy(){
		Rectangle x= new Rectangle(this.a,this.b);
		return x;
	}
	@Override
	public void setSides(int sides) {
		this.sides=sides;

	}
	@Override
	public int getSides() {
		return super.sides;
	}
	@Override
	public double area() {
		return this.a*this.b;
	}
	@Override
	public double perimeter() {
		return 2*a + 2*b;
	}
}