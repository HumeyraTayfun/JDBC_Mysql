import java.sql.*;

public class JDBC_Testing {

    // sizden JDBC sorgusu yapmaniz istendiginde yapacagınız ilk is:
    // database yöneticisi ile iletişime gecerek Access ınformationları edinmek

    /*
    type: jdbc:mysql
host/ip: 45.87.83.5
port: 3306
database_name: u168183796_qaloantec
username: u168183796_qaloantecuser
password: 0&vG1A/MuWN

url=jdbc:mysql://45.87.83.5/u168183796_qaloantec
username:u168183796_qaloantecuser
password:0&vG1A/MuWN
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1.adim dogru surucuyu yukle

        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.adım: veritabanı ile iletişimi başlat
        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec", "u168183796_qaloantecuser", "0&vG1A/MuWN");


        // 3.adım : sql queryleri oluştur ve execute et

        String query="SELECT * FROM u168183796_qaloantec.users";

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //statement olusturmak için mutlaka bir connection olması gereklı
        // create edilen statement bir query calistirilacaksa atama yapılmadan kullanılabilir.
        //ancak defalarca kullanılmak isteniyorsa atama yapilip kullanılabilir

         // 4.adım: query execute et

        ResultSet resultSet=statement.executeQuery(query);

        // 5.adim: sonuclari isle

        resultSet.next();//iterator'i ilk satira koymus olduk
        System.out.println(resultSet.getString("firstname"));//mehmet

        resultSet.next();//ikinci satırdakı ısmı getirdi
        System.out.println(resultSet.getString("firstname"));//test

        resultSet.next();//ucuncu satıın lastname bilgisi gelir
        System.out.println(resultSet.getString("lastname"));//genc

        System.out.println(resultSet.getString("email"));//gencin e maili geldi

        resultSet.absolute(10);//10.satır geldi
        System.out.println(resultSet.getString("firstname"));

        resultSet.first();//1.satırdakı email geldı   absolute de olur
        System.out.println(resultSet.getString("email"));




    }

}