package t3.yaopin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class 药品信息管理 extends JPanel implements ActionListener {
    private JButton 添加药品, 药品列表, 查询药品,删除药品,修改药品;
    private JTextField 药品批次号;
    //private JButton 确定,取消;
    // private JTextField 药品名称,批次号,库存,进货渠道,生产日期,保质期;
    private JPanel p1, p2, p3, p4;
    private JScrollPane jsp1;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private int message = 0;
    String sp;


    public 药品信息管理() {
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel();
        p1.add(p2, "North");
        p2.setLayout(new GridLayout(1, 5, 30, 0));
        添加药品 = new JButton("添加药品");
        添加药品.addActionListener(this);
        p2.add(添加药品);
        药品列表 = new JButton("药品列表");
        药品列表.addActionListener(this);
        p2.add(药品列表);
        p2.add(new JLabel("药品批次号"));
        药品批次号 = new JTextField();
        p2.add(药品批次号);
        查询药品 = new JButton("查询药品");
        查询药品.addActionListener(this);
        p2.add(查询药品);
        删除药品 = new JButton("删除药品");
        删除药品.addActionListener(this);
        p2.add(删除药品);
        修改药品 = new JButton("修改药品");
        修改药品.addActionListener(this);
        p2.add(修改药品);

        p3 = new JPanel();
        p1.add(p3, "Center");
          p3.add(new 药品列表());
        this.add(p1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8", "root", "admin");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from yaopin");
            while (rs.next()) {
                String st1 = rs.getString("id");
                String st2 = 药品批次号.getText();
                sp=st2;
                if (st1.equals(st2)) {
                    message = 1;
                    String s1[] = {"名称", "药品批次号", "库存", "进货渠道", "保质期", "生产日期"};
                    String st4 = rs.getString("id");

                    Object ob[][] = new Object[1][6];
                    ob[0][0] = st4;
                    ob[0][1] = rs.getString("name");
                    ob[0][2] = rs.getString("num");
                    ob[0][3] = rs.getString("jhqd");
                    ob[0][4] = rs.getString("bzq");
                    ob[0][5] = rs.getString("scrq");
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

        if (e.getSource() == 添加药品) {
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 添加药品(0,sp));
            p3.setVisible(true);
        }
        if (e.getSource() == 删除药品) {
            p3.setVisible(false);
            p3.removeAll();


            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8", "root", "admin");
                stmt = con.createStatement();

                String sql="DELETE FROM yaopin WHERE id = '"+药品批次号.getText()+"'";
                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
                JOptionPane.showMessageDialog(this, "删除成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                p3.add(new 药品列表());
                p3.setVisible(true);
            }catch (SQLException | ClassNotFoundException ex){
                ex.printStackTrace();
            }


        }
        if (e.getSource() == 修改药品) {
            p3.setVisible(false);
            p3.removeAll();

            p3.add(new 添加药品(1,sp));
            p3.setVisible(true);
        }



        if (e.getSource() == 药品列表) {
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 药品列表());
            p3.setVisible(true);
        }
        if (e.getSource() == 查询药品) {
            if (message == 0) {
                JOptionPane.showMessageDialog(this, "该药品不存在！", "系统提示", JOptionPane.WARNING_MESSAGE);
            } else {
                p3.setVisible(false);
                p3.removeAll();
                p3.add(p4);
                p3.setVisible(true);
            }
        }
    }
}


