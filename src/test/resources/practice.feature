Feature: SELECT QUERY EXECUTE


 Background:Database baglantisi
   * Database baglantisi kurulur.
@humeyra
    Scenario:Database içindeki "admins" tablosunda "email=info@loantechexper.com"  olan datanın
             "remember_token" bilgisini doğrulayınız

      Then Preparedquery olusturulur ve execute edilir.
      Then Preparedquery Sonuclar dogrulanir.
      Then Database baglantisi kapatilir.

   Scenario: Database içindeki "admin_password_resets" tablosuna aynı anda birden fazla veriyi ekleyiniz.
      * Admin password resets tablosuna insert query hazirlanir ve calistirilir.
     * Preparedquery3 sonuclar dogrulanır.
     * Database baglantisi kapatilir.

     Scenario:Database içindeki "Support_messages" tablosunda "message" bilgisi "merhaba"
              olan datanın "support_ticket_id" sini doğrulayınız.

       * Preparedquery4 olusturulur ve execute edilir.
       * Preparedquery4 Sonuclar dogrulanir.
       * Database baglantisi kapatilir.

       Scenario: US07 Database içindeki "support_tickets" tablosunda  "ticket" değeri
                  4 ile başlayan dataların "subject" bilgisini doğrulayınız.


         * Preparedquery5 olusturulur ve execute edilir.
         * Preparedquery5 Sonuclar dogrulanir.
         * Database baglantisi kapatilir.

         Scenario: US09 Database üzerinden "loans" tablosunda "loan_number" girerek istenen datayı siliniz ve
                  silindiğini doğrulayınız.
           Given Loans tablosuna insert query hazirlanir ve calistirilir.
           Then Loans tablosuna insert edilen data silinir.
           Then Satirin silindigi dogrulanir.
           Then Database baglantisi kapatilir.


          Scenario: US11 Database üzerinde "admin_notifications" tablosunda "user id= 1" ve "is_read=0"olan
                     kullanıcı sayılarının adedini doğrulayınız.
            * PreparedQuery7 oluşturulur ve execute edilir.
            * Prepared query7 Sonuclar dogrulanir.
            * Database baglantisi kapatilir.




