package surprise;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.AbstractMap.SimpleImmutableEntry;
import static java.lang.String.format;

public final class ProgramConstants {
    private ProgramConstants() {
        throw new AssertionError("Не должно быть экземпляров класса ProgramConstants!");
    }

    public static final List<Color> colors = List.of(
            Color.RED,
            new Color(100, 0, 200),
            new Color(200, 0, 100),
            Color.PINK,
            Color.WHITE,
            Color.CYAN,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.MAGENTA,
            new Color(250, 150, 0)
    );
}
