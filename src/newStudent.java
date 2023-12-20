
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;


class studentBoardDeclaration{
    protected JPanel newStudentContent = new JPanel();
    static JFrame board = new JFrame();
    private final int boardHeight = 820;
    JButton addBtn = new JButton("Add Student");
    JButton clrBtn = new JButton("Clear all");
    private final int boardWidth = 1000;

    JPanel sideBar = new JPanel();
    JPanel mainContent = new JPanel();
    JLabel headLine = new JLabel("New Registration") ;
    JLabel personalDetails = new JLabel("Personal Details :") ;
    JLabel firstName = new JLabel("First Name :");
    JTextField fText= new JTextField();
    JLabel middleName = new JLabel("Middle Name :") ;
    JTextField mText= new JTextField();
    JLabel lastName = new JLabel("Last Name :") ;
    JTextField lText= new JTextField();
    JLabel branch = new JLabel("Branch :") ;
    JLabel rollNumber = new JLabel("Enrollment No:") ;
    JTextField rnText= new JTextField();
    JLabel address = new JLabel("Address :");
    JTextArea addr= new JTextArea();
    JLabel academicDetails = new JLabel("Academic Details :");
    JLabel sem1 = new JLabel("SEM-1 :") ;
    JTextField sem1_Text = new JTextField();
    JLabel sem2 = new JLabel("SEM-2 :") ;
    JTextField sem2_Text= new JTextField();
    JLabel sem3 = new JLabel("SEM-3 :") ;
    JTextField sem3_Text= new JTextField();
    JLabel sem4 = new JLabel("SEM-4 :") ;
    JTextField sem4_Text= new JTextField();
    JLabel sem5 = new JLabel("SEM-5 :") ;
    JTextField sem5_Text= new JTextField();
    JLabel sem6 = new JLabel("SEM-6 :") ;
    JTextField sem6_Text= new JTextField();
    JLabel backLog = new JLabel("Backlog :");
    String[] branches = {"CSE","IT","ETC","CIVIL","ELECTRICAL","MECHANICAL"};
    JComboBox<String> branchList = new JComboBox<>(branches);
    String[] backStatus = {"Yes","No"};
    JComboBox<String> back = new JComboBox<>(backStatus);


    protected int getBoardHeight(){
        return boardHeight ;

    }
    protected int getBoardWidth(){
        return boardWidth ;
    }

}
class studentBoardStyles extends studentBoardDeclaration{

    void textFieldStyle(JTextField tx ) {
        tx.setFont(new Font("Sans",Font.BOLD,15));
        tx.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tx.setBorder(BorderFactory.createLineBorder(Color.black,2));
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                tx.setBorder(BorderFactory.createLineBorder(Color.black,2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                tx.setBorder(BorderFactory.createLineBorder(Color.black,1));
            }
        });
    }
    void textFieldStyle(JTextArea tx ){
        tx.setFont(new Font("Sans",Font.BOLD,15));
        tx.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tx.setBorder(BorderFactory.createLineBorder(Color.black,2));
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                tx.setBorder(BorderFactory.createLineBorder(Color.black,2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                tx.setBorder(BorderFactory.createLineBorder(Color.black,1));
            }
        });
    }

    studentBoardStyles(){
        textFieldStyle(fText);
        textFieldStyle(mText);
        textFieldStyle(lText);
        textFieldStyle(rnText);
        textFieldStyle(addr);
        addr.setBorder(BorderFactory.createLineBorder(Color.black,1));
        textFieldStyle(sem1_Text);
        textFieldStyle(sem2_Text);
        textFieldStyle(sem3_Text);
        textFieldStyle(sem4_Text);
        textFieldStyle(sem5_Text);
        textFieldStyle(sem6_Text);
    }
}
class studentBoardDisplay extends studentBoardStyles{

    public void clrStudentBtn(){
       clrBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               fText.setText("");
               mText.setText(""); lText.setText(""); rnText.setText("");
               branchList.setSelectedIndex(-1);back.setSelectedIndex(-1);
               addr.setText("");
               sem1_Text.setText("");sem2_Text.setText("");sem3_Text.setText("");
               sem4_Text.setText("");sem5_Text.setText("");sem6_Text.setText("");
           }
       });
    }

    public void addbtn(){
        addBtn.addActionListener(e -> {

            Map<String,String> tmp = new HashMap<>();
            tmp.put("firstName",fText.getText());
            tmp.put("middleName",mText.getText());
            tmp.put("lastName",lText.getText());
            tmp.put("rollNumber",rnText.getText());
            tmp.put("branch",branchList.getSelectedItem().toString());
            tmp.put("sem1",sem1_Text.getText());
            tmp.put("sem2",sem2_Text.getText());
            tmp.put("sem3",sem3_Text.getText());
            tmp.put("sem4",sem4_Text.getText());
            tmp.put("sem5",sem5_Text.getText());
            tmp.put("sem6",sem6_Text.getText());
            tmp.put("backlog",back.getSelectedItem().toString());
            addStudentData ad = new addStudentData();
            ad.addStudentToDataBase(tmp);
        });
    }
    public void board(){
        board.setLayout(new BorderLayout());
        newStudentContent.setLayout(new BorderLayout());

        headLine.setFont(new Font("ariel", Font.BOLD,25));
        headLine.setBounds(375,15,260,35);

        personalDetails.setFont(new Font("SansSerif",Font.PLAIN,25));
        personalDetails.setBounds(50,90,260,40);

        firstName.setFont(new Font("Sans",Font.PLAIN,15));
        firstName.setBounds(50,162,100,20);
        middleName.setFont(new Font("Sans",Font.PLAIN,15));
        middleName.setBounds(480,162,100,20);
        lastName.setFont(new Font("Sans",Font.PLAIN,15));
        lastName.setBounds(50,216,100,20);
        branch.setFont(new Font("Sans",Font.PLAIN,15));
        branch.setBounds(50,270,100,20);
        rollNumber.setFont(new Font("Sans",Font.PLAIN,15));
        rollNumber.setBounds(480,270,110,20);
        address.setFont(new Font("Sans",Font.PLAIN,15));
        address.setBounds(50,325,100,20);

        academicDetails.setFont(new Font("SansSerif",Font.PLAIN,25));
        academicDetails.setBounds(50,397,260,40);
        sem1.setFont(new Font("Sans",Font.PLAIN,15));
        sem1.setBounds(50,480,100,20);

        sem2.setFont(new Font("Sans",Font.PLAIN,15));
        sem2.setBounds(480,480,100,20);

        sem3.setFont(new Font("Sans",Font.PLAIN,15));
        sem3.setBounds(50,550,100,20);

        sem4.setFont(new Font("Sans",Font.PLAIN,15));
        sem4.setBounds(480,550,100,20);

        sem5.setFont(new Font("Sans",Font.PLAIN,15));
        sem5.setBounds(50,610,100,20);

        sem6.setFont(new Font("Sans",Font.PLAIN,15));
        sem6.setBounds(480,610,100,20);

        backLog.setFont(new Font("Sans",Font.PLAIN,15));
        backLog.setBounds(50,660,100,20);

        addBtn.setBounds(204,715,200,35);
        clrBtn.setBounds(600,715,200,35);

        mainContent.add(headLine);
        fText.setBounds(180,155,230,30);
        mainContent.add(fText);
        mText.setBounds(630,155,230,30);
        mainContent.add(mText);
        lText.setBounds(180,210,230,30);
        mainContent.add(lText);
        rnText.setBounds(630,263,230,30);
        mainContent.add(rnText);
        branchList.setBounds(180,263,100,30);
        branchList.setSelectedIndex(-1);
        mainContent.add(branchList);
        addr.setBounds(180,318,230,30);
        mainContent.add(addr);
        sem1_Text.setBounds(180,475,230,30);
        mainContent.add(sem1_Text);
        sem2_Text.setBounds(630,475,230,30);
        mainContent.add(sem2_Text);
        sem3_Text.setBounds(180,545,230,30);
        mainContent.add(sem3_Text);
        sem4_Text.setBounds(630,545,230,30);
        mainContent.add(sem4_Text);
        sem5_Text.setBounds(180,600,230,30);
        mainContent.add(sem5_Text);
        sem6_Text.setBounds(630,600,230,30);
        mainContent.add(sem6_Text);
        back.setBounds(180,655,100,25);
        back.setSelectedIndex(1);

        mainContent.add(firstName);mainContent.add(middleName);mainContent.add(lastName);mainContent.add(branch);
        mainContent.add(rollNumber);mainContent.add(address);
        mainContent.add(sem1);mainContent.add(sem2);mainContent.add(sem3);mainContent.add(sem4);mainContent.add(sem5);mainContent.add(sem6);
        mainContent.add(personalDetails);mainContent.add(academicDetails);mainContent.add(backLog);mainContent.add(addBtn);mainContent.add(clrBtn);
        mainContent.add(back);

        mainContent.setLayout(null);
        sideBar.setBackground(Color.cyan);
        sideBar.setPreferredSize(new Dimension(70,820));
        newStudentContent.add(sideBar,BorderLayout.WEST);
        mainContent.setBackground(Color.white);
        newStudentContent.add(mainContent,BorderLayout.CENTER);
        addbtn();clrStudentBtn();
        homeDisplay.tabPane.addTab("Add Student",newStudentContent);



//        board.add(newStudentContent);
//
//
//        board.setResizable(false);
//        board.getContentPane().setBackground(Color.white);
//        board.setVisible(true);
//        board.setSize(getBoardWidth(),getBoardHeight());
//        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}

public class newStudent {
    public static void main(String[] args) {
        studentBoardDisplay sd = new studentBoardDisplay();
        sd.board();

    }
}