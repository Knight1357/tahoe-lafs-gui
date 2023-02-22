import javax.swing.*;
import java.awt.*;

class UpPanel extends JPanel {
    public UpPanel() {
        this.setVisible(true);
        this.setSize(400,100);
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BorderLayout());
    }
}



class SearchPanel extends JPanel {
    public SearchPanel() {
        this.setVisible(true);
        this.setSize(200,40);
        this.setPreferredSize(new Dimension(200,40));
        this.setLayout(new FlowLayout());
    }
}

class OperateButtonPanel extends JPanel{
    public OperateButtonPanel()
    {
        this.setVisible(true);
        this.setSize(200,40);
        this.setPreferredSize(new Dimension(200,40));
        this.setLayout(new FlowLayout());
    }
}

class InformationPanel extends JPanel{
    public InformationPanel()
    {
        this.setVisible(true);
        this.setSize(200,20);
        this.setPreferredSize(new Dimension(200,20));
        this.setLayout(new FlowLayout());
    }

}

class ButtonPanel extends JPanel{
    public ButtonPanel()
    {
        this.setVisible(true);

    }
}





class UpButton extends JButton {
    public UpButton() {
        this.setSize(80, 40);
        this.setPreferredSize(new Dimension(80,40));
    }
}