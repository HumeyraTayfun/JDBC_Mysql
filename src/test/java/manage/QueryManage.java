package manage;

public class QueryManage {

    private String query01 = "select user_id from u168183796_qaloantec.deposits where amount between 100 and 500;";
    private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules Limit 2";

    private String query3="SELECT firstname,lastname FROM users WHERE country_code NOT LIKE 'TR' and id=11";

    private String query4="select user_id,group_concat(browser,'- ',os) as browser_os from user_logins group by user_id";
    private String updateQuery5="update users set mobile='123456789' where username like '%e_'";

    //------------ GETTER------------------


    public String getQuery01() {
        return query01;
    }

    public String getQuery02() {
        return query02;
    }

    public String getQuery3() {
        return query3;
    }

    public String getQuery4() {
        return query4;
    }

    public String getUpdateQuery5() {
        return updateQuery5;
    }
}

