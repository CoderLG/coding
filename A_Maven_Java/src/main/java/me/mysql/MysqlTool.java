package me.mysql;

import java.sql.*;

/**
 * author: LG
 * date: 2019-07-04 11:39
 * desc:
 */
public class MysqlTool {
    public static Connection getConnection(){
        String driver="com.mysql.jdbc.Driver";   //获取mysql数据库的驱动类
        String url="jdbc:mysql://192.168.5.1:3306/didnew"; //连接数据库（kucun是数据库名）
        String name="root";//连接mysql的用户名
        String pwd="123456";//连接mysql的密码
        try{
            Class.forName(driver);
            DriverManager.setLoginTimeout(1);
            Connection conn=DriverManager.getConnection(url,name,pwd);//获取连接对象
            return conn;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(ps!=null){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException
    {

        Connection cc=MysqlTool.getConnection();
        System.out.println(cc.isClosed());
     /*   if(!cc.isClosed())
            */

        Statement statement = cc.createStatement();
        String sql = "select * from t_data";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("id")+"");
        }


    }

}
