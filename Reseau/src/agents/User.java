package agents;

import jade.gui.GuiAgent;
import jade.gui.GuiEvent;

public class User {
	
	//private UserGui gui; 
	
	private int id;
	private String name;
	private String prenom;
	private String email;
	private String profile;
	private String mdp;
	

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String name, String prenom, String profile, String email, String mdp) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.profile = profile;
		this.mdp = mdp;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public void setname(String name) {
		this.name = name;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}




}
