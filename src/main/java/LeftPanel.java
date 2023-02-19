import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    public LeftPanel()
    {
        this.setVisible(true);
        this.setSize(170,650);
        this.setPreferredSize(new Dimension(170,650));
        this.setBackground(Color.orange);
        this.setLayout(new BorderLayout());
    }
}

class LeftDownButtonPanel extends JPanel {
    public LeftDownButtonPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(170,150));
        this.setLayout(new GridLayout(2,1,0,0));
    }
}

class LeftUpButtonPanel extends JPanel {
    public LeftUpButtonPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(170,150));
        this.setLayout(new GridLayout(2,1,0,0));
    }
}


class LeftButton extends JButton {
    public LeftButton(String str)
    {
        this.setVisible(true);
        this.setSize(170,50);
        this.setPreferredSize(new Dimension(170,50));
        this.setBackground(Color.CYAN);
        this.setText(str);
    }
}

class LeftMyFile extends LeftButton{


    public LeftMyFile(String str) {
        super(str);

    }
}







