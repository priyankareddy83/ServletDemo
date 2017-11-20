package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Emp;

public class EmpDAO {
	public static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "whishworks_123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public static int save(Emp e) {
		System.out.println(e);
		int status = 0;
		try {
			Connection connection = EmpDAO.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("insert into user1(id,username,password,salary) values (?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());

			ps.setString(4, e.getSalary());

			status = ps.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Emp e) {
		int status = 0;
		try {
			Connection connection = EmpDAO.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("update user1 set id=?, username=?,password=?,salary=? ");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getSalary());
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection connection = EmpDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from  user1 where  id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static Emp getEmployeeById(int id) {
		Emp e = new Emp();
		try {
			Connection connection = EmpDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user1 where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setSalary(rs.getString(4));
			}
			connection.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return e;
	}

	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			Connection connection = EmpDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setSalary(rs.getString(4));
				list.add(e);
			}
			connection.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return list;

	}
}
