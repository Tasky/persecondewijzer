package views.panels;

import java.util.Observable;
import java.util.Observer;

import logic.Onderdeel;
import views.components.NiceButton;

public class OnderdeelButton extends NiceButton implements Observer {

	private Onderdeel				onderdeel;
	private logic.GekozenAntwoord	gk;

	public OnderdeelButton(Onderdeel onderdeel) {
		super(onderdeel.toString());
		this.onderdeel = onderdeel;
	}

	public void clicked(logic.GekozenAntwoord gk) {
		this.gk = gk;
		setEnabled(false);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		logic.GekozenAntwoord updatedGk = (logic.GekozenAntwoord) arg0;
		Onderdeel updatedOnderdeel = updatedGk.getGekozenOnderdeel();
		if (gk == updatedGk) setEnabled(true);
		if (updatedOnderdeel == onderdeel) {
			gk = updatedGk;
			setEnabled(false);
		}
	}
}
