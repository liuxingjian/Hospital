package t3.huanzhe.看病记录管理;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class 看病信息管理 extends JPanel implements ActionListener {
    private JButton 添加看病记录, 看病记录列表, 查询看病记录,删除看病记录,修改看病记录;
    private JTextField 身份证号;
    //private JButton 确定,取消;
    // private JTextField 药品名称,批次号,库存,进货渠道,生产日期,保质期;
    private JPanel p1, p2, p3, p4;
    private JScrollPane jsp1;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private int message = 0;
    private String s;

    public 看病信息管理() {
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel();
        p1.add(p2, "North");
        p2.setLayout(new GridLayout(1, 5, 30, 0));
        添加看病记录 = new JButton("添加看病记录");
        添加看病记录.addActionListener(this);
        p2.add(添加看病记录);
        看病记录列表 = new JButton("看病记录列表");
        看病记录列表.addActionListener(this);
        p2.add(看病记录列表);
        p2.add(new JLabel("身份证号"));
        身份证号 = new JTextField();
        p2.add(身份证号);
        查询看病记录 = new JButton("查询看病记录");
        查询看病记录.addActionListener(this);
        p2.add(查询看病记录);
        删除看病记录 = new JButton("删除看病记录");
        删除看病记录.addActionListener(this);
        p2.add(删除看病记录);
        修改看病记录 = new JButton("修改看病记录");
        修改看病记录.addActionListener(this);
        p2.add(修改看病记录);

        p3 = new JPanel();
        p1.add(p3, "Center");
        p3.add(new 看病记录列表(0,null));
        this.add(p1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8", "root", "admin");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from kanbing");
            while (rs.next()) {
                String st1 = rs.getString("h_id");
                String st2 = 身份证号.getText();
                if (st2.equals(st1)) {
                    message = 1;
                    Object ob[][] = new Object[1][6];
                    String s1[] = {"身份证号", "药品号","药品名","购买数量","费用", "病况"};
                    String st4 = rs.getString("h_id");
                    s=st4;
                    ob[0][0] = st4;
                    ob[0][1] = rs.getString("y_id");
                    ob[0][2] = rs.getString("ypm");
                    ob[0][3] = rs.getString("num");
                    ob[0][4] = rs.getString("feiyong");
                    ob[0][5] = rs.getString("bk");
                    JTable table1 = new JTable(ob, s1);
                    table1.setSize(500, 500);
                    jsp1 = new JScrollPane(table1);
                    jsp1.setPreferredSize(new Dimension(table1.getWidth(), table1.getHeight()));
                    p4=new JPanel();
                    p4.add(jsp1, "Center");

//                    p3.setVisible(false);
//                    p3.removeAll();
//                   // p3.add(new 药品列表());
//                    p3.setVisible(true);
                    break;
                }
            }
            stmt.close();
            con.close();
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (e.getSource() == 添加看病记录) {
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 添加看病记录(0,s));
            p3.setVisible(true);
        }
        if (e.getSource() == 删除看病记录) {
            p3.setVisible(false);
            p3.removeAll();


            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8", "root", "admin");
                stmt = con.createStatement();

                String sql="DELETE FROM kanbing WHERE h_id = "+身份证号.getText();
                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
                JOptionPane.showMessageDialog(this, "删除成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                p3.add(new 看病记录列表(0,null));
                p3.setVisible(true);
            }catch (SQLException | ClassNotFoundException ex){
                ex.printStackTrace();
            }


        }
        if (e.getSource() == 修改看病记录) {
            p3.setVisible(false);
            p3.removeAll();

            p3.add(new 添加看病记录(1,s));
            p3.setVisible(true);
        }



        if (e.getSource() == 看病记录列表) {
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 看病记录列表(0,null));
            p3.setVisible(true);
        }
        if (e.getSource() == 查询看病记录) {
            if (message == 0) {
                JOptionPane.showMessageDialog(this, "该患者不存在！", "系统提示", JOptionPane.WARNING_MESSAGE);
            } else {
                p3.setVisible(false);
                p3.removeAll();
                p3.add(new 看病记录列表(1,身份证号.getText()));
                p3.setVisible(true);
            }
        }
    }
}



