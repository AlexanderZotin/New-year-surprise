package surprise.controller;

import surprise.view.Picture;
import surprise.view.View;

import java.util.Objects;

public class ApplicationController implements Controller {
    private final View view;

    public ApplicationController(View view) {
        this.view = Objects.requireNonNull(view, "Параметр view не должен быть null!");
    }

    @Override
    public void pictureRequired() {
        view.displayPicture(new Picture(view::repaint));
    }
}
