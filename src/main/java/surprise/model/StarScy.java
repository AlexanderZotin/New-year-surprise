package surprise.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import static surprise.ProgramConstants.colors;

public class StarScy implements Paintable {
    private static final int[][] defaultStar = new int[][] {
            {8, 11, 14, 22, 15, 18, 11, 4, 8, 0},
            {9, 0, 9, 9, 14, 22, 18, 22, 14, 9}
    };

    private final List<int[][]> allStars;

    public StarScy() {
        allStars = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            allStars.add(generateStar());
        }
    }

    public static int[][] generateStar() {
        int[][] star = new int[2][10];
        regenerateStar(star);
        return star;
    }

    public static void regenerateStar(int[][] star) {
        var random = new Random();
        for (int i = 0; i < star.length; i++) {
            int summand = (i == 0) ? random.nextInt(378) : random.nextInt(320);
            for (int j = 0; j < star[i].length; j++) {
                star[i][j] = defaultStar[i][j] + summand;
                if (i == 1) star[i][j] -= 320; //Уменьшаем координаты по y, прячем звёзды
            }
        }
    }

    public static void regenerateIfNeed(int[][] star) {
        if(star[1][0] > 320) {
            regenerateStar(star);
        }
    }

    public void forEachStar(Consumer<int[][]> action) {
        allStars.forEach(action);
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < allStars.size(); i++) {
            if(i < 6) g.setColor(colors.get(0));
            else if(i < 12) g.setColor(colors.get(1));
            else if(i < 18) g.setColor(colors.get(2));
            else if(i < 24) g.setColor(colors.get(3));
            else if(i < 30) g.setColor(colors.get(4));
            else if(i < 36) g.setColor(colors.get(5));
            else if(i < 42) g.setColor(colors.get(6));
            else if(i < 48) g.setColor(colors.get(7));
            else if(i < 54) g.setColor(colors.get(8));
            else if(i < 60) g.setColor(colors.get(9));
            g.fillPolygon(allStars.get(i)[0], allStars.get(i)[1], 10);
        }
    }
}