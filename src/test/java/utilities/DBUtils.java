package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private DBUtils(){}
    private static String URL = Config.getProperties("dataBaseUrl");
    private static String DBUserName = Config.getProperties("dataBaseUsername");
    private static String DBPassword = Config.getProperties("dataBasePassword");

    private static String oraURL = Config.getProperties("dataBaseUrl");
    private static String oraDBUserName = Config.getProperties("dataBaseUsername");
    private static String oraDBPassword = Config.getProperties("dataBasePassword");

    static Connection connection=null;
    static Statement statement=null;
    static ResultSet resultSet;

    public enum DbType{
        MySQl,Oracle
    }

    public static Connection getConnection(DbType dbType){
        try {
            switch (dbType){
                case MySQl:
                    return DriverManager.getConnection(URL,DBUserName,DBPassword);
                case Oracle:
                    return DriverManager.getConnection(oraURL, oraDBUserName, oraDBPassword);
                default:
                    throw new RuntimeException("Invalid database passed");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(){
        try {
            if (resultSet!=null)resultSet.close();
            if (statement!=null)statement.close();
            if (connection!=null)connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String[]> runQuery(String sql){
        List<String[]> queryResults = new ArrayList<>();
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnsCount = metaData.getColumnCount();
            resultSet.last();
            int recordCount = resultSet.getRow();
            if(columnsCount==0||recordCount==0){
                return null;
            }
            resultSet.beforeFirst();

            while (resultSet.next()){
                String[] cellData= new String[columnsCount];
                for (int i=0; i<columnsCount; i++){
                    cellData[i]=resultSet.getString(i+1);
                }
                queryResults.add(cellData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return queryResults;
    }
}
