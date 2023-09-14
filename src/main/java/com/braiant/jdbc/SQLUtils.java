package com.braiant.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class SQLUtils {
    private final static String DATA_SQL_FOLDER = System.getProperty("user.dir") +"/src/main/resources/queries/";
    private static Connection connection;
    private static Statement statement;
    private static Connection getDBConnection(String dbName) throws SQLException {
        return connection = DriverManager.getConnection(
                String.format("jdbc:mysql://%s:%s/%s?useSSL=false",
                        DataBaseInfo.DBHOST.dbConn, DataBaseInfo.DBPORT.dbConn, dbName),
                DataBaseInfo.DBUSERNAME.dbConn, DataBaseInfo.DBPASSWORD.dbConn);
    }
    private static Statement getStatement(String dbName) throws SQLException {
        return statement = getDBConnection(dbName)
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    private static String readSqlfiles(String sqlfile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(DATA_SQL_FOLDER + sqlfile));
        StringBuilder sb = new StringBuilder();
        String line;

        /*while((line = br.readLine()) != null){
            sb.append(line);
        }*/
        while(Optional.ofNullable((line = br.readLine())).isPresent()){
            sb.append(line);
        }
        return sb.toString();
    }

    public static ResultSet getResultSet(String dbName, String sqlFile) throws SQLException, IOException {
        return getStatement(dbName).executeQuery(readSqlfiles(sqlFile));
    }
    public static void closeConnection() throws SQLException {
        //if(statement !=null) statement.close();
        //if(connection!=null) connection.close();

        if (Optional.ofNullable(statement).isPresent()) statement.close();
        if (Optional.ofNullable(connection).isPresent()) connection.close();


    }
}
