package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.JDBCReusableMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StepDefinition {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	PreparedStatement preparedStatement;
	String query;
	int intResult;

	QueryManage queryManage = new QueryManage();

	@Given("Database baglantisi kurulur.")
	public void database_baglantisi_kurulur() throws SQLException {
/*
	String URL= "jdbc:mysql://195.35.59.63/u201212290_loantec";
	String USERNAME= "u201212290_loantecuser";
	String PASSWORD="HPo?+7r$";
*/
		connection = DriverManager.getConnection(ConfigReader.getProperty("URL"),
				ConfigReader.getProperty("USERNAME"),
				ConfigReader.getProperty("PASSWORD"));
	}

	@Given("Database baglantisi kapatilir.")
	public void database_baglantisi_kapatilir() throws SQLException {

		resultSet.close();
		statement.close();
		connection.close();
	}

	@Given("SQL Query01 hazirlanir ve calistirilir.")
	public void sql_query01_hazirlanir_ve_calistirilir() throws SQLException {
		query = queryManage.getQuery01();

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(query);
	}

	@Given("SQL Query01 sonuclari test edilir.")
	public void sql_query01_sonuclari_test_edilir() throws SQLException {
		int expectedData = 1;

		resultSet.next();
		int actualData = resultSet.getInt(1);

		assertEquals(actualData, expectedData);

		System.out.println(" Actual Data = " + actualData);
	}


	// SQL QUERY02


	@Given("SQL Query02 hazirlanir ve calistirilir.")
	public void sql_query02_hazirlanir_ve_calistirilir() throws SQLException {

		query = queryManage.getQuery02();

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(query);

	}

	@Given("SQL Query02 sonuclari test edilir.")
	public void sql_query02_sonuclari_test_edilir() throws SQLException {

		// 5 Minutes
		// 10 Minutes

		List<String> expectedResultList = new ArrayList<>();
		expectedResultList.add("5 Minutes");
		expectedResultList.add("10 Minutes");

		List<String> actualResultList = new ArrayList<>();

		while (resultSet.next()) {

			String name = resultSet.getString("name");
			actualResultList.add(name);

		}

		for (int i = 0; i < actualResultList.size(); i++) {
			assertEquals(actualResultList.get(i), expectedResultList.get(i));
			System.out.println(i + ". index dogrulandi.");
		}

	}

// UPDATE QUERY 01

	@Given("UpdateQuery01 hazirlanir ve calistirilir.")
	public void update_query01_hazirlanir_ve_calistirilir() throws SQLException {

	    query = queryManage.getPreparedUpdate01();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

		preparedStatement.setString(1, "12211221");
		preparedStatement.setString(2, "%e");

		  intResult = preparedStatement.executeUpdate();

	}
	@Given("UpdateQuery01 sonuclari test edilir.")
	public void update_query01_sonuclari_test_edilir() {

	int expectedResult = 1;
	assertEquals(intResult,expectedResult);

	}




}

