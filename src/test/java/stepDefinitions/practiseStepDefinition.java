package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manage.practiseQueryManage;
import utilities.JDBCReusableMethods;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class practiseStepDefinition {
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    String query;
    int rowCount;
    Faker faker = new Faker();
    practiseQueryManage practiseQueryManage = new practiseQueryManage();
    int id;
    String email;
    String token;

    String created_at;


    @Then("Preparedquery olusturulur ve execute edilir.")
    public void preparedqueryOlusturulurVeExecuteEdilir() throws SQLException {
        query = practiseQueryManage.getPreparedQuery02();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1, "info@loantechexper.com");
        resultSet = preparedStatement.executeQuery();

    }

    @Then("Preparedquery Sonuclar dogrulanir.")
    public void preparedquerySonuclarDogrulanir() throws SQLException {
        resultSet.next();
        String expectedEmail = "1xUgfVUD1Ggx5CVz7mxLvcye8RXRbeFqSktSIkhya321TqDkLOsqhys4pnJv";
        String actualEmail = resultSet.getString("remember_token");
        assertEquals(expectedEmail, actualEmail);


    }

    @Given("Admin password resets tablosuna insert query hazirlanir ve calistirilir.")
    public void admin_password_resets_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {
        query = practiseQueryManage.getPreparedQuery3();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        //id,email,token,status,created_at
        id = faker.number().numberBetween(6, 9);
        email = faker.internet().emailAddress();
        token = faker.lorem().sentence(1);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, token);
        preparedStatement.setInt(4, 1);
        preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
        rowCount = preparedStatement.executeUpdate();
        System.out.println("id: " + id);
    }

    @Given("Preparedquery3 sonuclar dogrulanır.")
    public void preparedquery3_sonuclar_dogrulanır() {
        assertEquals(1, rowCount);

    }

    @Given("Preparedquery4 olusturulur ve execute edilir.")
    public void preparedquery4_olusturulur_ve_execute_edilir() throws SQLException {
        query=practiseQueryManage.getPreparedQuery4();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"merhaba");
        resultSet=preparedStatement.executeQuery();

    }

    @Given("Preparedquery4 Sonuclar dogrulanir.")
    public void preparedquery4_sonuclar_dogrulanir() throws SQLException {
        resultSet.next();
        int expectedId=15;
        int actualId=resultSet.getInt("support_ticket_id");
        assertEquals(expectedId,actualId);

    }
}
