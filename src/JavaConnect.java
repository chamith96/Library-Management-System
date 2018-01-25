import java.sql.*;
import javax.swing.JOptionPane;
public class JavaConnect {
    private Connection con;
    
    public static Connection ConnecrDb(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Labrary System", "root","");
        return con;
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
      return null;
    } 
    }
    
}
