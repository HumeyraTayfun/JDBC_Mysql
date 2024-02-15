package manage;

import com.github.javafaker.Faker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class practiseQueryManage {

    private String preparedQuery01="select user_id  from deposits where amount between ? and ?;";
    private String preparedQuery02="select remember_token from admins where email=?";
    private String preparedQuery3=" insert into admin_password_resets (id,email,token,status,created_at) values (?,?,?,?,?);";
    private String preparedQuery4=" select support_ticket_id from support_message where message=?;";
    private String preparedQuery5="SELECT subject from support_tickets WHERE ticket LIKE ?;";

    private String preparedInsert6="insert into loans (id,loan_number,user_id,plan_id) values (?,?,?,?)";
    private String praparedDelete6="delete from loans where loan_number=?;";
    private String preparedQuery7="select * from admin_notifications where user_id=? and is_read=?;";





    public String getPreparedQuery01() {
        return preparedQuery01;
    }

    public String getPreparedQuery02() {
        return preparedQuery02;
    }

    public String getPreparedQuery3() {
        return preparedQuery3;
    }

    public String getPreparedQuery4() {
        return preparedQuery4;
    }

    public String getPreparedQuery5() {
        return preparedQuery5;
    }

    public String getPreparedInsert6() {
        return preparedInsert6;
    }

    public String getPraparedDelete6() {
        return praparedDelete6;
    }

    public String getPreparedQuery7() {
        return preparedQuery7;
    }
}
