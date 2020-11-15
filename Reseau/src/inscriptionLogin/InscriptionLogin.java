package inscriptionLogin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import agents.User;
import agents.UserAgent;
import agents.UserGui;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class InscriptionLogin extends JFrame{
	
	private ArrayList<User> userList; 
	
	JTextField emailLog;
	JPasswordField mdpLog;
	
	JTextField name;
	JTextField prenom;
	JTextField profile;
	JTextField email;
	JPasswordField mdp;
	
	AgentController ac;
	
	public InscriptionLogin() {
		
		userList = new ArrayList<>();
		this.setSize(400,200);

		
		JButton l = new JButton("log");
		JButton i = new JButton("inscrir");
		JButton back = new JButton("Return");
		JButton back1 = new JButton("Return");
		
		JPanel pane = new JPanel();
		pane.add(l);
		pane.add(i);
		this.add(pane);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JPanel pane1 = new JPanel();
		pane1.setLayout(new BorderLayout());
		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(6,2));
		
		pane1.setVisible(false);
		pane2.setVisible(false);
		this.add(pane1);
		this.add(pane2);
		l.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mdpLog = new JPasswordField(12);
				emailLog = new JTextField(12);
				
				//JPanel pane1 = new JPanel();
				//pane1.setLayout(new BorderLayout());
				JButton login = new JButton("login");
				
				
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();
				
				p1.add(new JLabel("Email :"));
				p1.add(emailLog);
				
				p2.add(new JLabel("Mot de Passe :"));
				p2.add(mdpLog);
				
				p3.add(login);
				p3.add(back1);
				
				//pane1.setLayout(new GridLayout(3,1,10,10));
				
				
				
				pane1.add(p1,BorderLayout.NORTH);
				pane1.add(p2,BorderLayout.CENTER);
				pane1.add(p3,BorderLayout.SOUTH);
				
				pane.setVisible(false);
				pane2.setVisible(false);
				pane1.setVisible(true);
				setTitle("Login");
				
				add(pane1);
			
				
				login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						User us = null;
						for(User u:userList) {
							if(u.getEmail().equals(emailLog.getText()) && u.getMdp().equals(mdpLog.getText())) {
								
								
								new UserGui(u);
								break;
							}
						}
							
						
				
					}
				});
				
				
			}
			
		});
		
		i.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//JPanel pane2 = new JPanel();
				
				
				JButton inscription = new JButton("inscription");
				name = new JTextField(12);
				prenom = new JTextField(12);
				profile = new JTextField(12);
				email = new JTextField(12);
				mdp = new JPasswordField(12);
				pane2.add(new JLabel("Entre le Nom:"));
				pane2.add(name);
				pane2.add(new JLabel("Entre le Prenom:"));
				pane2.add(prenom);
				pane2.add(new JLabel("Entre le Profile:"));
				pane2.add(profile);
				pane2.add(new JLabel("Entre le Email:"));
				pane2.add(email);
				pane2.add(new JLabel("Entre le Mot de passe:"));
				pane2.add(mdp);
				pane2.add(inscription);
				pane2.add(back);
				
				pane.setVisible(false);
				pane1.setVisible(false);
				pane2.setVisible(true);
				setTitle("Inscription");
				//add(pane2);
				
				inscription.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(!name.getText().isEmpty()  && !prenom.getText().isEmpty()
								&& !profile.getText().isEmpty()  &&
								!email.getText().isEmpty() && !mdp.getText().isEmpty()) {
							
							User user = new User(name.getText(),prenom.getText(),profile.getText(),
									email.getText(),mdp.getText());
							userList.add(user);
							try {
								Runtime runtime = Runtime.instance();
								ProfileImpl profileImpl = new ProfileImpl(false);
								profileImpl.setParameter(Profile.MAIN_HOST, "localhost");
								AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);	
								
								AgentController agentController = agentContainer
										.createNewAgent(user.getName(), UserAgent.class.getName(), new Object[] {});
								
								agentController.start();
								//agentContainer.start();
							}catch(ControllerException ex) {
								System.out.print(ex);
							}
							
							new UserGui(user);
						}
						
					}
					
				});
				
				
				
			}
			
		});
		
		
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//removeAll();
				//pane1.setVisible(false);
				pane2.setVisible(false);
				pane.setVisible(true);
				add(pane);
				//setVisible(true);
			}
		});
		
		back1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//removeAll();
				pane1.setVisible(false);
				//pane2.setVisible(false);
				pane.setVisible(true);
				add(pane);
				//setVisible(true);
			}
		});
		
		
		
	}
}
