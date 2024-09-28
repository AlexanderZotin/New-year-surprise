package surprise.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.String.format;

public class GreetingText implements Animatable {
    private static final Set<Map.Entry<String, String>> text = new LinkedHashSet<>(8);

    static {
        text.add(new AbstractMap.SimpleImmutableEntry<>("", ""));
        text.add(new AbstractMap.SimpleImmutableEntry<>("\u0000", ""));
        text.add(new AbstractMap.SimpleImmutableEntry<>(format("%27s", "Любимый папа, поздравляю"), format("%28s", "тебя с Новым Годом!")));
        text.add(new AbstractMap.SimpleImmutableEntry<>(format("%27s", "В следующем году желаю"), "успехов в шахматах и бридже."));
        text.add(new AbstractMap.SimpleImmutableEntry<>(format("%30s", "Я очень рад, что ты"), format("%30s", "начал играть в турнирах.")));
        text.add(new AbstractMap.SimpleImmutableEntry<>(format("%27s", "Хочу сказать тебе спасибо"), "за то, что поддерживал меня,"));
        text.add(new AbstractMap.SimpleImmutableEntry<>(format("%27s", "любил и пытался понять."), ""));
        text.add(new AbstractMap.SimpleImmutableEntry<>(format("%27s", "Я люблю тебя!"), format("%27s", "Твой Шурик")));
    }

    private final Iterator<Map.Entry<String, String>> iterator = text.iterator();
    private Map.Entry<String, String> currentPair;



    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font(null, Font.ITALIC, 25));
        g.drawString(currentPair.getKey(), 10, 400);
        g.drawString(currentPair.getValue(), 10, 440);
    }

    @Override
    public void start(Runnable repaintAction) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (iterator.hasNext()) {
                    currentPair = iterator.next();
                    repaintAction.run();
                } else {
                    System.exit(0);
                }
            }
        }, 0, 6000);
    }
}
