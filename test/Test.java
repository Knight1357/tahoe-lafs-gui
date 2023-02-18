import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Test");
        frame.setSize(1100,650);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        DefaultListModel model=new DefaultListModel();
        model.addElement("a");
        model.addElement("b");
        model.addElement("c");
        model.addElement("d");

        JList list =new JList();
        list.setModel(model);
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setSize(1100,650);

        scrollPane.setViewportView(list);


        frame.add(scrollPane);
    }
}
