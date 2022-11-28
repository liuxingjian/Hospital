package t3.yisheng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class 添加医生<重设> extends JPanel implements ActionListener {
    private JButton 提交;
    private JTextField id,name,sex,dh,bm,jtdz;


    private String st1,st2,st3;
    public 添加医生(){
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p1.add(p2,"North");
        JLabel tishi=new JLabel("请小心填写");
        p2.add(tishi,JLabel.CENTER);
        tishi.setFont(new Font("宋体",1,30));
        tishi.setForeground(Color.RED);
        JPanel p3=new JPanel();
        p1.add(p3,"South");
        提交=new JButton("提交");
        p3.add(提交);
        提交.addActionListener(this);
        JPanel p4=new JPanel(new GridLayout(8,2));
        p1.add(p4,"Center");
        p4.add(new JLabel("身份证号*"));
        id=new JTextField();
        p4.add(id);
        p4.add(new JLabel("姓名*"));
        name=new JTextField();
        p4.add(name);

        p4.add(new JLabel("性别"));
        sex=new JTextField();
        p4.add(sex);

        p4.add(new JLabel("电话"));
        dh=new JTextField();
        p4.add(dh);
        p4.add(new JLabel("部门"));
        bm=new JTextField();
        p4.add(bm);
        p4.add(new JLabel("家庭地址"));
        jtdz=new JTextField();
        p4.add(jtdz);


        this.add(p1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==提交){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException g){
                    System.out.println("SQLException:"+g.getLocalizedMessage());
                }

                try{
                    Connection con;
                    Statement stmt;
                    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8","root","admin");
                    stmt=con.createStatement();
                    String sql="INSERT INTO yisheng(id,name,sex,dh,bm,jtdz) Values("+"'"+id.getText()+"'"+
                            ","+"'"+ name.getText()+"'"+",'" +sex.getText()+"',"+"'"+dh.getText()+"'"+","+"'"+bm.getText()+"'"+","+"'"+jtdz.getText()+"'"+")";
                    stmt.executeUpdate(sql);
                    stmt.close();
                    con.close();
                    this.setVisible(false);
                    this.removeAll();
                    this.add(new 医生列表());
                    this.setVisible(true);
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }

    }
}