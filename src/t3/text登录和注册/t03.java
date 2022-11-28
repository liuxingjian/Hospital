package t3.text登录和注册;

/*
处理用户登录
*/

import java.sql.*;


class Login {

    Admin admin;

    void setAdmin(Admin admin) {
        this.admin=admin;
        //System.out.println(this.admin.getPassword()+"   " + this.admin.getID());
    }
    /*
     * JudgeAdmin()方法
     * 判断Admin的ID和密码是否正确，如果正确，显示登录成功
     * 如果错误，弹出一个窗口，显示账号或密码错误
     */
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/yiyuan?&useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "admin";



    public boolean login(Admin admin) throws ClassNotFoundException, SQLException {
        String sql="select * from geren where account=? and password=?";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);    
                               
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, admin.getID());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        if(rs.next()) {
            ans = 1;
        }
        rs.close();
        ps.close();
        conn.close();
        if(ans == 1) {
            return true;
        }
        else return false;
    }
    String JudgeAdmin() {

        try {
            if(login(this.admin)) {
                System.out.println("登录成功");

                return admin.getID();
            }else {
                return "0";
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("!!!!!!!!!");
        }
        return "0";

    }
}

