import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FileList<T> extends JList<T> {
    public FileList()
    {
        if(true)
        {
            MouseListener[] aaa=this.getMouseListeners();
            for(MouseListener a:aaa)
                this.removeMouseListener(a);

            MouseMotionListener[] bbb=this.getMouseMotionListeners();
            for(MouseMotionListener b:bbb)
                this.removeMouseMotionListener(b);;

        }
    }
}
