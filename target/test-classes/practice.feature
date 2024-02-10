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



