package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.testng.Assert;
import utilities.ConfigReader;

import java.sql.*;

import static org.testng.Assert.assertEquals;

public class StepDefinition {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String query;

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

		assertEquals(actualData,expectedData);

		System.out.println(" Actual Data = "+ actualData);
	}


}
