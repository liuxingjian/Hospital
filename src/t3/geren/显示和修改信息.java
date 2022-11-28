package t3.geren;

import t3.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

  public class 显示和修改信息 extends JPanel implements ActionListener {
      private JLabel jl1, jl2,jp3;
      private JLabel jl11 = new JLabel("账号：");
      private JLabel jl22 = new JLabel("昵称：");
      private JTextField jt1, jt2;
      private JButton jb, jb2;
      private String[] ob;
      private JPanel p1;
      private JPasswordField jp;
      String account;

      public 显示和修改信息(String account) {
          this.account=account;
          JPanel p1 = new JPanel();
          Connection con;
          Statement stmt;
          ResultSet rs;
          try {
              Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException f) {
              System.out.println("SQLException:" + f.getLocalizedMessage());
          }
          try {
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8", "root", "admin");
              stmt = con.createStatement();
              rs = stmt.executeQuery("select * from geren where account='"+account+"'");
              rs.beforeFirst();
              rs.next();

              ob = new String[3];
              ob[0] = rs.getString("account");

              ob[1] = rs.getString("name");
              ob[2]=rs.getString("password");
              jl1 = new JLabel(ob[0]);
              jl2 = new JLabel(ob[1]);
              System.out.println(ob[1] + "  " + ob[1]);

              jl11.setFont(new Font("宋体", 1, 30));
              jl11.setForeground(Color.RED);


              jl22.setFont(new Font("宋体", 1, 30));
              jl22.setForeground(Color.RED);
              jl1.setFont(new Font("宋体", 1, 30));
              jl1.setForeground(Color.RED);
              jl2.setFont(new Font("宋体", 1, 30));
              jl2.setForeground(Color.RED);

              jb = new JButton("修改信息");
              jb.addActionListener(this);
              jb2 = new JButton("确定");
              jb2.addActionListener(this);
              Image icon = new ImageIcon("D:\\迅雷云盘\\实训图片\\2021.3\\001.png").getImage();
              // p3=new JPanel((LayoutManager) icon);
              p1=new BackgroundPanel(icon);
              p1.setLayout(new FlowLayout(1,150,200));

             // p1 = new JPanel(new FlowLayout(200, 150, 100));
              p1.setSize(100, 10);

              this.setLayout(new BorderLayout());
              this.add(p1, BorderLayout.CENTER);
              p1.add(jl11);
              p1.add(jl1);
              p1.add(jl22);
              p1.add(jl2);
              p1.add(jb);



              this.setVisible(true);
              con.close();
          } catch (SQLException ex) {
              ex.printStackTrace();
          }
      }

      public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand() == "修改信息") {
              this.setVisible(false);
              this.removeAll();
              Image icon = new ImageIcon("D:\\迅雷云盘\\实训图片\\2021.3\\001.png").getImage();
              p1=new BackgroundPanel(icon);
              p1.setLayout(new FlowLayout(1,50,280));
              //p1 = new JPanel(new FlowLayout(10, 50, 280));
              p1.add(jl11);
              jt1 = new JTextField();
              jt1.setPreferredSize(new Dimension(120, 30));
              p1.add(jt1);
              p1.add(jl22);
              jt2 = new JTextField();
              jt2.setPreferredSize(new Dimension(120, 30));



              p1.add(jt2);
              jp3=new JLabel("密码：");
              jp3.setFont(new Font("宋体", 1, 30));
              jp3.setForeground(Color.RED);
              p1.add(jp3);
              jp=new JPasswordField();
              jp.setPreferredSize(new Dimension(120,30));
              p1.add(jp);
              p1.add(jb2);
              jb2.setPreferredSize(new Dimension(90, 30));
              this.add(p1);

              this.setVisible(true);

          }

          if (e.getActionCommand() == "确定") {
              Connection con;
              Statement stmt;
              boolean rs;
              try {
                  Class.forName("com.mysql.jdbc.Driver");
              } catch (ClassNotFoundException f) {
                  System.out.println("SQLException:" + f.getLocalizedMessage());
              }
              try {
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8", "root", "admin");

                  if(jp.getText().equals(ob[2]))
                  {
                      stmt = con.createStatement(1005, 1008);
                      rs = stmt.execute("update geren set account = '" + jt1.getText() + "' , name = '" + jt2.getText() + " ' where account = '" + ob[0]+"'" );
                      JOptionPane.showMessageDialog(this, "修改成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                      account=jt1.getText();
                      this.setVisible(false);
                      this.removeAll();
                      this.add( new 显示和修改信息(account));

                      this.setVisible(true);
                      con.close();
                  }
                  else{
                      JOptionPane.showMessageDialog(this, "密码错误！", "系统提示", JOptionPane.OK_OPTION);
                  }





              } catch (SQLException ex) {
                  ex.printStackTrace();
              }
          }
      }
  }
