import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow()
    {
        this.setTitle("Tahoe-Lafs");
        this.setVisible(true);//设置可视
        this.setSize(1100,650);
        this.setMinimumSize(new Dimension(1100,650));
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        this.setLayout(new BorderLayout());

        LeftPanel leftPanel=new LeftPanel();
        MiddlePanel middlePanel=new MiddlePanel();

       this.add(leftPanel,BorderLayout.WEST);
        this.add(middlePanel,BorderLayout.CENTER);



    }



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



    public class MiddlePanel extends JPanel {

        public MiddlePanel()
        {
            this.setVisible(true);
            this.setSize(170,650);
            this.setPreferredSize(new Dimension(170,650));
            this.setBackground(Color.orange);
            this.setLayout(new BorderLayout());

            MiddleCardPanel middleCardPanel=new MiddleCardPanel();
            RightPanel rightPanel=new RightPanel();

            this.add(middleCardPanel,BorderLayout.WEST);
            this.add(rightPanel,BorderLayout.CENTER);
        }

        public   class MiddleCardPanel extends JPanel{
            public MiddleCardPanel()
            {
                this.setVisible(true);
                this.setSize(170,650);
                this.setPreferredSize(new Dimension(170,650));
                this.setLayout(new CardLayout());

                this.add(new homePageButtonPanel());
//            this.add(new transmissionButtonPanel());
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




    public class RightPanel extends JPanel {
        public RightPanel()
        {
            this.setVisible(true);
            this.setSize(170,650);
            this.setPreferredSize(new Dimension(170,650));
            this.setBackground(Color.PINK);

        }



        private class RightButton extends JButton{
            public RightButton()
            {
                this.setVisible(true);
            }
        }

    }





}
