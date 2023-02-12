import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel()
    {
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(70,650));
        this.setLayout(new BorderLayout());


        this.add(new LeftButtonPanel(),BorderLayout.NORTH);
        this.add(new LeftButton(),BorderLayout.SOUTH);
    }

    private class LeftButtonPanel extends JPanel{
        public LeftButtonPanel()
        {
            this.setVisible(true);
            this.setSize(70,140);
            this.setBackground(Color.YELLOW);
//            this.setLayout(new GridLayout(2,1,0,0));
            this.setLayout(new GridLayout(2,1,0,0));

            this.add(new LeftButton());
            this.add(new LeftButton());
        }
    }

    private class LeftButton extends JButton{
        public LeftButton()
        {
            this.setVisible(true);
            this.setSize(70,70);
            this.setPreferredSize(new Dimension(70,70));
            this.setBackground(Color.CYAN);
            this.setText("Button");
        }
    }
}



