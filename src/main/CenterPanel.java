import javax.swing.*;
import java.awt.*;

class CenterPanel extends JPanel{
    CenterPanel()
    {
        this.setVisible(true);
        this.setVisible(true);
        this.setSize(600,100);
        this.setPreferredSize(new Dimension(600,100));
        this.setBackground(Color.cyan);
    }
}


class FileScrollPanel extends JScrollPane {
    public FileScrollPanel()
    {
        this.setVisible(true);
//        this.setSize(800,600);
    }
}
