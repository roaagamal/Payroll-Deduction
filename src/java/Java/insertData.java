/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samar
 */
public class insertData {

    Calculate_Code c = new Calculate_Code();

    public insertData(Calculate_Code cal) {

        try {
            //System.out.println("insert data£££££££££££££££££3");
            String sM = cal.getSelectedMonth();
            //System.out.println("SelectedMonth"+sM);
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_deduction", "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO `data` "
                    + "(`first_name`, `last_name`, `code`, `grosspay`, `Total Free Pay`, `Total pay to date`,"
                    + " `Total tax due`, `date`, `SelectedPer`, `Nationality`) VALUES (?,?,?,?,?,?,?,?,?,?);");
            
            
            ps.setString(1, cal.getFristName());
            ps.setString(2, cal.getLastName());
            ps.setString(3, cal.getCode());
            ps.setFloat(4, (float) cal.getGrossPay());
            ps.setFloat(5, (float) cal.CodeCalculate());
            ps.setFloat(6, (float) cal.totalPayToDate());
            ps.setFloat(7, cal.totalTaxDue());
            ps.setDate(8, Date.valueOf(LocalDate.now()));
            ps.setString(9, cal.getSelectedPer());
            ps.setString(10, cal.getNationality());
            ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            //  Logger.getLogger(Calculate_Tax.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
