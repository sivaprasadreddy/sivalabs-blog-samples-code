/**
*
*
*/
package com.sivalabs.appgen;

import java.sql.Connection;
import java.util.List;

/**
 * @author skatam
 * @created_on 31-Jul-2014
 */
public class AppGenTest {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        Connection conn = null;
        conn = DBUtils.getConnection("com.mysql.jdbc.Driver", 
                                       "jdbc:mysql://localhost:3306/test", 
                                       "root", "admin");
        List<String> tableNames = DBUtils.getTableNamesFromSchema(conn, "test");
        for (String table : tableNames) {
            System.out.println(table);
            List<String> columns = DBUtils.getColumns(conn, table);
            System.out.println(columns);
        }
        conn.close();
    }

}
