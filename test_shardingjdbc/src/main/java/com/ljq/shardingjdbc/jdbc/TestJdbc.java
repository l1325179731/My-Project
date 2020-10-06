package com.ljq.shardingjdbc.jdbc;

import com.ljq.shardingjdbc.entity.User;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String user="root";
        String password="adminadmin";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test2",user,password);
        Statement statement = con.createStatement();
        String url="select * from user";
        ResultSet resultSet = statement.executeQuery(url);
        while(resultSet.next()){
            User u=User.builder().id(resultSet.getInt(1)).name(resultSet.getNString(2)).build();
            System.out.println(u);
        }
    }
}
