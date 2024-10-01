Feature: SELECT QUERY EXECUTION

  # Database içindeki "deposits" toblosunda
  # "amount" değeri 200$ ile 500$
  # arasında olan user_id’leri doğrulayınız

@query01
  Scenario: Deposits tablosunda amount degerine gore id sorgulama testi.

    * Database baglantisi kurulur.
    * SQL Query01 hazirlanir ve calistirilir.
    * SQL Query01 sonuclari test edilir.
    * Database baglantisi kapatilir.
