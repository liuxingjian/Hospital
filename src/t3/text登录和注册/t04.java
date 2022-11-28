package t3.text登录和注册;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/*
 * 管理员注册界面
 *
 */
class AdminRegister extends JFrame{
    AdminRegister () {
        init();
    }
    void init() {
        JFrame frame = new JFrame("注册管理员账号");
        frame.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\迅雷云盘\\实训图片\\zc1.gif");
        JLabel jl=new JLabel(icon);
        jl.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        frame.setBounds(300,100,icon.getIconWidth(),icon.getIconHeight()+30);
        JPanel jp=new JPanel();
        jp=(JPanel)frame.getContentPane();
        jp.setOpaque(false);
        frame.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE)   );

        JLabel nameStr = new JLabel("用户名:");
        nameStr.setBounds(250, 150, 100, 25);
        frame.add(nameStr);

        JLabel IDStr = new JLabel("账号:");
        IDStr.setBounds(250, 200, 100, 25);
        frame.add(IDStr);

        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.add(passwordStr);

        JLabel confrimStr = new JLabel("确认密码:");
        confrimStr.setBounds(250, 300, 100, 30);
        frame.add(confrimStr);

        JTextField userName = new JTextField();
        userName.setBounds(320, 150, 150, 25);
        frame.add(userName);

        JTextField userID = new JTextField();
        userID.setBounds(320, 200, 150, 25);
        frame.add(userID);

        JPasswordField password = new JPasswordField();
        password.setBounds(320, 250, 150, 25);
        frame.add(password);

        JPasswordField confrimPassword = new JPasswordField();
        confrimPassword.setBounds(320, 300, 150, 25);
        frame.add(confrimPassword);

        JButton buttonregister = new JButton("注册");
        buttonregister.setBounds(350, 350, 70, 25);
        frame.add(buttonregister);



      //  frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //为注册按钮增加监听器
        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userName.getText();
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                String confrimpasswd = new String (confrimPassword.getPassword());

                //创建Register类
                Register register = new Register();
                register.setID(ID);
                register.setName(name);
                register.setPassword(passwd);
                register.setconfirmpasswd(confrimpasswd);

                //如果注册成功，返回登录界面
                try {
                    if(register.JudgeRegister()) {

                        frame.setVisible(false);
                        Login_Register login_register = new Login_Register();
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    //e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        });
    }
}


