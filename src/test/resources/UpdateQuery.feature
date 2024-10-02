Feature: UPDATE QUERY EXECUTION
Background: Database baglantisi kurulumu
  * Database baglantisi kurulur.

  #"users" tablosunda sondan bir önceki harfi e olan
  # "usernamelerin" "mobile" numarasını update ediniz
@PreparedUpdate01
  Scenario: Users tablosunda mobile number update testi.

    * UpdateQuery01 hazirlanir ve calistirilir.
    * UpdateQuery01 sonuclari test edilir.
    * Database baglantisi kapatilir.