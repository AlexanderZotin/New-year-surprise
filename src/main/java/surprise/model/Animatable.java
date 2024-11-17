package surprise.model;

import lombok.NonNull;

public interface Animatable extends Paintable {
    void start(@NonNull Runnable repaintAction);
}
