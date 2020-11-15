package agents;

import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;

public class UserAgent extends GuiAgent{
	
	User user;
	UserGui gui;
	
	protected void setup() {
	//gui = new UserGui();
	
	addBehaviour(new CyclicBehaviour() {

		@Override
		public void action() {
			// TODO Auto-generated method stub
			
		}
			
	});
	}

	@Override
	protected void onGuiEvent(GuiEvent arg0) {
		
	}

}
