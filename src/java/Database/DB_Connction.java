
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Connction {

    Connection con;

    public DB_Connction() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_deduction", "root", "");
    }
      public ResultSet getReport() throws SQLException
    {
           String sql = "SELECT * FROM `data`" ;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        System.out.println(result.getFetchSize());
        return result;
    }
    // Table A Month 
    public ResultSet getMonthCode(int taxMonth) throws SQLException {

        String sql = "SELECT * FROM `a_month" + taxMonth + "`;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        return result;
    }

    // Table A Week 
    public ResultSet getWeekCode(int taxWeek) throws SQLException {

        String sql = "SELECT * FROM `a_week" + taxWeek + "`;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        return result;

    }
    
    // Table C1 and C2 Month -- UK
    public ResultSet getUkMonth () throws SQLException{
        
        String sql = "SELECT * FROM `month` ;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        return result;
    }
    
    // Table C1 and C2 Week -- UK
    public ResultSet getUkWeek () throws SQLException{
        
        String sql = "SELECT * FROM `week` ;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        return result;
    }
    
    // Table C1 and C2 Month -- Scottish  
    public ResultSet getScottishMonth () throws SQLException {
        
         String sql = "SELECT * FROM `scottish monthly paid` ;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        return result;
        
    }
    
    // Table C1 and C2 Week -- Scottish  
    public ResultSet getScottishWeek () throws SQLException {
        
         String sql = "SELECT * FROM `scottish weekly paid week` ;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        return result;
        
    }
    
    
   
}
