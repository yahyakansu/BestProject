package DDT_JDBC;

import utilities.Config;
import utilities.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTest {
    private static String URL = Config.getProperties("dataBaseUrl");
    private static String DBUserName = Config.getProperties("dataBaseUsername");
    private static String DBPassword = Config.getProperties("dataBasePassword");

    /**
     * CONNECTION TEST
     */
    @org.testng.annotations.Test
    public void connectionTest(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL,DBUserName,DBPassword);
            System.out.println("Database connection is successful");
            if (connection!=null){
                connection.close();
            }
        }catch (Exception e){
            System.err.println("Connection is NOT successful");
            e.printStackTrace();
        }
    }

    /**
     * QUERY TEST
     * @throws SQLException
     */
    @org.testng.annotations.Test
    public void queryTest() throws SQLException {
        Connection connection = DBUtils.getConnection(DBUtils.DbType.MySQl);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select*from company");

        List<String[]> results = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnsCount = metaData.getColumnCount();
        String[] colNames = new String[columnsCount];

        for (int i=0; i<columnsCount; i++){
            colNames[i]=metaData.getColumnName(i+1);
        }

        results.add(colNames);

        while (resultSet.next()){
            String[] rowData=new String[columnsCount];

            for (int i=0; i<columnsCount; i++){
                rowData[i]=resultSet.getString(i+1);
            }
            results.add(rowData);
        }

        for (String[] rowData: results){
            for (String cellData: rowData){
                System.out.print(cellData+"\t\t");
            }
            System.out.println();
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
