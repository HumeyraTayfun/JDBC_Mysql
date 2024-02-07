
package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import utilities.JDBCReusableMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinition {

    ResultSet resultSet;
    PreparedStatement preparedStatement;
    String query;
    int rowCount;
    QueryManage queryManage = new QueryManage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        JDBCReusableMethods.getConnection();
    }
    @Given("Query01 hazirlanir ve execute edilir.")
    public void query01_hazirlanir_ve_execute_edilir() throws SQLException {

        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet01 sonuclari islenir.")
    public void result_set01_sonuclari_islenir() throws SQLException {

        resultSet.next();
        int actualUserID =resultSet.getInt("user_id");
        int expectedUserID = 1;

        assertEquals(expectedUserID,actualUserID);

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();
    }

    // --------------QUERY02--------------
    @Given("Query02 hazirlanir ve execute edilir.")
    public void query02_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet02 sonuclari islenir.")
    public void result_set02_sonuclari_islenir() throws SQLException {

        List<String> isimler = new ArrayList<>();
        while(resultSet.next()) {
            String isim = resultSet.getString("name");
            isimler.add(isim);
        }

        List<String> expectedName = new ArrayList<>();
        expectedName.add("5 Minutes");
        expectedName.add("10 Minutes");

        for(int i = 0; i < isimler.size(); i++){
            assertEquals(expectedName.get(i),isimler.get(i));
            System.out.println(i +". index dogrulandi");
        }

    }

    @Given("Query03 hazirlanir ve execute edilir.")
    public void query03_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery3();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet03 sonuclari islenir.")
    public void result_set03_sonuclari_islenir() throws SQLException {
       String expectedName="Mehmet Genç";
       String actualName=resultSet.getString("firstname")+ " " + resultSet.getString("lastname");
       assertEquals(expectedName,actualName);
    }

    @Given("Query04 hazirlanir ve execute edilir.")
    public void query04_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery4();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet04 sonuclari islenir.")
    public void result_set04_sonuclari_islenir() throws SQLException {
        while (resultSet.next()){
            String kullanici_id = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("kullanici_id" + kullanici_id);
            System.out.println("Browser & OS" + kullanici_id);
        }

    }


}
