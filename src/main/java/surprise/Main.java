package surprise;

import surprise.controller.ControllerImplementation;
import surprise.view.Window;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String [] args) {
        SwingUtilities.invokeLater(() -> {
            var view = new Window();
            var controller = new ControllerImplementation(view);
            view.subscribeToController(controller);
            view.setVisible(true);
        });
    }
}