import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


class companyFrameDeclaration{

    JFrame companyPage = new JFrame();
    JPanel sideBarCompany = new JPanel();
    public JPanel companyContent = new JPanel();
    public JPanel newCompanyContent = new JPanel();
    JLabel headline = new JLabel("Company Registration");
    JLabel companyName = new JLabel("Company Name :");
    JLabel hiringBranch = new JLabel("Hiring Branches :");
    JLabel inRs = new JLabel("( in Rs )");
    JButton addCompany = new JButton("Add Company");
    JButton clrCompany = new JButton("Clear Data");
    JRadioButton cse = new JRadioButton("CSE");
    JRadioButton it = new JRadioButton("IT");
    JRadioButton etc = new JRadioButton("ETC");
    JRadioButton civil = new JRadioButton("CIVIL");
    JRadioButton electrical = new JRadioButton("ELECTRICAL");
    JRadioButton mechanical = new JRadioButton("MECHANICAL");
    JLabel jobRole = new JLabel("Job Role :");
    JLabel jobPackage = new JLabel("Package :");
    JLabel other = new JLabel("Other :");
    JTextField companyText = new JTextField();
    JTextField packageText = new JTextField();
    JTextField jobText = new JTextField();
    JTextField otherText = new JTextField();
    private final int pageHeight = 820;
    private final int pageWidth = 1000;


    int getPageHeight() {
        return pageHeight;
    }

    int getPageWidth() {
        return pageWidth;
    }

}

class companyFrameStyle extends companyFrameDeclaration {


    public void clrCompanyBtn(){
        clrCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                companyText.setText("");
                packageText.setText(""); jobText.setText(""); otherText.setText("");
                cse.setSelected(false);it.setSelected(false);etc.setSelected(false);
                electrical.setSelected(false);civil.setSelected(false);mechanical.setSelected(false);
            }
        });
    }
    public void addCompanyBtn(){
        Map<String,String> company = new HashMap<>();
        company.put("Name",companyText.getText());
        company.put("Package",packageText.getText());
        company.put("Other",otherText.getText());
        company.put("JobRole",jobText.getText());
        Vector<String> hiringBranches = new Vector<>();
        if (cse.isSelected()) {hiringBranches.add("CSE");}
        if (it.isSelected()) {hiringBranches.add("IT");}
        if (etc.isSelected()) {hiringBranches.add("ETC");}
        if (civil.isSelected()) {hiringBranches.add("CSE");}
        if (electrical.isSelected()) {hiringBranches.add("ELECTRICAL");}
        if (mechanical.isSelected()) {hiringBranches.add("MECHANICAL");}
        addStudentData ad = new addStudentData();
        ad.addCompanyToDatabase(company,hiringBranches);
    }

    void textFieldStyle(JTextField tx ){
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

    companyFrameStyle() {
        companyContent.setBackground(Color.white);
        cse.setBackground(Color.white);
        it.setBackground(Color.white);
        etc.setBackground(Color.white);
        electrical.setBackground(Color.white);
        mechanical.setBackground(Color.white);
        civil.setBackground(Color.white);
        textFieldStyle(companyText);
        textFieldStyle(packageText);
        textFieldStyle(jobText);
        textFieldStyle(otherText);






    }
}
class companyFrameDisplay extends companyFrameStyle{


    public void companyDisplay() {

        companyPage.setLayout(new BorderLayout());
        companyPage.add(companyContent,BorderLayout.CENTER);
        companyContent.setLayout(null);
        headline.setFont(new Font("ariel", Font.BOLD,25));
        headline.setBounds(375,15,300,35);
        companyName.setBounds(50,152,220,25);
        companyName.setFont(new Font("Sans",Font.PLAIN,20));
        companyText.setBounds(230,155,250,30);
        companyText.setFont(new Font("Sans",Font.PLAIN,15));
        hiringBranch.setBounds(50,248,220,25);
        hiringBranch.setFont(new Font("Sans",Font.PLAIN,20));
        cse.setBounds(230,243,70,40);
        cse.setFont(new Font("Sans",Font.PLAIN,15));
        it.setBounds(310,243,70,40);
        it.setFont(new Font("Sans",Font.PLAIN,15));
        etc.setBounds(380,243,70,40);
        etc.setFont(new Font("Sans",Font.PLAIN,15));
        civil.setBounds(470,243,70,40);
        civil.setFont(new Font("Sans",Font.PLAIN,15));
        electrical.setBounds(560,243,130,40);
        electrical.setFont(new Font("Sans",Font.PLAIN,15));
        mechanical.setBounds(700,243,130,40);
        mechanical.setFont(new Font("Sans",Font.PLAIN,15));
        jobRole.setBounds(50,344,220,25);
        jobRole.setFont(new Font("Sans",Font.PLAIN,20));
        jobText.setBounds(230,347,250,30);
        jobText.setFont(new Font("Sans",Font.PLAIN,15));
        jobPackage.setBounds(50,440,220,25);
        jobPackage.setFont(new Font("Sans",Font.PLAIN,20));
        inRs.setBounds(62,460,100,30);
        packageText.setBounds(230,445,250,30);
        packageText.setFont(new Font("Sans",Font.PLAIN,15));
        other.setBounds(50,536,220,25);
        other.setFont(new Font("Sans",Font.PLAIN,20));
        otherText.setBounds(230,540,250,30);
        otherText.setFont(new Font("Sans",Font.PLAIN,15));
        addCompany.setBounds(204,715,200,35);
        clrCompany.setBounds(600,715,200,35);
        clrCompany.addActionListener(e -> {clrCompanyBtn();});
        addCompany.addActionListener(e -> {addCompanyBtn();});




        companyContent.add(headline);
        companyContent.add(companyName);companyContent.add(hiringBranch);companyContent.add(jobRole);companyContent.add(jobPackage);companyContent.add(other);companyContent.add(inRs);
        companyContent.add(cse);companyContent.add(it);companyContent.add(etc);companyContent.add(electrical);companyContent.add(mechanical);companyContent.add(civil);
        companyContent.add(companyText);companyContent.add(jobText);companyContent.add(otherText);companyContent.add(packageText);
        companyContent.add(addCompany);companyContent.add(clrCompany);

        sideBarCompany.setBackground(Color.cyan);
        sideBarCompany.setPreferredSize(new Dimension(70,820));

        newCompanyContent.setLayout(new BorderLayout());
        newCompanyContent.add(companyContent,BorderLayout.CENTER);
        newCompanyContent.add(sideBarCompany,BorderLayout.WEST);
        companyPage.add((newCompanyContent));

        homeDisplay.tabPane.addTab("Add Company",newCompanyContent);

//        companyPage.setVisible(true);
//        companyPage.setSize(1000,820);
//        companyPage.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

public class newCompany
{
    public static void main(String[] args)
    {
        companyFrameDisplay cd = new companyFrameDisplay();
        cd.companyDisplay();

    }
}
