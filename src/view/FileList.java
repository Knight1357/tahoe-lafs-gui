import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FileList<T> extends JList<T> {
    public FileList()
    {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==MouseEvent.BUTTON3)
                {
                    System.out.println("鼠标右击"+e.getX()+","+e.getY());
                    MouseRightPopupMenu mouseRightPopupMenu =new MouseRightPopupMenu();
                    mouseRightPopupMenu.show(e.getComponent(),e.getX(),e.getY());
                    System.out.println("选中了"+getSelectedValue().toString());

                }
                else if(e.getButton()==MouseEvent.BUTTON1)
                {
                    System.out.println("鼠标左击"+e.getX()+","+e.getY());
                    System.out.println("选中了"+getSelectedValue().toString());
                }
            }
        });
    }


}
