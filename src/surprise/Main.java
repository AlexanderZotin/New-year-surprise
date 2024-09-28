package surprise;

import surprise.controller.ApplicationController;
import surprise.controller.Controller;
import surprise.view.View;
import surprise.view.Window;

public class Main {
    private static Controller controller;

    public static void main(String [] args) {
	    View view = new Window();
        controller = new ApplicationController(view);
        view.subscribeToController(controller);
        view.setVisible(true);
    }

    public static Controller getController() {
        return controller;
    }
}