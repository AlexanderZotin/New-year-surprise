package surprise.model;

import java.awt.Color;
import java.awt.Graphics;

import static surprise.ProgramConstants.colors;

public class NewYearTree implements Paintable {
    private int[][] treeBalls;

    public NewYearTree() {
        initializeTreeBalls();
    }

    private void initializeTreeBalls() {
        treeBalls = new int[2][11];
        int x = 190;
        int y = 90;
        for(int i = 0; i < 11; i++) {
            if(i == 5){
                x = 210;
                y = 150;
            } else if(i == 9) {
                x = 235;
                y = 210;
            }
            treeBalls[0][i] = x;
            treeBalls[1][i] = y;
            x -= 15;
            y += 40;
        }
    }

    @Override
    public void paint(Graphics g) {
        paintTree(g);
        paintStar(g);
        paintTreeBalls(g);
    }

    private void paintTree(Graphics g) {
        final Color BROWN = new Color(128, 64, 0);
        g.setColor(BROWN);
        g.fillRoundRect(180, 280, 50, 60, 7, 7); //отрисовка ствола

        final Color DARK_GREEN = new Color(0, 140, 0);
        g.setColor(DARK_GREEN);
        g.fillPolygon(new int[]{200, 100, 300}, new int[]{50, 300, 300}, 3); //отрисовка листвы
    }

    private void paintStar(Graphics g) {
        g.setColor(Color.ORANGE);
        int[] xCoordinatesOfStar = new int[]{170, 190, 185, 200, 215, 210, 230, 205, 200, 195};
        int[] yCoordinatesOfStar = new int[]{50, 60, 80, 70, 80, 60, 50, 50, 30, 50};
        g.fillPolygon(xCoordinatesOfStar, yCoordinatesOfStar, 10);
    }

    private void paintTreeBalls(Graphics g) {
        for(int i = 0; i < treeBalls[0].length; i++) {
            int index = (int) Math.round(Math.random() * 10);
            g.setColor(colors.get(index));
            g.fillOval(treeBalls[0][i], treeBalls[1][i], 25, 25);
        }
    }

}
