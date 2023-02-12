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

        this.add(new MiddleCardPanel(),BorderLayout.WEST);
        this.add(new RightPanel(),BorderLayout.CENTER);
    }

    private  class MiddleCardPanel extends JPanel{
        public MiddleCardPanel()
        {
            this.setVisible(true);
            this.setSize(170,650);
            this.setPreferredSize(new Dimension(170,650));
            this.setLayout(new CardLayout());

//            this.add(new homePageButtonPanel());
            this.add(new transmissionButtonPanel());
        }
    }

    private class homePageButtonPanel extends JPanel{
        public homePageButtonPanel()
        {
            this.setVisible(true);
            this.setPreferredSize(new Dimension(170,650));
            this.setLayout(new BorderLayout());

            this.add(new UpButtonPanel(),BorderLayout.NORTH);
        }

        private class UpButtonPanel extends JPanel{
             public UpButtonPanel()
             {
                 this.setVisible(true);
                 this.setPreferredSize(new Dimension(170,100));
                 this.setLayout(new GridLayout(2,1,0,0));

                 MiddleButton myFileButton=new MiddleButton("我的文件");
                 MiddleButton recyclingStationButton=new MiddleButton("回收站");

                 this.add(myFileButton);
                 this.add(recyclingStationButton);


             }
        }
    }

    private class transmissionButtonPanel extends JPanel{
        public transmissionButtonPanel()
        {
            this.setVisible(true);
            this.setPreferredSize(new Dimension(170,650));
            this.setLayout(new BorderLayout());

            this.add(new UpButtonPanel(),BorderLayout.NORTH);
        }

        private class UpButtonPanel extends JPanel{
            public UpButtonPanel()
            {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170,150));
                this.setLayout(new GridLayout(3,1,0,0));

                MiddleButton uploadingButton=new MiddleButton("正在上传");
                MiddleButton downloadingButton=new MiddleButton("正在下载");
                MiddleButton downloadCompletedButton=new MiddleButton("下载完成");

                this.add(uploadingButton);
                this.add(downloadingButton);
                this.add(downloadCompletedButton);


            }
        }

    }

    private class MiddleButton extends JButton{
        public MiddleButton(String str)
        {
            this.setVisible(true);
            this.setSize(170,50);
            this.setPreferredSize(new Dimension(170,50));
            this.setBackground(Color.CYAN);
            this.setText(str);
        }

    }
}

