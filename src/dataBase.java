import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Map;
import java.sql.*;
import java.util.Vector;


class updateInSql{

    public static void deleteData(int row, String dbName) {
        Connection conn = null;
        String rowID = (row + 1) + ""; // Converting into string

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // DELETE query
            String deleteQuery = "DELETE FROM " + dbName + " WHERE ROWID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, rowID);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Delete successful. Rows affected: " + rowsDeleted);
            } else {
                System.out.println("No records were deleted.");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void updateData(String colName, String value, int row, String dbName) {
        Connection conn = null;
        String rowID = (row + 1) + ""; // converting into string

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // UPDATE query
            String updateQuery = "UPDATE " + dbName + " SET " + colName + " = ? WHERE ROWID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, rowID);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Update successful. Rows affected: " + rowsUpdated);
            } else {
                System.out.println("No records were updated.");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

class dataBaseOfBranches{
    static JFrame frame = new JFrame();
    public JScrollPane Etc(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable etcTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(etcTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ETC");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        etcTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in " + etcTable.getColumnName(etcTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = etcTable.getColumnName(etcTable.getSelectedColumn());
                    int RowNumber = etcTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"ETC");
                    }
                    else {
                        etcTable.setValueAt(ans,RowNumber,etcTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"ETC");
                    }
                }
            }
        });


        return scrollPane;
    }
    public  JScrollPane Cse(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable cseTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(cseTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CSE");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in "+cseTable.getColumnName(cseTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = cseTable.getColumnName(cseTable.getSelectedColumn());
                    int RowNumber = cseTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"CSE");
                    }
                    else {
                        cseTable.setValueAt(ans,RowNumber,cseTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"CSE");
                    }
                }
            }
        });

        return scrollPane;
    }
    public  JScrollPane It(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable itTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(itTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM IT");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        itTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in "+itTable.getColumnName(itTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = itTable.getColumnName(itTable.getSelectedColumn());
                    int RowNumber = itTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"IT");
                    }
                    else {
                        itTable.setValueAt(ans,RowNumber,itTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"IT");
                    }
                }
            }
        });

        return scrollPane;
    }
    public  JScrollPane Mechanical(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable mechanicalTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(mechanicalTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MECHANICAL");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mechanicalTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in "+mechanicalTable.getColumnName(mechanicalTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = mechanicalTable.getColumnName(mechanicalTable.getSelectedColumn());
                    int RowNumber = mechanicalTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"MECHANICAL");
                    }
                    else {
                        mechanicalTable.setValueAt(ans,RowNumber,mechanicalTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"MECHANICAL");
                    }
                }
            }
        });

        return scrollPane;
    }
    public  JScrollPane Civil(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable civilTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(civilTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CIVIL");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        civilTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in "+ civilTable.getColumnName(civilTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = civilTable.getColumnName(civilTable.getSelectedColumn());
                    int RowNumber = civilTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"CIVIL");
                    }
                    else {
                        civilTable.setValueAt(ans,RowNumber,civilTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"CIVIL");
                    }
                }
            }
        });

        return scrollPane;
    }
    public  JScrollPane Electrical(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable electricalTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(electricalTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ELECTRICAL");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        electricalTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in "+electricalTable.getColumnName(electricalTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = electricalTable.getColumnName(electricalTable.getSelectedColumn());
                    int RowNumber = electricalTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"ELECTRICAL");
                    }
                    else {
                        electricalTable.setValueAt(ans,RowNumber,electricalTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"ELECTRICAL");
                    }
                }
            }
        });

        return scrollPane;
    }
    public  JScrollPane Company(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)  // overriding manually
            {
                return false;
            }
        };
        JTable companyTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(companyTable);
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute an SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM COMPANY");

            // Get the column count from the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }



            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        companyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    String ans = JOptionPane.showInputDialog(frame,"1)DELETE for deletion of Current Row \n 2)Enter Value to update","Update Value in "+companyTable.getColumnName(companyTable.getSelectedColumn()),JOptionPane.QUESTION_MESSAGE);
                    String columnName = companyTable.getColumnName(companyTable.getSelectedColumn());
                    int RowNumber = companyTable.getSelectedRow();
                    if(ans ==null){
                        System.out.println("null");
                    }
                    else if(ans.isEmpty()){
                        System.out.println("blank");
                    }
                    else if (ans.equals("DELETE")){
                        System.out.println("delete");
                        updateInSql.deleteData(RowNumber,"COMPANY");
                    }
                    else {
                        companyTable.setValueAt(ans,RowNumber,companyTable.getSelectedColumn());
                        updateInSql.updateData(columnName,ans,RowNumber,"COMPANY");
                    }
                }
            }
        });

        return scrollPane;
    }
}
class addStudentData {
    public void addCompanyToDatabase(Map<String,String>company, Vector<String>hiringBranches){
        homeDeclaration hd = new homeDeclaration();
        String branchesHiring="";
        for(String name:hiringBranches){
            if(name.equals(hiringBranches.lastElement())){
                branchesHiring = branchesHiring + name;
            }
            else{
                branchesHiring = branchesHiring + name + ",";
            }
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Establish a database connection
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Define the INSERT query
            String insertQuery = "INSERT INTO COMPANY (name,[Hiring Branches],[Job Role],Package,Other) VALUES(?,?,?,?,?)";

            // Create a PreparedStatement for the INSERT query
            preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for placeholders
            preparedStatement.setString(1, company.get("Name")); // Replace with the actual name
            preparedStatement.setString(2, branchesHiring);
            preparedStatement.setString(3, company.get("JobRole"));
            preparedStatement.setString(4,company.get("Package"));
            preparedStatement.setString(5,company.get("Other"));
            // Execute the INSERT query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Insertion successful. Rows inserted: " + rowsInserted);
                JOptionPane.showMessageDialog(hd.homeFrame,"Added Successfully !!\nCheck Show List Section if not Refresh it");
            } else {
                System.out.println("No rows were inserted.");
            }
            System.out.println("done");

        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    public void addStudentToDataBase(Map<String, String> tmp) {
        String fullName = tmp.get("firstName") + " " + tmp.get("middleName") + " " + tmp.get("lastName");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        homeDeclaration hd = new homeDeclaration();
        try {
            // Establish a database connection
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:tnpdata.db");

            // Define the INSERT query
            //            String insertQuery = "INSERT INTO data (Name,EnrollmentNo,Branch,Semester1,Semester2,Semester3,Semester4,Semester5,Semester6,Status) VALUES(\"Abhishek Balwant Deshpande\",\"BE20F04F043\",\"ENTC\",10,9,8,7,8,0,\"Yes\")";
            String insertQuery = "INSERT INTO " + tmp.get("branch") + " (Name,EnrollmentNo,Branch,Semester1,Semester2,Semester3,Semester4,Semester5,Semester6, Placement) VALUES(?,?,?,?,?,?,?,?,?,?)";

            // Create a PreparedStatement for the INSERT query
            preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for placeholders
            preparedStatement.setString(1, fullName); // Replace with the actual name
            preparedStatement.setString(2, tmp.get("rollNumber"));
            preparedStatement.setString(3, tmp.get("branch"));
            preparedStatement.setString(4, tmp.get("sem1"));
            preparedStatement.setString(5, tmp.get("sem2"));
            preparedStatement.setString(6, tmp.get("sem3"));
            preparedStatement.setString(7, tmp.get("sem4"));
            preparedStatement.setString(8, tmp.get("sem5"));
            preparedStatement.setString(9, tmp.get("sem6"));
            preparedStatement.setString(10, ("-"));

            // Execute the INSERT query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Insertion successful. Rows inserted: " + rowsInserted);
                JOptionPane.showMessageDialog(hd.homeFrame,"Added Successfully !!\nCheck Show List Section if not Refresh it");
            } else {
                System.out.println("No rows were inserted.");
            }
            System.out.println("done");

        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }

}
public class dataBase {
    public static void main(String[] args) {
        dataBaseOfBranches dbob = new dataBaseOfBranches();
        JTabbedPane tb = new JTabbedPane();
        tb.addTab("ETC",dbob.Etc());
        tb.addTab("CSE",dbob.Cse());
        tb.addTab("IT",dbob.It());
        tb.addTab("CIVIL",dbob.Civil());
        tb.addTab("MECHANICAL",dbob.Mechanical());
        tb.addTab("ELECTRICAL",dbob.Electrical());
        tb.addTab("COMPANY",dbob.Company());
        dataBaseOfBranches.frame.add(tb);
        dataBaseOfBranches.frame.setSize(600, 400);
        dataBaseOfBranches.frame.setVisible(true);
    }
}