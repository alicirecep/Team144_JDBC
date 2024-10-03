package manage;

public class QueryManage {

	private String Query01 = "SELECT DISTINCT user_id FROM deposits WHERE amount BETWEEN 200 AND 500;";
	private String Query02 = "SELECT name FROM  cron_schedules LIMIT 2;";
	private String UpdateQuery01 = "UPDATE users SET mobile = '89898998' WHERE role_name LIKE '%e';";
	private String PreparedUpdate01 = "UPDATE users SET mobile = ? WHERE username LIKE ?;";
	private String PreparedUpdate02 = "UPDATE admin_notifications SET is_read = ? WHERE id = ?;";


	/*************** GETTER *************/

	public String getQuery01() {
		return Query01;
	}

	public String getQuery02() {
		return Query02;
	}

	public String getPreparedUpdate02() {
		return PreparedUpdate02;
	}

	public String getPreparedUpdate01() {
		return PreparedUpdate01;


	}
}
