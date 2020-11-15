package main;


import agents.UserAgent;
import inscriptionLogin.InscriptionLogin;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;

public class MainApp {

	public static void main(String[] args) throws StaleProxyException {
		
		//create Maincontainer
		try {
			Runtime runtime = Runtime.instance();
			Properties properties = new ExtendedProperties();
			properties.setProperty(Profile.GUI, "true");
			Profile profile = new ProfileImpl(properties);
			AgentContainer mainContainer = runtime.createMainContainer(profile);
			mainContainer.start();
		}catch(ControllerException e) {
			System.out.print(e);
		}
		
//		
//		Runtime runtime = Runtime.instance();
//		ProfileImpl profileImpl = new ProfileImpl(false);
//		profileImpl.setParameter(Profile.MAIN_HOST, "localhost");
//		AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);	
		
		new InscriptionLogin();
		
		

		
	}

}
