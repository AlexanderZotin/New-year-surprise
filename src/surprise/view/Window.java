package surprise.view;

import surprise.controller.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame implements View {
    private JButton button;
	
    public Window() {
		SwingUtilities.invokeLater(() -> {
			JPanel panel = new JPanel(new BorderLayout());
			button = new JButton("Нажми меня!");
			panel.add("South", button);

			setContentPane(panel);
			setTitle("Нажмите кнопку...");
			setResizable(false);
			setPreferredSize(new Dimension(400, 525));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
		});
    }
  
    @Override
	public void setVisible(boolean visible) {
		SwingUtilities.invokeLater(() -> {
			super.setVisible(true);
			if (visible) setLocationRelativeTo(null);
		});
	}

	@Override
	public void displayPicture(Picture picture) {
		SwingUtilities.invokeLater(() -> {
			setContentPane(picture);
			setTitle("С новым годом!");
			revalidate();
			repaint();
		});
	}

	@Override
	public void subscribeToController(Controller controller) {
		SwingUtilities.invokeLater(() -> button.addActionListener(e -> controller.pictureRequired()));
	}
}