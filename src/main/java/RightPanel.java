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

    private class RightButton extends JButton{
        public RightButton()
        {
            this.setVisible(true);
        }
    }

}
