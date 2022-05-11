import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {

        Properties ps = new Properties();
        ps.load(new FileReader("2022-5-11/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(ps);
        Connection conn = dataSource.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from student");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println((rs.getString("sname") + "\t\t" + rs.getString("sage")));
        }
        conn.close();


    }
}
