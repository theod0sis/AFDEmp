package window;
import javax.swing.*;

public class Authenticator extends JFrame {
	JTextField username= new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	JTextArea comments = new JTextArea(4,15);
	JButton ok= new JButton("OK");
	JButton cancel = new JButton("CANCEL");
	
	public Authenticator(){
		super("Theo");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		JLabel usernamelabel = new JLabel("Username:");
		JLabel passwordlabel = new JLabel("Password:");
		JLabel commentslabel = new JLabel("Comments:");
		comments.setLineWrap(true);
		comments.setWrapStyleWord(true);
		pane.add(usernamelabel);
		pane.add(username);
		pane.add(passwordlabel);
		pane.add(password);
		pane.add(commentslabel);
		pane.add(comments);
		pane.add(ok);
		pane.add(cancel);
		add(pane);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Authenticator theo= new Authenticator();
		
	}

}
