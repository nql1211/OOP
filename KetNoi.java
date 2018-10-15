/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ooptudien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class KetNoi {
String Database = "";
    String Host = "";
    String Password = "";
    String Username = "";
    Connection conect = null;
    ResultSet result = null;
    Statement statement = null;

public KetNoi(String host,String user,String pass,String db)
{
    this.Username=user;
    this.Password=pass;
    this.Database=db;
    this.Host=host;
}
protected void Kiemtradriver() throws Exception
{
    try
    {
        Class.forName("org.gjt.mm.mysql.Driver");//kiem tra co ton tai driver khong
    }
    catch(java.lang.ClassNotFoundException e)
    {
        throw new Exception("Chưa có Driver, cho Thêm vào libraries");
    }
}
protected Connection getConect() throws Exception
{   //Neu chua tao ket noi thi khoi tao ket noi den MySQL
    if(conect==null)
    {
        Kiemtradriver();
        //tạo url kết nối đến database server
        String url="jdbc:mysql://"+this.Host+":3306/"+this.Database+
            "?userUnicode=true&characterEncoding=utf8";
        System.out.println("Đang kết nối đến server...");
      try
      {
         conect= DriverManager.getConnection(url,this.Username, this.Password);//ket noi db
         System.out.println("Kết nối thành công !");
      }
      catch(java.sql.SQLException e)
      {
          throw new Exception("Không thể kết nối đến server");
      }
    }
    return conect;

}
  protected Statement getStatement() throws Exception {  //ham thuc thi cau lenh Query
      // Neu staement =null hoac da dong thi can khoi tao lai
        //if (statement == null ? true : this.statement.isClosed()) {
            statement = getConect().createStatement();
        //}
        return statement;
    }
  //Ham lay ket qua cua cau lenh Select
  public ResultSet excuteQuery(String query) throws Exception {
        try {
            //thực thi câu lệnh
            result = getStatement().executeQuery(query);
        } catch (Exception e) {
            throw new Exception("Lỗi:" + e.getMessage());
        }
        return result; 
    }
    //Lay gia tri tra ve cua cac cau lenh: insert, update, delete, cerate
    public int excuteUpdate(String query) throws Exception {
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("Lỗi:" + e.getMessage());
        } finally {
            Close(); //đóng kết nối
        }
        return res;
    }
    
       private void Close() throws SQLException{

    //nếu result chưa đóng thì đóng result
        if(result!=null && !result.isClosed())
        {
            result.close();
            result=null;
        }
        // nếu statement chưa đóng thì đóng statement
        if(statement!=null&& !statement.isClosed())
        {
            statement.close();
            statement=null;
        }
        //nếu connection chưa đóng thì đóng connection
        if(conect!=null&& !conect.isClosed())
        {
            conect.close();
            conect=null;
        }
           System.out.println("Server đã đóng");
    }
}
