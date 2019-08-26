package me.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class ThreadPool extends Thread{
  private int threadCount;
  private ComboPooledDataSource dataSource;
  public ThreadPool(ComboPooledDataSource dataSource, int threadCount){
    this.dataSource = dataSource;
    this.threadCount = threadCount;
  }
  @Override
  public void run(){
      Random random = new Random();
      System.out.println("线程"+threadCount+"启动");
      int count = 0;
    Connection connection = null;
    try {
      connection = this.dataSource.getConnection();
      connection.setAutoCommit(false);
      while (count < 2){
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Statement stmt = connection.createStatement();
        System.out.println("线程"+threadCount+"第"+count+"次插入数据");
        stmt.execute("insert into test(name,pas) values('aaa','bbb')");
        stmt.close();
        count++;
      }
      if(threadCount==2){
        connection.commit();
      }
      else{
        connection.rollback();
      }

      connection.setAutoCommit(true);
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if(connection != null){
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }


  }
  public static void main(String[] args) {
    ComboPooledDataSource ds = new ComboPooledDataSource();

    try {
      ds.setJdbcUrl("jdbc:postgresql://192.168.46.21:5432/my_data");
      ds.setDriverClass("org.postgresql.Driver");
      ds.setUser("postgres");
      ds.setPassword("199771");
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 3; i++) {
      ThreadPool dbThread = new ThreadPool(ds,i);
      dbThread.start();
    }

  }


}
