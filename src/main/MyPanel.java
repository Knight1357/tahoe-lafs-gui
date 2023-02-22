import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    public MyPanel() {
        this.setVisible(true);
        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class SearchPanel extends JPanel {
    public SearchPanel() {
    }
}

class ButtonPanel extends JPanel{

}


class MyScorllPane extends JScrollPane {
    public MyScorllPane() {
        this.setVisible(true);
    }
}


class MyButton extends JButton {
    public MyButton() {
        this.setSize(120, 40);
        this.setPreferredSize(new Dimension(120, 40));
    }

}