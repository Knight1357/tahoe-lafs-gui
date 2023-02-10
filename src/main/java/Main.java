import javax.swing.*;

public class Main {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton button1;
    private JButton button2;
    private JButton botton3;
    private JPanel middlePanel;
    private JButton button3;
    private JPanel rightPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
