/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samar
 */
public class calcUsers {

    public int users(ResultSet rs, Date f, Date l) throws SQLException {
        int c = 0;

        while (rs.next()) {
            Date dbDate = rs.getDate("date");

            if (!(((dbDate.after(f) && dbDate.before(l)) || (l.equals(dbDate) || f.equals(dbDate))))) {
                continue;
            }

            c++;
        }

        return c;
    }

}
