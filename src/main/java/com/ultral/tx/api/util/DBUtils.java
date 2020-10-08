package com.ultral.tx.api.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream in = DBUtils.class.getClassLoader()
                    .getResourceAsStream("jdbc.properties");
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void closeResource(Connection connection,
                              Statement statement,
                              ResultSet resultSet){
        if(null != resultSet){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(null != statement){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(null == connection){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Connection connection = DBUtils.getConnection();
        System.out.println(connection);

        PreparedStatement statement
                = connection.prepareStatement("select * from dev_question where questionid = ?");
        statement.setInt(1,12);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            String title = resultSet.getString("title");
            System.out.println(title);
        }

        DBUtils.closeResource(connection,statement,resultSet);
    }
}
