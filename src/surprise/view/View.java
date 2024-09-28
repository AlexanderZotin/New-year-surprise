package surprise.view;

import surprise.controller.Controller;

public interface View {
    void setVisible(boolean visible);
    void subscribeToController(Controller controller);
    void displayPicture(Picture picture);
    void repaint();
}
