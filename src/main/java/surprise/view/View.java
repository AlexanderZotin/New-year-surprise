package surprise.view;

import lombok.NonNull;
import surprise.controller.Controller;

public interface View {
    void setVisible(boolean visible);
    void subscribeToController(@NonNull Controller controller);
    void displayPicture(@NonNull Picture picture);
    void repaint();
}
