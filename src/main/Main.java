import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.HashMap;

/**
 * @author liushen
 */
public class Main {
    //主窗口
    private static final JFrame mainWindow = new JFrame();//主窗口
    //上部分
    private static final JPanel upPanel = new JPanel();//上部分
    private static final JPanel operatePanel = new JPanel();//文件操作块
    private static final JPanel searchPanel = new JPanel();//文件搜索块
    public static JTextField searchTextField = new JTextField();//搜索文本框
    private static final JButton searchButton = new JButton();//搜索按钮
    private static final JPanel operateButtonPanel = new JPanel();//文件操作按钮块
    private static final JButton uploadButton = new JButton();//上传文件按钮
    private static final JButton downloadButton = new JButton();//下载文件按钮
    private static final JButton makeDirectoryButton = new JButton();//新建文件按钮

    private static final JPanel fileSwitchPanel = new JPanel();//文件切换

    private static final JButton homeButton = new JButton();
    private static final JButton foreButton = new JButton();
    private static final JButton backButton = new JButton();

    private static final JPanel informationPanel = new JPanel();//信息块
    private static final JPanel firstInformationPanel = new JPanel();//首部分信息块
    private static final JLabel fileNameLabel = new JLabel();//文件名标签
    private static final JPanel otherInformationPanel = new JPanel();//文件其他信息块
    private static final JLabel fileSizeLabel = new JLabel();//文件大小标签
    private static final JLabel fileDateLabel = new JLabel();//文件日期标签
    //下部分
    private static final JScrollPane fileScrollPanel = new JScrollPane();
    private static final FileList<FileNode> fileList = new FileList<>();//文件列表
    private static final FileListModel fileListModel = new FileListModel();//文件列表模式
    private static final FileListCellRenderer fileListCellRenderer = new FileListCellRenderer();//文件列表渲染器
    public static HashMap<String, FileNode> fileContents = new HashMap<>();//哈希表文件信息存储

    public static void addFileNode(String fileName, String hashVal) {
        FileNode fileNode = new FileNode(fileName, hashVal);
        Constant.getParentNode().getFileContents().add(fileNode.getHashVal());
        fileContents.put(fileNode.getHashVal(), fileNode);
    }

    void initButton() {
        searchButton.setText("搜索文件");
        searchButton.setSize(80, 35);
        searchButton.setPreferredSize(new Dimension(80, 35));

        uploadButton.setText("上传文件");
        uploadButton.setSize(80, 35);
        uploadButton.setPreferredSize(new Dimension(80, 35));


        downloadButton.setText("下载文件");
        downloadButton.setSize(80, 35);
        downloadButton.setPreferredSize(new Dimension(80, 35));


        makeDirectoryButton.setText("新建文件");
        makeDirectoryButton.setSize(80, 35);
        makeDirectoryButton.setPreferredSize(new Dimension(80, 35));


        homeButton.setText("home");
        homeButton.setSize(80, 35);
        homeButton.setPreferredSize(new Dimension(80, 35));


        foreButton.setText("前进");
        foreButton.setSize(80, 35);
        foreButton.setPreferredSize(new Dimension(80, 35));


        backButton.setText("退回");
        backButton.setSize(80, 35);
        backButton.setPreferredSize(new Dimension(80, 35));

    }

    void initLabel() {//初始化标签
        fileNameLabel.setVisible(true);
        fileNameLabel.setSize(100, 20);
        fileNameLabel.setPreferredSize(new Dimension(100, 20));
        fileNameLabel.setText("文件名称");

        fileSizeLabel.setVisible(true);
        fileSizeLabel.setSize(100, 20);
        fileSizeLabel.setPreferredSize(new Dimension(100, 20));
        fileSizeLabel.setText("文件大小");

        fileDateLabel.setVisible(true);
        fileDateLabel.setSize(100, 20);
        fileDateLabel.setPreferredSize(new Dimension(100, 20));
        fileDateLabel.setText("文件日期");
    }

    void initPanel() {//初始化块
        mainWindow.setVisible(true);
        mainWindow.setSize(850, 700);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setLayout(new BorderLayout());

        upPanel.setVisible(true);
        upPanel.setSize(600, 100);
        upPanel.setPreferredSize(new Dimension(600, 100));
        upPanel.setLayout(new BorderLayout());

        operatePanel.setVisible(true);
        operatePanel.setSize(600, 80);
        operatePanel.setPreferredSize(new Dimension(600, 90));
        operatePanel.setLayout(new GridLayout(2, 1, 0, 0));


        searchPanel.setVisible(true);
        searchPanel.setSize(600, 40);
        searchPanel.setPreferredSize(new Dimension(600, 40));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        operateButtonPanel.setVisible(true);
        operateButtonPanel.setSize(400, 40);
        operateButtonPanel.setPreferredSize(new Dimension(400, 40));
        operateButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        fileSwitchPanel.setVisible(true);
        fileSwitchPanel.setSize(300, 60);
        fileSwitchPanel.setPreferredSize(new Dimension(300, 60));
        fileSwitchPanel.setLayout(new GridLayout(1, 3, 0, 0));


        informationPanel.setVisible(true);
        informationPanel.setSize(600, 20);
        informationPanel.setPreferredSize(new Dimension(600, 20));
        informationPanel.setLayout(new BorderLayout(10, 0));


        firstInformationPanel.setVisible(true);
        firstInformationPanel.setPreferredSize(new Dimension(300, 20));
        firstInformationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));


        otherInformationPanel.setVisible(true);
        otherInformationPanel.setPreferredSize(new Dimension(300, 20));
        otherInformationPanel.setLayout(new GridLayout(1, 2, 10, 0));

        fileScrollPanel.setVisible(true);


    }

    void initText()//初始化文本
    {
        searchTextField.setVisible(true);
        searchTextField.setSize(400, 35);
        searchTextField.setPreferredSize(new Dimension(400, 35));
    }


    void init()//初始化窗口
    {
        //初始化界面
        initLabel();//初始化标签
        initPanel();//初始化块
        initTop();//初始化上部分
        initCenter();//初始化中间部分
        initListener();//初始化监听器
        initButton();//初始化按钮
        initText();//初始化文本
        mainWindow.show();

        fromJson();//读取json文件

//        addFileNode("111.jepg","URI:CHK:xd3cxxdh4jk6ys5mhfzox6mdgy:mauyymc77s3cwdexcx5a2awpiji4bp5dwv6t4l4b4jouavqgfb4a:3:10:655074");

        toJson();//写入json文件

        //测试输出
        for (FileNode value : fileContents.values()) {
            System.out.println(value);
        }

        System.out.println("test:" + fileContents.get("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka"));

        //读取根目录
        loadDir(Constant.getUserPath());

    }


    public static void loadDir(String hashVal) {    //读取文件夹文件
        toJson();
        fromJson();
        if (fileContents.containsKey(hashVal)) {
            FileNode temp = fileContents.get(hashVal);
            if (!hashVal.isEmpty())
                fileListModel.removeAllElements();//清空所有元素

            if (temp.isDir()) {//文件夹，插入文件夹中的元素
                Constant.setParentNode(temp);//记录父级文件夹
                for (String i : temp.getFileContents()) {
                    FileNode cur = fileContents.get(i);
                    fileListModel.addElement(cur);
                }
            } else {//文件，插入当前文件
                fileListModel.addElement(temp);
            }
            System.out.println("成功读取文件");
        } else {
            fileListModel.removeAllElements();//清空所有元素
            System.out.println("查无此文件");
        }

    }

    void initTop()//初始化上部分
    {
        mainWindow.add(upPanel, BorderLayout.NORTH);//添加上部分块

        upPanel.add(operatePanel, BorderLayout.WEST);//添加文件操作块

        operatePanel.add(searchPanel);//添加搜索块

        searchPanel.add(searchTextField);//添加搜索文本框

        searchPanel.add(searchButton);//添加搜索按钮

        operatePanel.add(operateButtonPanel);//添加文件操作块

        operateButtonPanel.add(uploadButton);//添加上传文件按钮

        operateButtonPanel.add(downloadButton);//添加下载文件按钮

        operateButtonPanel.add(makeDirectoryButton);//添加新建文件夹按钮

        upPanel.add(fileSwitchPanel, BorderLayout.EAST);

        fileSwitchPanel.add(homeButton);

        fileSwitchPanel.add(backButton);

        fileSwitchPanel.add(foreButton);

        upPanel.add(informationPanel, BorderLayout.SOUTH);//添加信息块

        informationPanel.add(firstInformationPanel, BorderLayout.WEST);//添加首要信息块

        firstInformationPanel.add(fileNameLabel);//添加文件名列

        informationPanel.add(otherInformationPanel, BorderLayout.EAST);//添加其他信息块

        otherInformationPanel.add(fileSizeLabel);//添加文件大小列

        otherInformationPanel.add(fileDateLabel);//添加文件日期列
    }

    void initCenter()//初始化中间部分
    {
        mainWindow.add(fileScrollPanel, BorderLayout.CENTER);//添加文件列表块

        fileList.setModel(fileListModel);//设置列表模式
        fileList.setCellRenderer(fileListCellRenderer);//设置文件列表渲染器
        fileScrollPanel.setViewportView(fileList);//设置显示的列表

    }

    void initListener()//初始化监听器
    {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperate.searchFile();
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperate.upLoadFile();
            }
        });
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Constant.getIsSelectFileNode().isDir())//不是文件夹可以下载
                {
                    try {
                        System.out.println("下载文件正常");
                        FileOperate.downLoadFile();
                    } catch (Exception ex) {
                        System.out.println("下载文件异常");
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "下载失败\n无法下载文件夹");
                }
            }
        });

        makeDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//新建文件
                String str = JOptionPane.showInputDialog(null, "请输入文件名称：\n", "新建文件", JOptionPane.PLAIN_MESSAGE);
                System.out.println(str);
                if (!str.isEmpty()) {
                    try {
                        System.out.println("新建文件正常");
                        FileOperate.creatFile(str);
                    } catch (Exception ex) {
                        System.out.println("新建文件异常");
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperate.goToHome();
            }
        });
        foreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperate.goToFore();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperate.goToBack();
            }
        });

        fileList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //左键 双击
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    //打开文件夹
                    if (Constant.getIsSelectFileNode().isDir()) {
                        FileOperate.openDir();
                    } else//打开文件
                    {
                        FileOperate.openFile();
                    }
                }
            }
        });


    }

    public static void toJson()//写入json文件
    {
        ////写入json
        //初始化
//        FileNode Host = new FileNode("User", "URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka");
//        FileNode f1 = new FileNode("2022级郑州轻工业大学新生赛报名表.xlsx", "URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");
//        FileNode f2 = new FileNode("新建 DOCX 文档.docx", "URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");
//        Host.getFileContents().add("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");
//        Host.getFileContents().add("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");
//        fileContents.put("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka", Host);
//        fileContents.put("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq", f1);
//        fileContents.put("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q", f2);

        //写入到data.json文件
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("data/Data.json");
            gson.toJson(fileContents, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fromJson()//读取json文件
    {
        //读取json
        FileReader reader = null;
        try {
            reader = new FileReader("data/Data.json");//读取的json文件
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        fileContents = gson.fromJson(reader, new TypeToken<HashMap<String, FileNode>>() {
        }.getType());
        System.out.println(fileContents);
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        Main mainWindow = new Main();
        mainWindow.init();
    }
}