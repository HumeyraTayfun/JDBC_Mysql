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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    String loanNumber;
    int userId;



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
        query = practiseQueryManage.getPreparedQuery4();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1, "merhaba");
        resultSet = preparedStatement.executeQuery();

    }

    @Given("Preparedquery4 Sonuclar dogrulanir.")
    public void preparedquery4_sonuclar_dogrulanir() throws SQLException {
        resultSet.next();
        int expectedId = 15;
        int actualId = resultSet.getInt("support_ticket_id");
        assertEquals(expectedId, actualId);

    }

    @Given("Preparedquery5 olusturulur ve execute edilir.")
    public void preparedquery5_olusturulur_ve_execute_edilir() throws SQLException {
        query = practiseQueryManage.getPreparedQuery5();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1, "4%");
        resultSet = preparedStatement.executeQuery();
    }

    @Given("Preparedquery5 Sonuclar dogrulanir.")
    public void preparedquery5_sonuclar_dogrulanir() throws SQLException {
        List<String> isimler = new ArrayList<>();
        while (resultSet.next()) {
            String isim = resultSet.getString("subject");
            isimler.add(isim);
        }

        List<String> expectedName = new ArrayList<>();
        expectedName.add("testSubject");
        expectedName.add("Loantech");
        expectedName.add("s");
        expectedName.add("deserunt");
        expectedName.add("asdasd");
        expectedName.add("Test Ticket");
        expectedName.add("Test_attachment");
        expectedName.add("HelloWorld");
        expectedName.add("Ticket666");
        expectedName.add("Blue Test Ticket");
        expectedName.add("AhmetKaya");
        expectedName.add("deneme");
        expectedName.add("Test Ticket1");
        for (int i = 0; i < isimler.size(); i++) {
            assertTrue(expectedName.contains(isimler.get(i)));
        }
    }

    @Given("Loans tablosuna insert query hazirlanir ve calistirilir.")
    public void loans_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {
        query=practiseQueryManage.getPreparedInsert6();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);
        //id,loan_numberstr ,user_id
        id=faker.number().numberBetween(1,9);
        loanNumber=faker.lorem().sentence(1);
        userId=faker.number().numberBetween(7,10);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, loanNumber);
        preparedStatement.setInt(3, userId);
        rowCount = preparedStatement.executeUpdate();
        System.out.println("id: " + id);


        int flag=0;
        if (rowCount > 0) {
            flag++;
        }

        rowCount = 0;
        assertEquals(1, flag);

    }
    @Given("Loans tablosuna insert edilen data silinir.")
    public void loans_tablosuna_insert_edilen_data_silinir() throws SQLException {
        query=practiseQueryManage.getPraparedDelete6();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setString(1,loanNumber);
        rowCount = preparedStatement.executeUpdate();

        System.out.println("silinen loanNumber; "+ loanNumber);

    }

    @Then("Satirin silindigi dogrulanir.")
    public void satirinSilindigiDogrulanir() {
        assertEquals(1, rowCount);

    }
}
