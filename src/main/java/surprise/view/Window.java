package surprise.view;

import surprise.controller.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import lombok.NonNull;

public class Window extends JFrame implements View {
    private JButton button;
    
    public Window() {
        JPanel panel = new JPanel(new BorderLayout());
        button = new JButton("Нажми меня!");
        panel.add("South", button);

        setContentPane(panel);
        setTitle("Нажмите кнопку...");
        setResizable(false);
        setPreferredSize(new Dimension(400, 525));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void displayPicture(@NonNull Picture picture) {
        setContentPane(picture);
        setTitle("С новым годом!");
        revalidate();
        repaint();
    }

    @Override
    public void subscribeToController(@NonNull Controller controller) {
        button.addActionListener(event -> controller.pictureRequired());
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(true);
        if (visible) setLocationRelativeTo(null);
    }
}