package surprise.controller;

import surprise.view.Picture;
import surprise.view.View;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@NonNull
@AllArgsConstructor
public class ControllerImplementation implements Controller {
    private final View view;

    @Override
    public void pictureRequired() {
        view.displayPicture(new Picture(view::repaint));
    }
}
