import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
class Home{
    private String userName = "abhishek";
    private String userPass = "abhi123";
    static JFrame loginPage = new JFrame();
    static JPanel loginPagePanel = new JPanel();
    static JPanel top = new JPanel();
    static JPanel bottom = new JPanel();
    static JPanel left = new JPanel();
    static JPanel right = new JPanel();
    static JButton submit = new JButton("Login");

    public boolean checkUser(String x , char[] y){
        String str = "";
        for (char c : y) {
            str = str + c;
        }
        return (x.equals(userName) && str.equals(userPass));
    }


    public void userInfoSet(){

        loginPage.setLayout(new BorderLayout());

        JLabel userNameLabel = new JLabel("Username :");
        JTextField userNameText = new JTextField();
        JLabel userPassLabel = new JLabel("Password :");
        JPasswordField userPass = new JPasswordField();

        int loginPageWidth = 600;
        int loginPageheight = 400;
        int loginPagePanelWidth = 400;
        int loginPagePanelHeight = 300;

        loginPagePanel.setPreferredSize(new Dimension(loginPageWidth,loginPageheight));
        top.setPreferredSize(new Dimension(loginPageWidth,(loginPageheight-loginPagePanelHeight)/2));
        right.setPreferredSize(new Dimension((loginPageWidth-loginPagePanelWidth)/2,loginPageheight));
        left.setPreferredSize(new Dimension((loginPageWidth-loginPagePanelWidth)/2,loginPageheight));
        bottom.setPreferredSize(new Dimension(loginPageWidth,(loginPageheight-loginPagePanelHeight)/2));

        loginPage.add(top,BorderLayout.PAGE_START);
        loginPage.add(bottom,BorderLayout.PAGE_END);
        loginPage.add(left,BorderLayout.EAST);
        loginPage.add(right,BorderLayout.WEST);


//         top.setBackground(new Color(0,0,0,0));    // last one for alpha for opacity
        top.setBackground(new Color(0,0,0,0));
        right.setBackground(new Color(0,0,0,0));
        left.setBackground(new Color(0,0,0,0));
        bottom.setBackground(new Color(0,0,0,0));
        loginPage.getContentPane().setBackground(Color.cyan);
        loginPagePanel.setBackground(Color.white);



        loginPagePanel.setLayout(null);
        userNameLabel.setBounds(25,80,125,20);
        userNameLabel.setFont(new Font("Monospaced",Font.BOLD,20));
        loginPagePanel.add(userNameLabel);

        userNameText.setBounds(155,80,150,20);
        userNameText.setFont(new Font("Monospaced",Font.BOLD,15));
        userNameText.setBorder(BorderFactory.createEmptyBorder());
        loginPagePanel.add(userNameText);

        userPassLabel.setBounds(25,150,125,20);
        userPassLabel.setFont(new Font("Monospaced",Font.BOLD,20));
        loginPagePanel.add(userPassLabel);

        userPass.setBounds(155,150,150,20);
        userPass.setFont(new Font("Monospaced",Font.BOLD,20));
        userPass.setBorder(BorderFactory.createEmptyBorder());
        loginPagePanel.add(userPass);

        submit.setBounds(105,210,170,30);
        submit.setFont(new Font("Monospaced",Font.BOLD,20));
        loginPagePanel.add(submit);

        userNameText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                userNameText.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
            }
            @Override
            public void focusLost(FocusEvent e) {
                userNameText.setBorder(BorderFactory.createEmptyBorder());
            }
        });

        userPass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userPass.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
            }
            @Override
            public void focusLost(FocusEvent e) {

                userPass.setBorder(BorderFactory.createEmptyBorder());
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(checkUser(userNameText.getText(),userPass.getPassword())){
                    JOptionPane.showMessageDialog(loginPage,"Logged In");
//                    homeDisplay hd = new homeDisplay();
//                    hd.homeFrameDisplay();
                    loginPage.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(loginPage,"Wrong Password");
//                    loginPage.dispose();
                }

            }
        });



        loginPage.setResizable(false);
        loginPage.add(loginPagePanel,BorderLayout.CENTER);
        loginPage.setSize(loginPageWidth,loginPageheight);
        loginPage.setVisible(true);
        loginPage.setDefaultCloseOperation(loginPage.EXIT_ON_CLOSE);

    }
}
public class mainSystem {

    public static void main(String[] args){
    Home hm = new Home();
    hm.userInfoSet();

    }
}
