import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FileList<T> extends JList<T> {
    public FileList()
    {
        if(true)
        {
            MouseListener[] a=this.getMouseListeners();
            for(MouseListener i:a)
                this.removeMouseListener(i);

            MouseMotionListener[] b=this.getMouseMotionListeners();
            for(MouseMotionListener i:b)
                this.removeMouseMotionListener(i);;

        }
    }
}
