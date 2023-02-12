import javax.swing.*;
import java.awt.*;

public class MiddlePanel extends JPanel {

    public MiddlePanel()
    {
        this.setVisible(true);
        this.setSize(170,650);
        this.setPreferredSize(new Dimension(170,650));
        this.setBackground(Color.orange);
        this.setLayout(new BorderLayout());

//        this.add(new MiddleButtonPanel(),BorderLayout.NORTH);
    }

    private class MiddleButtonPanel extends JPanel{
        public MiddleButtonPanel()
        {
            this.setVisible(true);
            this.setSize(170,50);
            this.setBackground(Color.CYAN);
            this.setLayout(new GridLayout(3,1,0,0));

            this.add(new MiddleButton());
            this.add(new MiddleButton());
            this.add(new MiddleButton());
        }

    }

    private class MiddleButton extends JButton{
        public MiddleButton()
        {
            this.setVisible(true);
            this.setSize(170,50);
            this.setPreferredSize(new Dimension(170,50));
            this.setBackground(Color.CYAN);
            this.setText("Button");
        }

    }
}

