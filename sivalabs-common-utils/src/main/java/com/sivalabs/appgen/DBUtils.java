/**
*
*
*/
package com.sivalabs.appgen;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author skatam
 * @created_on 31-Jul-2014
 */
public class DBUtils {

    public static Connection getConnection(String driverClassName, 
                                           String url, String username, String password) {
        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    public static List<String> getTableNamesFromSchema(Connection conn, String schema)
    {
        List<String> tables = new ArrayList<String>();
        
        try {
            
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tables;
    }
    
    public static List<String> getColumns(Connection conn, String tableName)
    {
        String   catalog           = null;
        String   schemaPattern     = null;
        String   columnNamePattern = null;
        
        List<String> columns = new ArrayList<String>();
        
        try {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet result = md.getColumns(catalog, schemaPattern,  tableName, columnNamePattern);

            while(result.next()){
                String columnName = result.getString(4);
                int    columnType = result.getInt(5);
                System.err.println(columnName+":"+columnType);
                columns.add(columnName);
            }
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return columns;
    }
}
