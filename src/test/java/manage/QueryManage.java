package manage;

public class QueryManage {

	private String Query01 = "SELECT DISTINCT user_id FROM deposits WHERE amount BETWEEN 200 AND 500;";





	/*************** GETTER *************/

	public String getQuery01() {
		return Query01;
	}
}
