package window;
import javax.swing.*;

public class Payroll  extends JFrame{
	
	public Payroll(){
		super("Aloe");
		setSize(300,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		Payroll pr = new Payroll();
		
	}
}
