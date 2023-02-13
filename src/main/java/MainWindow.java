import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private final MiddlePanel middlePanel = new MiddlePanel();
    public MainWindow() {//主窗口
        this.setTitle("Tahoe-Lafs");
        this.setVisible(true);//设置可视
        this.setSize(1100, 650);
        this.setMinimumSize(new Dimension(1100, 650));//设置窗口最小尺寸
        this.setLocationRelativeTo(null);//设置位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
        this.setLayout(new BorderLayout());

        LeftPanel leftPanel = new LeftPanel();
        this.add(leftPanel, BorderLayout.WEST);
        this.add(middlePanel, BorderLayout.CENTER);

    }


    //左边部分
    public class LeftPanel extends JPanel {

        public LeftPanel() {//左边块
            this.setVisible(true);
            this.setPreferredSize(new Dimension(70, 650));
            this.setLayout(new BorderLayout());

            LeftUpButtonPanel leftUpButtonPanel = new LeftUpButtonPanel();
            this.add(leftUpButtonPanel, BorderLayout.NORTH);
            LeftDownButtonPanel leftDownButtonPanel = new LeftDownButtonPanel();
            this.add(leftDownButtonPanel, BorderLayout.SOUTH);
        }

        private class LeftUpButtonPanel extends JPanel {//左边窗口上部分按钮块
            public LeftUpButtonPanel() {
                this.setVisible(true);
                this.setSize(70, 140);
                this.setLayout(new GridLayout(2, 1, 0, 0));

                LeftButton homePageButton = new LeftButton("首页");
                homePageButton.addActionListener(e -> {
                    middlePanel.middleCardPanel.removeAll();
                    middlePanel.middleCardPanel.add(middlePanel.middleCardPanel.homePageCardPanel);
                    middlePanel.middleCardPanel.repaint();
                    middlePanel.middleCardPanel.revalidate();

                    middlePanel.rightPanel.rightUpCardPanel.removeAll();
                    middlePanel.rightPanel.rightUpCardPanel.add(middlePanel.rightPanel.rightUpCardPanel.homePageCardPanel);
                    middlePanel.rightPanel.rightUpCardPanel.repaint();
                    middlePanel.rightPanel.rightUpCardPanel.revalidate();

                });

                LeftButton transmissionButton = new LeftButton("传输");
                transmissionButton.addActionListener(e -> {
                    middlePanel.middleCardPanel.removeAll();
                    middlePanel.middleCardPanel.add(middlePanel.middleCardPanel.transmissionCardPanel);
                    middlePanel.middleCardPanel.repaint();//刷新
                    middlePanel.middleCardPanel.revalidate();//重新验证

                    middlePanel.rightPanel.rightUpCardPanel.removeAll();
                    middlePanel.rightPanel.rightUpCardPanel.add(middlePanel.rightPanel.rightUpCardPanel.transmissionCardPanel);
                    middlePanel.rightPanel.rightUpCardPanel.repaint();
                    middlePanel.rightPanel.rightUpCardPanel.revalidate();
                });

                this.add(homePageButton);
                this.add(transmissionButton);
            }
        }

        private class LeftDownButtonPanel extends JPanel {//左边窗口下部分按钮块

            //            private SetDialog setDialog=new SetDialog();
            public LeftDownButtonPanel() {
                this.setVisible(true);
                this.setSize(70, 70);
                this.setLayout(new GridLayout(1, 1, 0, 0));

                LeftButton setButton = new LeftButton("设置");
                setButton.addActionListener(e -> new SetDialog());

                this.add(setButton);
            }

            public class SetDialog extends JDialog {//设置按钮弹窗
                public SetDialog() {
                    this.setTitle("设置");
                    this.setVisible(true);//设置可视
                    this.setSize(700, 400);
                    this.setMinimumSize(new Dimension(700, 400));//设置窗口最小尺寸
                    this.setLocationRelativeTo(null);//设置位置居中
                    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭
                }
            }
        }

        private class LeftButton extends JButton {//左边部分按钮设置
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
    public  class MiddlePanel extends JPanel {//窗口中间部分块
        private final MiddleCardPanel middleCardPanel = new MiddleCardPanel();

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

        public  class MiddleCardPanel extends JPanel {//中间部分card块容器
            private final HomePageCardPanel homePageCardPanel = new HomePageCardPanel();
            private final TransmissionCardPanel transmissionCardPanel = new TransmissionCardPanel();

            public MiddleCardPanel() {
                this.setVisible(true);
                this.setSize(170, 650);
                this.setPreferredSize(new Dimension(170, 650));
                CardLayout cardLayout = new CardLayout();
                this.setLayout(cardLayout);

                this.add("homePageCardPanel", homePageCardPanel);
                this.add("transmissionCardPanel", transmissionCardPanel);
            }
        }

        private  class HomePageCardPanel extends JPanel {//中间首页部分card块

            public HomePageCardPanel() {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(new BorderLayout());

                UpButtonPanel upButtonPanel = new UpButtonPanel();
                this.add(upButtonPanel, BorderLayout.NORTH);
            }

            private  class UpButtonPanel extends JPanel {//窗口中间上部分按钮块

                public UpButtonPanel() {
                    this.setVisible(true);
                    this.setPreferredSize(new Dimension(170, 100));
                    this.setLayout(new GridLayout(2, 1, 0, 0));

                    MiddleButton myFileButton = new MiddleButton("我的文件");

                    myFileButton.addActionListener(e -> {
                        rightPanel.rightUpCardPanel.removeAll();
                        rightPanel.rightUpCardPanel.add(rightPanel.rightUpCardPanel.homePageCardPanel);
                        rightPanel.rightUpCardPanel.repaint();
                        rightPanel.rightUpCardPanel.revalidate();
                    });
                    MiddleButton recyclingStationButton = new MiddleButton("回收站");

                    recyclingStationButton.addActionListener(e -> {
                        rightPanel.rightUpCardPanel.removeAll();
                        rightPanel.rightUpCardPanel.add(rightPanel.rightUpCardPanel.homePageCardPanel);
                        rightPanel.rightUpCardPanel.repaint();
                        rightPanel.rightUpCardPanel.revalidate();
                    });

                    this.add(myFileButton);

                    this.add(recyclingStationButton);
                }
            }
        }

        private  class TransmissionCardPanel extends JPanel {//中间传输card块

            public TransmissionCardPanel() {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(new BorderLayout());

                UpButtonPanel upButtonPanel = new UpButtonPanel();
                this.add(upButtonPanel, BorderLayout.NORTH);
            }

            private  class UpButtonPanel extends JPanel {//窗口中间上部分按钮块

                public UpButtonPanel() {
                    this.setVisible(true);
                    this.setPreferredSize(new Dimension(170, 150));
                    this.setLayout(new GridLayout(3, 1, 0, 0));

                    MiddleButton uploadingButton = new MiddleButton("正在上传");

                    uploadingButton.addActionListener(e->{
                        rightPanel.rightUpCardPanel.removeAll();
                        rightPanel.rightUpCardPanel.add(rightPanel.rightUpCardPanel.transmissionCardPanel);
                        rightPanel.rightUpCardPanel.repaint();
                        rightPanel.rightUpCardPanel.revalidate();
                    });

                    MiddleButton downloadingButton = new MiddleButton("正在下载");

                    downloadingButton.addActionListener(e->{
                        rightPanel.rightUpCardPanel.removeAll();
                        rightPanel.rightUpCardPanel.add(rightPanel.rightUpCardPanel.transmissionCardPanel);
                        rightPanel.rightUpCardPanel.repaint();
                        rightPanel.rightUpCardPanel.revalidate();
                    });


                    MiddleButton downloadCompletedButton = new MiddleButton("下载完成");
                    downloadingButton.addActionListener(e->{
                        rightPanel.rightUpCardPanel.removeAll();
                        rightPanel.rightUpCardPanel.add(rightPanel.rightUpCardPanel.transmissionCardPanel);
                        rightPanel.rightUpCardPanel.repaint();
                        rightPanel.rightUpCardPanel.revalidate();
                    });

                    this.add(uploadingButton);
                    this.add(downloadingButton);

                    this.add(downloadCompletedButton);
                }
            }

        }

        private  class MiddleButton extends JButton {//窗口中间部分按钮设置
            public MiddleButton(String str) {
                this.setVisible(true);
                this.setSize(170, 50);
                this.setPreferredSize(new Dimension(170, 50));
                this.setText(str);
            }
        }
    }


    //右部分
    public  class RightPanel extends JPanel {//窗口右边部分

        RightUpCardPanel rightUpCardPanel = new RightUpCardPanel();

        RightDownCardPanel rightDownCardPanel = new RightDownCardPanel();


        public RightPanel() {
            this.setVisible(true);
            this.setSize(860, 650);
            this.setPreferredSize(new Dimension(860, 650));
            BorderLayout borderLayout = new BorderLayout();
            this.setLayout(borderLayout);
            this.setBackground(Color.PINK);

            this.add(rightUpCardPanel, BorderLayout.NORTH);
            this.add(rightDownCardPanel, BorderLayout.CENTER);
        }

        private  class RightUpCardPanel extends JPanel {//窗口右边部分上部分Card容器
            HomePageCardPanel homePageCardPanel = new HomePageCardPanel();
            TransmissionCardPanel transmissionCardPanel = new TransmissionCardPanel();


            public RightUpCardPanel() {
                this.setVisible(true);
                this.setSize(860, 40);
                this.setPreferredSize(new Dimension(860, 40));
                CardLayout cardLayout = new CardLayout();
                this.setLayout(cardLayout);

                this.add(homePageCardPanel);
                this.add(transmissionCardPanel);
            }

            private  class HomePageCardPanel extends JPanel {//窗口右边上部分首页card

                public HomePageCardPanel() {
                    this.setVisible(true);
                    this.setSize(860, 40);
                    this.setPreferredSize(new Dimension(860, 40));
                    BorderLayout borderLayout = new BorderLayout();
                    this.setLayout(borderLayout);
                    this.setBackground(Color.PINK);


                    ButtonPanel buttonPanel = new ButtonPanel();
                    this.add(buttonPanel, BorderLayout.WEST);
                }

                private  class ButtonPanel extends JPanel {

                    public ButtonPanel() {
                        this.setVisible(true);
                        this.setSize(220, 40);
                        this.setPreferredSize(new Dimension(220, 40));
                        GridLayout gridLayout = new GridLayout(1, 2, 0, 0);
                        this.setLayout(gridLayout);


                        RightButton upLoadFileButton = new RightButton("上传文件");
                        this.add(upLoadFileButton);
                        RightButton newFolderButton = new RightButton("新建文件夹");
                        this.add(newFolderButton);
                    }
                }
            }

            private  class TransmissionCardPanel extends JPanel {//窗口右边上部分传输card块

                public TransmissionCardPanel() {
                    this.setVisible(true);
                    this.setSize(860, 40);
                    this.setPreferredSize(new Dimension(860, 40));
                    BorderLayout borderLayout = new BorderLayout();
                    this.setLayout(borderLayout);
                    this.setBackground(Color.PINK);


                    ButtonPanel buttonPanel = new ButtonPanel();
                    this.add(buttonPanel, BorderLayout.WEST);
                }

                private  class ButtonPanel extends JPanel {

                    public ButtonPanel() {
                        this.setVisible(true);
                        this.setSize(220, 40);
                        this.setPreferredSize(new Dimension(220, 40));
                        GridLayout gridLayout = new GridLayout(1, 3, 0, 0);
                        this.setLayout(gridLayout);

                        RightButton allPauseButton = new RightButton("全部暂停");
                        this.add(allPauseButton);
                        RightButton allStartButton = new RightButton("全部开始");
                        this.add(allStartButton);
                        RightButton allDeleteButton = new RightButton("全部输出");
                        this.add(allDeleteButton);
                    }
                }
            }
        }

        private  class RightDownCardPanel extends JPanel {

            public RightDownCardPanel() {
                this.setVisible(true);
                this.setSize(860, 600);
                this.setPreferredSize(new Dimension(860, 600));
                CardLayout cardLayout = new CardLayout();
                this.setLayout(cardLayout);
                this.setBackground(Color.CYAN);
            }
        }

        private  class RightButton extends JButton {
            public RightButton(String str) {
                this.setVisible(true);
                this.setVisible(true);
                this.setSize(110, 40);
                this.setPreferredSize(new Dimension(110, 40));
                this.setText(str);
            }
        }
    }
}
