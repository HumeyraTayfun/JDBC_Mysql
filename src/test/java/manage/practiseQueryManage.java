package manage;

import com.github.javafaker.Faker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class practiseQueryManage {

    private String preparedQuery01="select user_id  from deposits where amount between ? and ?;";
    private String preparedQuery02="select remember_token from admins where email=?";
    private String preparedQuery3=" insert into admin_password_resets (id,email,token,status,created_at) values (?,?,?,?,?);";
    private String preparedQuery4=" select support_ticket_id from support_message where message=?;";





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
}
