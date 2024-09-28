package surprise.model;

public interface Animatable extends Paintable {
    void start(Runnable repaintAction);
}
