package cometc_05;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDao {
	private JDBCUtils util=new JDBCUtils();
	
	
	public UsersDao(){
		 util.getConnection();
		
	}
	public Connection UsersDao(){
		 return  util.getConnection();
		
	}
	
	//添加
	public boolean addUsers(User user) throws Exception{
		String sql="INSERT t_users(name,password,sex,birthday,hobby)VALUE(?,?,?,?,?)";
		ArrayList<Object> params  = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		params.add(user.getSex());
		params.add(user.getBirthday());
		params.add(user.getHobby());
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;	
	}
	//查询一个
	public User findOne(User user) throws Exception{
		String sql="SELECT name,password,sex,birthday,hobby FROM t_users WHERE name=? AND password=?";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		util.releaseConn();
		 return util.findSimpleRefResult(sql, params, User.class);
	
	}
	//改数据
	
//	public boolean changeone(User user){
//		String
//		
//		
//		
//		
//		return false;
//	}
	//显示全部数据
	public Object[][] showAll() throws Exception{
		String sql="SELECT id,name,sex,hobby FROM t_users ";
		Object[][] user=new Object[10][10];
		Statement statement = this.UsersDao().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			
				for(int j=0;j<4;j++){
					user[j][0]=resultSet.getInt("id");
					
				}
				for(int i=0;i<4;i++){
					user[i][1]=resultSet.getString("name");
				}
				for(int k=0;k<4;k++){
					user[k][2]=resultSet.getString("sex");
				}
				for(int l=0;l<4;l++){
					user[l][3]=resultSet.getString("hobby");
				}
			
			
			
			
		}
		return user;
		
		
		
		
		
		
	}
	
	

}
