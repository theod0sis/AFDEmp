package window;
import java.awt.Panel;

import javax.swing.*;

public class ButtonFrame extends JFrame {
	
	JButton load = new JButton("load");
	JButton save = new JButton("save");
	JButton unscribe = new JButton ( "unsubscribe");
	
	ButtonFrame(){
		super("theodosis");
		setSize(140,170);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(load);
		panel.add(save);
		panel.add(unscribe);
		add(panel);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		ButtonFrame bf = new ButtonFrame();

	}

}
