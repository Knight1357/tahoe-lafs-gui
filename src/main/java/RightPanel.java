import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel()
    {
        this.setVisible(true);
        this.setSize(170,650);
        this.setPreferredSize(new Dimension(170,650));
        this.setBackground(Color.PINK);

    }





}
class RightButton extends JButton{
    public RightButton(String str)
    {
        this.setVisible(true);
        this.setSize(120,40);
        this.setPreferredSize(new Dimension(120,40));
        this.setBackground(Color.CYAN);
        this.setText(str);
    }
}