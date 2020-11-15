package agents;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jade.gui.GuiAgent;

public class UserGui extends JFrame{
	
	private User user;
	private GuiAgent userAgent;
	

	
	
	public UserGui(User user) throws HeadlessException {
		super();
		this.user = user;
		Font f =new Font("Arial",Font.BOLD,20);
		JLabel n = new JLabel("Welcome " +user.getName());
		n.setFont(f);
		JLabel p = new JLabel(user.getPrenom());
		p.setFont(f);
		//JLabel pro = new JLabel(user.getProfile());
		JPanel pane = new JPanel();
		
		pane.add(n);
		pane.add(p);
		//pane.add(pro);
		
		//envoi
		JTextField tx = new JTextField(14);
		JButton envoi = new JButton("Envoyer le message");
		JPanel paneMessage = new JPanel();
		paneMessage.add(tx);
		paneMessage.add(envoi);
		
		//recieve
		JPanel pa = new JPanel();	
		JTextArea jTextArea = new JTextArea();
		jTextArea.setEditable(false);
		pa.setLayout(new BorderLayout());
		pa.add(paneMessage,BorderLayout.NORTH);
		pa.add(new JScrollPane(jTextArea),BorderLayout.CENTER);
	
		this.setLayout(new BorderLayout());
		this.add(pane,BorderLayout.NORTH);
		this.add(pa,BorderLayout.CENTER);
		this.setSize(750,350);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
