import org.w3c.dom.css.CSSStyleDeclaration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class homeDeclaration{
    JFrame homeFrame = new JFrame();
    static JTabbedPane tabPane = new JTabbedPane();
    JPanel homeContent = new JPanel();
    JPanel sideBar = new JPanel();
    JPanel homeDashboard = new JPanel();
    JLabel welcomeText = new JLabel("Welcome");
    JLabel toText = new JLabel("to");
    JLabel systemText = new JLabel("TnP Management System");
    private final int homepageHeight = 820;
    private final int homepageWidth = 1000;

    public int getHomepageHeight() {
        return homepageHeight;
    }
    public int getHomepageWidth() {
        return homepageWidth;
    }
}

class homeStyle extends homeDeclaration{

    homeStyle(){
        homeDashboard.setBackground(Color.yellow);
        welcomeText.setFont(new Font("Sans", Font.BOLD,55));
        toText.setFont(new Font("Sans", Font.BOLD,50));
        systemText.setFont(new Font("Sans", Font.BOLD,55));
        sideBar.setBackground(Color.cyan);

    }

}

class homeDisplay extends homeStyle{
    public void homeFrameDisplay() {
        homeFrame.setLayout(new BorderLayout());
        homeContent.setLayout(new BorderLayout());
        sideBar.setPreferredSize(new Dimension(70,820));
        homeContent.add(sideBar,BorderLayout.WEST);
        homeContent.add(homeDashboard,BorderLayout.CENTER);
        homeDashboard.setLayout(null);
        welcomeText.setBounds(60,210,260,75);
        toText.setBounds(60,315,50,60);
        systemText.setBounds(60,400,670,75);
        homeDashboard.add(welcomeText);homeDashboard.add(toText);homeDashboard.add(systemText);
        homeFrame.add((homeContent));
        tabPane.add("Home",homeContent);

        sideBar.setLayout(null);

        homeFrame.add(tabPane);
        tabPane.add("Home",homeContent);
        studentBoardDisplay sBD = new studentBoardDisplay();
        sBD.board();
        companyFrameDisplay cFD = new companyFrameDisplay();
        cFD.companyDisplay();
        showListFrameDisplay sFD = new showListFrameDisplay();
        sFD.listDisplay();


        homeFrame.setResizable(false);
        homeFrame.setVisible(true);
        homeFrame.setSize(getHomepageWidth(),getHomepageHeight());
        homeFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    }


public class homeBoard {
    public static void main(String[] args){
        homeDisplay hd = new homeDisplay();
        hd.homeFrameDisplay();

    }
}
