import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class showListFrameDeclaration{
    JFrame frame = new JFrame();
    JPanel listContent = new JPanel();
    JPanel centerContent = new JPanel();
    JPanel centerContentTopBar = new JPanel();
    JPanel centerContentBottomBar = new JPanel();
    JPanel centerContentMiddleBar = new JPanel();
    JPanel centerContentLSideBar = new JPanel();
    JPanel centerContentRSideBar = new JPanel();
    JPanel sideBar = new JPanel();
    JButton refresh = new JButton("Refresh");

    JTabbedPane tb = new JTabbedPane();
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)  // overriding manually
        {
            return false;
        }
    };
    JTable table = new JTable(model);
    private final int pageHeight = 820;
    private final int pageWidth = 1000;
    int getPageHeight() {
        return pageHeight;
    }

    int getPageWidth() {
        return pageWidth;
    }
}
class showListFrameStyle extends showListFrameDeclaration{


    public void refreshList(){
            tb.removeAll();
            dataBaseOfBranches dbob = new dataBaseOfBranches();
            tb.addTab("ETC",dbob.Etc());
            tb.addTab("CSE",dbob.Cse());
            tb.addTab("IT",dbob.It());
            tb.addTab("CIVIL",dbob.Civil());
            tb.addTab("MECHANICAL",dbob.Mechanical());
            tb.addTab("ELECTRICAL",dbob.Electrical());
            tb.addTab("COMPANY",dbob.Company());
    }

    showListFrameStyle(){
        tb.setBackground(Color.white);
        table.setFont(new Font("ariel", Font.BOLD,12));
        sideBar.setBackground(Color.cyan);
        centerContent.setBackground(Color.white);
        listContent.setBackground(Color.white);
        centerContentBottomBar.setBackground(Color.white);
        centerContentLSideBar.setBackground(Color.white);
        centerContentRSideBar.setBackground(Color.white);
        centerContentTopBar.setBackground(Color.white);
        centerContentMiddleBar.setBackground(Color.white);
    }

}
class showListFrameDisplay extends showListFrameStyle{
    public void listDisplay(){
        frame.setLayout(new BorderLayout());
        listContent.setLayout(new BorderLayout());
        centerContent.setLayout(new BorderLayout());
        centerContentMiddleBar.setLayout(new BorderLayout());
        sideBar.setPreferredSize(new Dimension(70,820));
        centerContent.setPreferredSize(new Dimension(1000,620));

        listContent.add(sideBar,BorderLayout.WEST);
       listContent.add(centerContent,BorderLayout.CENTER);
        centerContentTopBar.setPreferredSize(new Dimension(1000,50));
        centerContentTopBar.add(refresh);
        homeDisplay.tabPane.addTab("Show List",listContent);
        centerContentBottomBar.setPreferredSize(new Dimension(1000,20));
        centerContentLSideBar.setPreferredSize(new Dimension(30,820));
        centerContentRSideBar.setPreferredSize(new Dimension(30,820));
        centerContent.add(centerContentTopBar,BorderLayout.NORTH);centerContent.add(centerContentLSideBar,BorderLayout.WEST);
        centerContent.add(centerContentBottomBar,BorderLayout.SOUTH);
        centerContent.add(centerContentRSideBar,BorderLayout.EAST);
        centerContent.add(centerContentMiddleBar,BorderLayout.CENTER);
        centerContentMiddleBar.add(tb);
        dataBaseOfBranches dbob = new dataBaseOfBranches();
        tb.addTab("ETC",dbob.Etc());
        tb.addTab("CSE",dbob.Cse());
        tb.addTab("IT",dbob.It());
        tb.addTab("CIVIL",dbob.Civil());
        tb.addTab("MECHANICAL",dbob.Mechanical());
        tb.addTab("ELECTRICAL",dbob.Electrical());
        tb.addTab("COMPANY",dbob.Company());
        refresh.addActionListener(e -> {refreshList();});

//        frame.add(sideBar,BorderLayout.WEST);
//        frame.add(listContent,BorderLayout.CENTER);
//        frame.setVisible(true);
//        frame.setSize(getPageWidth(),getPageHeight());
//        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

public class showList {
    public static void main(String[] args) {
    showListFrameDisplay slfd = new showListFrameDisplay();
    slfd.listDisplay();
    }
}
