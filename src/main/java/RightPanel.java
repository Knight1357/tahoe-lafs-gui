import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel() {
        this.setVisible(true);
        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class RightButton extends JButton {
    public RightButton(String str) {
        this.setVisible(true);
        this.setSize(120, 40);
        this.setPreferredSize(new Dimension(120, 40));
        this.setBackground(Color.CYAN);
        this.setText(str);
    }
}

class RightUpPanel extends JPanel {
    public RightUpPanel() {
        this.setVisible(true);
        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
    }
}

class RightUpLeftButtonPanel extends JPanel {
    public RightUpLeftButtonPanel() {
        this.setVisible(true);
        this.setSize(240, 40);
        this.setPreferredSize(new Dimension(240, 40));
        this.setBackground(Color.PINK);
        this.setLayout(new GridLayout(1, 2, 0, 0));
    }
}

class RightUploadButton extends RightButton {
    public RightUploadButton(String str) {
        super(str);

    }
}

class RightNewfileButton extends RightButton {
    public RightNewfileButton(String str) {
        super(str);
    }
}

class RightScorllPane extends JScrollPane {
    public RightScorllPane() {
        this.setVisible(true);
    }
}