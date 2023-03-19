package JsonTransformTest;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonToHashMapExample {
    public static void main(String[] args) throws IOException {

        HashMap<String, FileNode> fileContents = new HashMap<String, FileNode>();

        //初始化树
        FileNode root = new FileNode();
        root.setName("root");
        root.setHashVal("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka");

        FileNode f1 = new FileNode();
        f1.setName("2022级郑州轻工业大学新生赛报名表.xlsx");
        f1.setHashVal("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq");

        FileNode f2 = new FileNode();
        f2.setName("新建 DOCX 文档.docx");
        f2.setHashVal("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q");

        //根节点
        FileTree fileTree=new FileTree(root);
        fileTree.setRoot(root);
        //添加节点
        fileTree.addFileNode(f1,root);
        fileTree.addFileNode(f2,root);

        //hash值
        fileContents.put("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka", root);
        fileContents.put("URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq", f1);
        fileContents.put("URI:SSK:iazixx4xacu5hx3nhbpq5lyxfe:bywfn7lus5kz34z4icecaxwxcl7bkpese6eh2rds5h7iagfy2x2q", f2);

        //读取json文件
//        FileReader reader = null;
//        try {
//            reader = new FileReader("data.json");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        Gson gson = new Gson();
//        //fromJson 读取json 字符串 + 转换的类型
//        fileContents = gson.fromJson(reader, new TypeToken<HashMap<String, FileNode>>() {
//        }.getType());
//
//        for (FileNode value : fileContents.values()) {
//            System.out.println(value);
//        }
//
//        try {//关闭文件读取
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//写入json文件
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(fileTree, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        for(FileNode i:Host.FileContents)
//        {
//            System.out.println(i);
//        }

        System.out.println("test:" + fileContents.get("URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka"));
    }
}


class FileNode {//文件节点
    private String name = "";//文件名
    private String hashVal = "";//hash值
    private boolean isDir = false;//是否是文件
    private Float size = 0f;//文件大小
    private List<FileNode> children;//子节点
    private FileNode parent;//父亲节点

    public FileNode(FileNode fileNode) {
        this.name = fileNode.name;
        this.hashVal = fileNode.hashVal;
        this.size = fileNode.size;
        this.children = new ArrayList<>();
        this.parent = null;

        //判断是不是文件
        dirJudge(hashVal);
    }

    public FileNode(String name,String hashVal,Float size) {
        this.name = name;
        this.hashVal = hashVal;
        this.size = size;
        this.children = new ArrayList<>();
        this.parent = null;
        //判断是不是文件
        dirJudge(hashVal);
    }
    public FileNode()
    {
        this.children = new ArrayList<>();
        this.parent = null;
    }

    private void dirJudge(String hashVal)//判断是不是文件
    {
        String substr = new String(hashVal.substring(4, 7));
//        System.out.println("substr="+substr);
        if (substr.equals("DIR"))
            this.isDir = true;
    }
    @Override
    public String toString() {
        return this.hashVal;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashVal() {
        return this.hashVal;
    }

    public void addChild(FileNode child)
    {
        this.children.add(child);
    }

    public void setHashVal(String hashVal) {
        this.hashVal = hashVal;
    }
    public boolean isDir() {
        return isDir;
    }
    public void setDir(boolean isDir) {
        this.isDir = isDir;
    }
    public Float getSize() {
        return size;
    }
    public void setSize(Float size) {
        this.size = size;
    }
    public List<FileNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<FileNode> children) {
        this.children = children;
    }

    public FileNode getParent() {
        return this.parent;
    }

    public void setParent(FileNode parent) {
        this.parent = parent;
    }
}

class FileTree{//文件树
    private FileNode root;//根节点

    public FileTree(FileNode root) {
        this.root = new FileNode(root);
    }//初始化树

    public FileNode getRoot() {
        return this.root;
    }
    public void setRoot(FileNode root) {//设置新的根节点
        this.root = root;
    }
    public void addFileNode(FileNode fileNode,FileNode parentNode)//为树添加节点
    {
        parentNode.addChild(fileNode);
        fileNode.setParent(parentNode);
    }
}


