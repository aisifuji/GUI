package com.etc._06Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class UsersDao {
	private JDBCUtils util = new JDBCUtils();
	private int num = 10;

	public UsersDao() {
		util.getConnection();

	}

	public Connection UsersDao() {
		return util.getConnection();

	}

	// 添加
	public boolean addUsers(User user) throws Exception {
		String sql = "INSERT t_users(name,password,sex,birthday,hobby)VALUE(?,?,?,?,?)";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getSex());
		params.add(user.getBirthday());
		params.add(user.getHobby());
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	}

	// 查询一个
	public User findOne(User user) throws Exception {
		String sql = "SELECT name,password,sex,birthday,hobby FROM t_users WHERE name=? AND password=?";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		util.releaseConn();
		return util.findSimpleRefResult(sql, params, User.class);

	}

	// 改数据

	 public boolean changeone(User user) throws Exception{
	 String sql="UPDATE t_users SET name=?,password=?,sex=?,birthday=?,hobby=? WHERE id=?";
	 ArrayList<Object> params = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getSex());
		params.add(user.getBirthday());
		params.add(user.getHobby());
		
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	
	
	
	
	 }
	// 显示全部数据
	public Object[][] showAll() throws Exception {
		String sql = "SELECT id,name,sex,hobby FROM t_users ";
		Object[][] user = new Object[num][4];
		Statement statement = this.UsersDao().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		int i = 0, j = 0, k = 0, l = 0;
		while (resultSet.next()) {

			user[j++][0] = resultSet.getInt("id");

			user[i++][1] = resultSet.getString("name");

			user[k++][2] = resultSet.getString("sex");

			user[l++][3] = resultSet.getString("hobby");
			// System.out.println(user);
		}
		return user;

	}

	// 模糊查询
	public List tofindone(String str1, String str2) throws Exception {
		String sql = "SELECT name,sex,birthday,hobby FROM t_users WHERE name LIKE ? OR sex=?";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(0, "%" + str1 + "%");
		params.add(1, str2);
		List<User> list = util.findMoreRefResult(sql, params, User.class);
		util.releaseConn();
		return list;

	}
//	//查询全部
//	
//	public void showall(){
//		String sql = "SELECT id,name,sex,hobby FROM t_users ";
//		
//		
//	}
	//删除
	public boolean deleteUser(long id) throws Exception{
		String sql="DELETE FROM t_users WHERE id=?";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(id);
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
		
		
	}
	

}
