package t3;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 数据库连接
 */
class Conn {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/yiyuan?&useSSL=false&serverTimezone=UTC";
        Class.forName(driver);
        Connection conn=  DriverManager.getConnection(url,"root","admin");
        System.out.println(!conn.isClosed());
        Statement st= conn.createStatement();//建立一个sql对象，一个sql对象对于一个Statement
        String sql;
        sql="select * from yisheng ";
        ResultSet ret=  st.executeQuery(sql);//接收sql语句
        while (ret.next()){//判读是否有由数据
            int name=ret.getInt("name");

            System.out.println(name);
        }
        conn.close();

    }
}

