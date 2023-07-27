// Get connect to database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class config {
    private static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        try {
            final String DB = "name_db";
            final String url="jdbc:mysql://localhost:3306/"+DB;
            final String user="root";
            final String pass="";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig=DriverManager.getConnection(url, user, pass);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Error : " + e);
        }
        return mysqlconfig;
    }    
}

// Create Data with database
try {
            String SQLQuery = "";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(SQLQuery);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
} catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
}

// Get data all with database
DefaultTableModel model = new DefaultTableModel();
model.addColumn("name_collums");

try {
    int no=1;
    String SQLQuery = "";
    java.sql.Connection conn = (Connection)config.configDB();
    java.sql.Statement stm = conn.createStatement();
    java.sql.ResultSet res = stm.executeQuery(SQLQuery);
    while(res.next()){
        model.addRow(new Object[]{no++,res.getString(1)});
    }
    jTable1.setModel(model);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}

//
