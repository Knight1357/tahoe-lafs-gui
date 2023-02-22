import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    public MyPanel() {
        this.setVisible(true);
//        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class UpPanel extends  JPanel{
    public UpPanel()
    {
        this.setVisible(true);
        this.setSize(900,100);
        this.setPreferredSize(new Dimension(900,100));
        this.setBackground(Color.PINK);

    }

}

class SearchPanel extends JPanel {
    public SearchPanel() {

    }
}

class ButtonPanel extends JPanel{
    public ButtonPanel()
    {

    }
}


class DownScorllPanel extends JScrollPane {
    public DownScorllPanel() {
        this.setVisible(true);
    }
}


class MyButton extends JButton {
    public MyButton() {
        this.setSize(120, 40);
        this.setPreferredSize(new Dimension(120, 40));
    }

}