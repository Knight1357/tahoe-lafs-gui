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

    }
}

