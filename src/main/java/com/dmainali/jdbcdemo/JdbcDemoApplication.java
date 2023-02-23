package com.dmainali.jdbcdemo;

import com.dmainali.jdbcdemo.utils.DbConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class JdbcDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(JdbcDemoApplication.class, args);

		Connection con = DbConnection.getConnection();
		if (con != null) {
			System.out.println("Connection successful !!!");
		}
	}

}
