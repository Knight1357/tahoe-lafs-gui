import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel()
    {
        this.setVisible(true);
        this.setPreferredSize(new Dimension(70,650));
        this.setLayout(new BorderLayout());


        this.add(new LeftUpButtonPanel(),BorderLayout.NORTH);
        this.add(new LeftDownButtonPanel(),BorderLayout.SOUTH);
    }

    private class LeftUpButtonPanel extends JPanel{
        public LeftUpButtonPanel()
        {
            this.setVisible(true);
            this.setSize(70,140);
            this.setLayout(new GridLayout(2,1,0,0));

            LeftButton homePageButton=new LeftButton("首页");
            LeftButton transmissionButton=new LeftButton("传输");
            this.add(homePageButton);
            this.add(transmissionButton);
        }
    }

    private class LeftDownButtonPanel extends JPanel{
        public LeftDownButtonPanel()
        {
            this.setVisible(true);
            this.setSize(70,70);
            this.setLayout(new GridLayout(1,1,0,0));

            LeftButton setButton=new LeftButton("设置");
            this.add(setButton);
        }
    }

    private class LeftButton extends JButton{
        public LeftButton(String str)
        {
            this.setVisible(true);
            this.setSize(70,70);
            this.setPreferredSize(new Dimension(70,70));
            this.setBackground(Color.CYAN);
            this.setText(str);
        }
    }
}



