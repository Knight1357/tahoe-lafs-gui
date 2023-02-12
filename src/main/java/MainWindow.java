import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private LeftPanel leftPanel = new LeftPanel();
    private MiddlePanel middlePanel = new MiddlePanel();

    public MainWindow() {
        this.setTitle("Tahoe-Lafs");
        this.setVisible(true);//设置可视
        this.setSize(1100, 650);
        this.setMinimumSize(new Dimension(1100, 650));//设置窗口最小尺寸
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        this.setLayout(new BorderLayout());

        this.add(leftPanel, BorderLayout.WEST);
        this.add(middlePanel, BorderLayout.CENTER);

    }


    //左边部分
    public class LeftPanel extends JPanel {

        private LeftUpButtonPanel leftUpButtonPanel = new LeftUpButtonPanel();
        private LeftDownButtonPanel leftDownButtonPanel = new LeftDownButtonPanel();

        public LeftPanel() {
            this.setVisible(true);
            this.setPreferredSize(new Dimension(70, 650));
            this.setLayout(new BorderLayout());

            this.add(leftUpButtonPanel, BorderLayout.NORTH);
            this.add(leftDownButtonPanel, BorderLayout.SOUTH);
        }

        private class LeftUpButtonPanel extends JPanel {

            private LeftButton homePageButton = new LeftButton("首页");
            private LeftButton transmissionButton = new LeftButton("传输");

            public LeftUpButtonPanel() {
                this.setVisible(true);
                this.setSize(70, 140);
                this.setLayout(new GridLayout(2, 1, 0, 0));

                homePageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        middlePanel.middleCardPanel.removeAll();
                        middlePanel.middleCardPanel.add(middlePanel.middleCardPanel.homePageCardPanel);
                        middlePanel.middleCardPanel.repaint();
                        middlePanel.middleCardPanel.revalidate();
                    }
                });

                transmissionButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        middlePanel.middleCardPanel.removeAll();
                        middlePanel.middleCardPanel.add(middlePanel.middleCardPanel.transmissionCardPanel);
                        middlePanel.middleCardPanel.repaint();
                        middlePanel.middleCardPanel.revalidate();
                    }
                });

                this.add(homePageButton);
                this.add(transmissionButton);
            }
        }

        private class LeftDownButtonPanel extends JPanel {
            private LeftButton setButton = new LeftButton("设置");

            public LeftDownButtonPanel() {
                this.setVisible(true);
                this.setSize(70, 70);
                this.setLayout(new GridLayout(1, 1, 0, 0));


                this.add(setButton);
            }
        }

        private class LeftButton extends JButton {
            public LeftButton(String str) {
                this.setVisible(true);
                this.setSize(70, 70);
                this.setPreferredSize(new Dimension(70, 70));
                this.setBackground(Color.CYAN);
                this.setText(str);
            }
        }
    }


    //中间部分
    public class MiddlePanel extends JPanel {
        private MiddleCardPanel middleCardPanel = new MiddleCardPanel();
        private RightPanel rightPanel = new RightPanel();

        public MiddlePanel() {
            this.setVisible(true);
            this.setSize(170, 650);
            this.setPreferredSize(new Dimension(170, 650));
            this.setBackground(Color.orange);
            this.setLayout(new BorderLayout());

            this.add(middleCardPanel, BorderLayout.WEST);
            this.add(rightPanel, BorderLayout.CENTER);
        }

        public class MiddleCardPanel extends JPanel {
            private CardLayout cardLayout=new CardLayout();
            private HomePageCardPanel homePageCardPanel = new HomePageCardPanel();
            private TransmissionCardPanel transmissionCardPanel=new TransmissionCardPanel();

            public MiddleCardPanel() {
                this.setVisible(true);
                this.setSize(170, 650);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(cardLayout);

                this.add("homePageCardPanel",homePageCardPanel);
                this.add("transmissionCardPanel",transmissionCardPanel);
            }
        }

        private class HomePageCardPanel extends JPanel {
            private UpButtonPanel upButtonPanel = new UpButtonPanel();

            public HomePageCardPanel() {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(new BorderLayout());

                this.add(upButtonPanel, BorderLayout.NORTH);
            }

            private class UpButtonPanel extends JPanel {
                private MiddleButton myFileButton = new MiddleButton("我的文件");
                private MiddleButton recyclingStationButton = new MiddleButton("回收站");

                public UpButtonPanel() {
                    this.setVisible(true);
                    this.setPreferredSize(new Dimension(170, 100));
                    this.setLayout(new GridLayout(2, 1, 0, 0));

                    this.add(myFileButton);
                    this.add(recyclingStationButton);
                }
            }
        }

        private class TransmissionCardPanel extends JPanel {
            private UpButtonPanel upButtonPanel = new UpButtonPanel();

            public TransmissionCardPanel() {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(new BorderLayout());

                this.add(upButtonPanel, BorderLayout.NORTH);
            }

            private class UpButtonPanel extends JPanel {

                private MiddleButton uploadingButton = new MiddleButton("正在上传");
                private MiddleButton downloadingButton = new MiddleButton("正在下载");
                private MiddleButton downloadCompletedButton = new MiddleButton("下载完成");

                public UpButtonPanel() {
                    this.setVisible(true);
                    this.setPreferredSize(new Dimension(170, 150));
                    this.setLayout(new GridLayout(3, 1, 0, 0));

                    this.add(uploadingButton);
                    this.add(downloadingButton);
                    this.add(downloadCompletedButton);
                }
            }

        }

        private class MiddleButton extends JButton {
            public MiddleButton(String str) {
                this.setVisible(true);
                this.setSize(170, 50);
                this.setPreferredSize(new Dimension(170, 50));
                this.setBackground(Color.CYAN);
                this.setText(str);
            }
        }
    }


    //右部分
    public class RightPanel extends JPanel {
        public RightPanel() {
            this.setVisible(true);
            this.setSize(170, 650);
            this.setPreferredSize(new Dimension(170, 650));
            this.setBackground(Color.PINK);

        }


        private class RightButton extends JButton {
            public RightButton() {
                this.setVisible(true);
            }
        }
    }
}
