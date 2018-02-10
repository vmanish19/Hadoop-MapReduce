
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Maxtemperature9293 {

	Connection myConnection;

	public static void main(String args[]) {
		int count = 0;
		int max = 0;
		int max1 = 0;

		String year = null;
		String y90 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/temperature?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "pass");
 			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from 9293sample");
			while (rs.next()) {
				count++;
				String Max = rs.getString(27);
				year = rs.getString(4);
				if (Max.substring(0, 1).equals("+")) {
					Max = Max.substring(1);
					y90 = year.substring(0, 4);
					int temp = Integer.parseInt(Max);
					if (y90.equals("1992")) {
						if (temp > max && temp != 9999)
							max = temp;
					}
					if (y90.equals("1993")) {
						if (temp > max1 && temp != 9999)
							max1 = temp;
					}
				}
			}
			con.close();

		} catch (

		Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
 		System.out.println("Max temp in 1992  " + ": " + max);
		System.out.println("Max temp in 1993  " + ": " + max1);

	}

}

//
