package t3.yaopin;

import com.mysql.jdbc.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class 添加药品 extends JPanel implements ActionListener {
    private JButton 提交,修改;
    private JTextField id;
    private JTextField name;
    private JTextField scrq;
    private JTextField bzq;
    private JTextField num;
    private JTextField jhqd;
public String s;



    public 添加药品(int a,String s){
        this.s=s;

        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p1.add(p2,"North");
        JLabel tishi=new JLabel("带*的不能为空");
        p2.add(tishi,JLabel.CENTER);
        tishi.setFont(new Font("宋体",1,30));
        tishi.setForeground(Color.RED);
        JPanel p3=new JPanel();
        p1.add(p3,"South");
        提交=new JButton("提交");
        修改=new JButton("修改");
        if(a==0){
            p3.add(提交);
        }else {
            p3.add(修改);
        }

        提交.addActionListener(this);
        修改.addActionListener(this);
        JPanel p4=new JPanel(new GridLayout(8,2));
        p1.add(p4,"Center");
        if(a==0){
            p4.add(new JLabel("药品号*"));
            id=new JTextField();
            p4.add(id);
        }

        p4.add(new JLabel("药品名称*"));
        name=new JTextField();
        p4.add(name);

        p4.add(new JLabel("生产日期"));
        scrq=new JTextField();
        p4.add(scrq);

        p4.add(new JLabel("保质期"));
        bzq=new JTextField();
        p4.add(bzq);
        p4.add(new JLabel("库存"));
        num=new JTextField();
        p4.add(num);
        p4.add(new JLabel("进货渠道"));
        jhqd=new JTextField();
        p4.add(jhqd);



        this.add(p1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==提交||e.getSource()==修改){
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch(ClassNotFoundException g){
                System.out.println("SQLException:"+g.getLocalizedMessage());
            }

            try{
                Connection con;
                Statement stmt;
                con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8","root","admin");
                stmt=con.createStatement();
                String sql;
                if(e.getSource()==提交){
                     sql="INSERT INTO yaopin(id,name,num,jhqd,scrq,bzq) Values("+"'"+id.getText()+"'"+
                            ","+"'"+ name.getText()+"'"+"," +Integer.valueOf(num.getText())+","+"'"+jhqd.getText()+"'"+","+"'"+scrq.getText()+"'"+","+Integer.valueOf( bzq.getText())+")";
                    stmt.executeUpdate(sql);
                    stmt.close();
                    con.close();
                     JOptionPane.showMessageDialog(this, "添加成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    if(s==null){
                        JOptionPane.showMessageDialog(this, "输入为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        sql = "update yaopin set name= '"+ name.getText()+"', bzq="+Integer.valueOf(bzq.getText())+
                                ", num="+Integer.valueOf(num.getText())+" ,jhqd='"+ jhqd.getText()+"',scrq='"+scrq.getText()+"' where id= '"+s+"'";
                        stmt.executeUpdate(sql);
                        stmt.close();
                        con.close();
                        System.out.println("hehe"+s);
                        JOptionPane.showMessageDialog(this, "修改成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                    }
                    }



                this.setVisible(false);
                this.removeAll();
                this.add(new 药品列表());
                this.setVisible(true);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(this,"药品已存在,请重试","系统提示",JOptionPane.WARNING_MESSAGE);
               // ex.printStackTrace();
                this.setVisible(false);
                this.removeAll();
                this.add(new 药品列表());
                this.setVisible(true);
            }
        }

    }
}