Feature: UPDATE QUERY EXECUTION
Background: Database baglantisi kurulumu
  * Database baglantisi kurulur.

  #"users" tablosunda sondan bir önceki harfi e olan "usernamelerin"
  # "mobile" numarasını update ediniz
@PreparedUpdate01
  Scenario: Users tablosunda mobile number update testi.

    * UpdateQuery01 hazirlanir ve calistirilir.
    * UpdateQuery01 sonuclari test edilir.
    * Database baglantisi kapatilir.


  # admin_notifications tablosunda ki "id=?" olan kullanıcının
  # "is_read=0" olan bildirimlerini '1' Olarak Update edip doğrulayınız.
  @PreparedUpdate02
  Scenario: Verilen id numarasi ile is_read bilgisi update etme testi.

    * UpdateQuery02 hazirlanir ve calistirilir.
    * UpdateQuery02 sonuclari test edilir.
    * Database baglantisi kapatilir.



