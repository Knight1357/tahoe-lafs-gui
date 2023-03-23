import javax.swing.*;
import java.io.*;
import java.net.*;

public class FileOperate {
    public static void creatFile(String fileName) throws Exception//创建文件夹
    {
        System.out.println("创建文件夹");
        //http://47.115.222.245:3456/uri/URI%3ADIR2%3Awti64bj6ovkrubpngomrldezpi%3Ai7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka?t=mkdir-immutable&name=666nb
//URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka

        String hashVal=Constant.getParentNode().getHashVal();
        String urlString = "http://47.115.222.245:3456/uri/"+ URLEncoder.encode(hashVal,"UTF-8")+"?t=mkdir&name="+URLEncoder.encode(fileName,"UTF-8");
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();//获取响应代码
        if (responseCode == HttpURLConnection.HTTP_OK) {//获取文件名
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
//            JOptionPane.showMessageDialog(null,"创建成功");

            String newFilehashVal=response.toString();
            System.out.println(newFilehashVal);//输出文件节点

            TahoeLafs.addFileNode(fileName,newFilehashVal);//更新文件
            TahoeLafs.loadDir(hashVal);
        } else {//请求失败
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
            //弹出
            JOptionPane.showMessageDialog(null, "创建失败\n"+"HTTP请求失败，错误码为：" + responseCode);
        }
    }

    public static void downLoadFile()throws Exception//下载文件
    {
        System.out.println("下载文件");

        String hashVal=Constant.getIsSelectFileNode().getHashVal();//获取选中文件的hash
        String fileName=Constant.getIsSelectFileNode().getName();//获取文件名
        String urlString = "http://47.115.222.245:3456/uri/"+ URLEncoder.encode(hashVal,"UTF-8");

        //String urlString = "http://47.115.222.245:3456/uri/URI%3ACHK%3Axd3cxxdh4jk6ys5mhfzox6mdgy%3Amauyymc77s3cwdexcx5a2awpiji4bp5dwv6t4l4b4jouavqgfb4a%3A3%3A10%3A655074";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "image/png");

        int responseCode = connection.getResponseCode();//获取响应代码
        if (responseCode == HttpURLConnection.HTTP_OK) {//响应成功
            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("data/download/"+fileName);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            System.out.println("文件下载完成！");
        } else {
            System.out.println("HTTP请求失败，错误码为：" + responseCode);

            //弹窗
            JOptionPane.showMessageDialog(null, "下载失败\n"+"HTTP请求失败，错误码为：" + responseCode);
        }

    }

    public static void upLoadFile()//上传文件
    {
        System.out.println("上传文件");


    }

    public static void searchFile()//搜索文件
    {
        System.out.println("搜索文件");
        String hashVal=TahoeLafs.searchTextField.getText();//获取搜索框内容
        System.out.println("查询"+hashVal);
        if(TahoeLafs.fileContents.containsKey(hashVal))//如果存在这个文件
        {
            TahoeLafs.loadDir(hashVal);
        }
        else//不存在
        {
            TahoeLafs.loadDir(hashVal);
        }
    }

    public static void openDir()//双击打开文件夹
    {
//        System.out.println("打开文件夹");
        if(Constant.getIsSelectFileNode().isDir())
        {
            Constant.addFileLocationNode(Constant.getIsSelectFileNode().getHashVal());
            Constant.nowfile++;
            TahoeLafs.loadDir(Constant.getIsSelectFileNode().getHashVal());
        }
    }

    public static void openFile()
    {
//        System.out.println("打开文件");
        if(!Constant.getIsSelectFileNode().isDir())
        {
            System.out.println("打开文件");
        }
    }



    public static void goToHome() {//回到主页
        System.out.println("回到主页");
        TahoeLafs.loadDir(Constant.getUserPath());
        System.out.println("成功回到主页");

    }

    public static void goToFore() {//前进
        System.out.println("向前");
        if(Constant.nowfile<Constant.getFileLocationListSize()-1)
        {
            Constant.nowfile++;
            TahoeLafs.loadDir(Constant.getFileLocationNode(Constant.nowfile));
            System.out.println("成功向前");

        }
    }

    public static void goToBack() {//后退
        System.out.println("后退");
        if(Constant.nowfile>0)
        {
            Constant.nowfile--;
            TahoeLafs.loadDir(Constant.getFileLocationNode(Constant.nowfile));
            System.out.println("成功退回");
        }
    }

}
