import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

public class FileList<T> extends JList<T> {
    String filename;
    public FileList()
    {

        //删除所有监听器
        if(true)
        {
            MouseListener[] aaa=this.getMouseListeners();
            for(MouseListener a:aaa)
                this.removeMouseListener(a);
            MouseMotionListener[] bbb=this.getMouseMotionListeners();
            for(MouseMotionListener b:bbb)
                this.removeMouseMotionListener(b);
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()== MouseEvent.BUTTON1&&e.getClickCount()==2)//左键
                {
                    OpenDir(e);
                }
                else if(e.getButton()== MouseEvent.BUTTON3)//右键
                {
                    FileListRightClicked(e);
                }
            }
        });
    }
    public void OpenDir(MouseEvent e)//左键打开文件
    {
        int index = this.locationToIndex(e.getPoint());

        this.clearSelection();
        if(index>=0)
        {
            this.setSelectedIndex(index);
        }
        FileNode fileNode=TahoeLafs.fileListModel.getElementAt(index);

        if(fileNode.isDir)
        {
            TahoeLafs.LoadDir(fileNode.file);
            System.out.println("左键点中了"+index+" ");

            Constant.LASTPATH=Constant.NOWPATH;
            Constant.NOWPATH=fileNode.file;
        }
        else
        {
            FileOperate.viewFile(fileNode);
        }



    }
    public void FileListRightClicked(MouseEvent e)//右键事件
    {
        int index = this.locationToIndex(e.getPoint());

        this.clearSelection();
        if(index>=0) {
            this.setSelectedIndex(index);
        }
        //弹出菜单
        MouseRightPopupMenu mouseRightPopupMenu=new MouseRightPopupMenu();
        mouseRightPopupMenu.show(e.getComponent(),e.getX(),e.getY());


    }
}

