import javax.swing.*;
import java.awt.*;

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


                });

                LeftButton transmissionButton = new LeftButton("传输");
                transmissionButton.addActionListener(e -> {
                    middlePanel.middleCardPanel.removeAll();
                    middlePanel.middleCardPanel.add(middlePanel.middleCardPanel.transmissionCardPanel);
                    middlePanel.middleCardPanel.repaint();
                    middlePanel.middleCardPanel.revalidate();
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
    public static class MiddlePanel extends JPanel {//窗口中间部分块
        private final MiddleCardPanel middleCardPanel = new MiddleCardPanel();
        public MiddlePanel() {
            this.setVisible(true);
            this.setSize(170, 650);
            this.setPreferredSize(new Dimension(170, 650));
            this.setBackground(Color.orange);
            this.setLayout(new BorderLayout());

            this.add(middleCardPanel, BorderLayout.WEST);
            RightPanel rightPanel = new RightPanel();
            this.add(rightPanel, BorderLayout.CENTER);
        }

        public static class MiddleCardPanel extends JPanel {//中间部分card块容器
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

        private static class HomePageCardPanel extends JPanel {//中间首页部分card块

            public HomePageCardPanel() {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(new BorderLayout());

                UpButtonPanel upButtonPanel = new UpButtonPanel();
                this.add(upButtonPanel, BorderLayout.NORTH);
            }

            private static class UpButtonPanel extends JPanel {//窗口中间上部分按钮块

                public UpButtonPanel() {
                    this.setVisible(true);
                    this.setPreferredSize(new Dimension(170, 100));
                    this.setLayout(new GridLayout(2, 1, 0, 0));

                    MiddleButton myFileButton = new MiddleButton("我的文件");
                    this.add(myFileButton);
                    MiddleButton recyclingStationButton = new MiddleButton("回收站");
                    this.add(recyclingStationButton);
                }
            }
        }

        private static class TransmissionCardPanel extends JPanel {//中间传输card块

            public TransmissionCardPanel() {
                this.setVisible(true);
                this.setPreferredSize(new Dimension(170, 650));
                this.setLayout(new BorderLayout());

                UpButtonPanel upButtonPanel = new UpButtonPanel();
                this.add(upButtonPanel, BorderLayout.NORTH);
            }

            private static class UpButtonPanel extends JPanel {//窗口中间上部分按钮块

                public UpButtonPanel() {
                    this.setVisible(true);
                    this.setPreferredSize(new Dimension(170, 150));
                    this.setLayout(new GridLayout(3, 1, 0, 0));

                    MiddleButton uploadingButton = new MiddleButton("正在上传");
                    this.add(uploadingButton);
                    MiddleButton downloadingButton = new MiddleButton("正在下载");
                    this.add(downloadingButton);
                    MiddleButton downloadCompletedButton = new MiddleButton("下载完成");
                    this.add(downloadCompletedButton);
                }
            }

        }

        private static class MiddleButton extends JButton {//窗口中间部分按钮设置
            public MiddleButton(String str) {
                this.setVisible(true);
                this.setSize(170, 50);
                this.setPreferredSize(new Dimension(170, 50));
                this.setText(str);
            }
        }
    }


    //右部分
    public static class RightPanel extends JPanel {//窗口右边部分
        public RightPanel() {
            this.setVisible(true);
            this.setSize(860, 650);
            this.setPreferredSize(new Dimension(860, 650));
            BorderLayout borderLayout = new BorderLayout();
            this.setLayout(borderLayout);
            this.setBackground(Color.PINK);

            RightUpCardPanel rightUpCardPanel = new RightUpCardPanel();
            this.add(rightUpCardPanel, BorderLayout.NORTH);
            RightDownCardPanel rightDownCardPanel = new RightDownCardPanel();
            this.add(rightDownCardPanel, BorderLayout.CENTER);
        }

        private static class RightUpCardPanel extends JPanel {//窗口右边部分上部分Card容器

            public RightUpCardPanel() {
                this.setVisible(true);
                this.setSize(860, 40);
                this.setPreferredSize(new Dimension(860, 40));
                CardLayout cardLayout = new CardLayout();
                this.setLayout(cardLayout);

                HomePageCardPanel homePageCardPanel = new HomePageCardPanel();
                this.add(homePageCardPanel);
                TransmissionCardPanel transmissionCardPanel = new TransmissionCardPanel();
                this.add(transmissionCardPanel);
            }

            private static class HomePageCardPanel extends JPanel {//窗口右边上部分首页card

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

                private static class ButtonPanel extends JPanel {

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

            private static class TransmissionCardPanel extends JPanel {//窗口右边上部分传输card块

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

                private static class ButtonPanel extends JPanel {

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

        private static class RightDownCardPanel extends JPanel {

            public RightDownCardPanel() {
                this.setVisible(true);
                this.setSize(860, 600);
                this.setPreferredSize(new Dimension(860, 600));
                CardLayout cardLayout = new CardLayout();
                this.setLayout(cardLayout);
                this.setBackground(Color.CYAN);


            }
        }

        private static class RightButton extends JButton {
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
