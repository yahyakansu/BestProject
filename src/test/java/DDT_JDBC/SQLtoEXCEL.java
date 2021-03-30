package DDT_JDBC;

import org.testng.annotations.Test;
import utilities.Config;
import utilities.DBUtils;
import utilities.ExcelUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLtoEXCEL {

    /**
     * To convert data from database to the excel file
     * @throws SQLException
     */
    @Test
    public void convertTest() throws SQLException {
        Connection connection=DBUtils.getConnection(DBUtils.DbType.MySQl);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(Config.getProperties("sampleQuery"));

        ExcelUtils.openExcelFile("src/Sample.xlsx","Sheet1");

        //write column names into the excel
        ExcelUtils.setCellValue(0,0,"FIRST_NAME");
        ExcelUtils.setCellValue(0,1,"LAST_NAME");

        //write data from sql into excel
        int currentRow = 1;
        while(resultSet.next()) {
            String countryId = resultSet.getString("first_name");
            String countryName = resultSet.getString("last_name");

            ExcelUtils.setCellValue(currentRow, 0, countryId);
            ExcelUtils.setCellValue(currentRow, 1, countryName);
            currentRow++;
        }

        DBUtils.closeConnection();
    }
}
