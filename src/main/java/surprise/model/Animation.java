package surprise.model;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import lombok.NonNull;

public class Animation implements Animatable {
    private final NewYearTree newYearTree = new NewYearTree();
    private final StarScy starScy = new StarScy();
    private final GreetingText greetingText  = new GreetingText();
    
    @Override
    public void start(@NonNull Runnable repaintAction) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                starScy.forEachStar(StarScy::regenerateIfNeed);
                starScy.forEachStar(current -> {
                    for (int j = 0; j < current[1].length; j++) {
                        current[1][j] += 2;
                    }
                });
                repaintAction.run();
            }
        }, 0, 100);
        greetingText.start(repaintAction);
    }

    @Override
    public void paint(Graphics g) {
        newYearTree.paint(g);
        starScy.paint(g);
        greetingText.paint(g);
    }
}
