package views.components;

import java.io.IOException;

public class Icon extends ImagePanel {

	public Icon(String icon) throws IOException {
		super("images/icons/" + icon + ".png");
	}

}
