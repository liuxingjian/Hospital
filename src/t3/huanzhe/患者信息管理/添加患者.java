package t3.huanzhe.患者信息管理;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class 添加患者 extends JPanel implements ActionListener {
    private JButton 提交,修改;
    private JTextField id;
    private JTextField name;
    private JTextField sex;
    private JTextField dh;
    private JTextField age;
    private JTextField jtdz;
    private String s;




    public 添加患者(int a, String s){
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
        p4.add(new JLabel("身份证号*"));
        id=new JTextField();
        p4.add(id);
        p4.add(new JLabel("患者姓名*"));
        name=new JTextField();
        p4.add(name);

        p4.add(new JLabel("性别"));
        sex=new JTextField();
        p4.add(sex);

        p4.add(new JLabel("电话"));
        dh=new JTextField();
        p4.add(dh);
        p4.add(new JLabel("年龄"));
        age=new JTextField();
        p4.add(age);
        p4.add(new JLabel("家庭地址"));
        jtdz=new JTextField();
        p4.add(jtdz);



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
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8","root","admin");
                stmt=con.createStatement();
                String sql;
                if(e.getSource()==提交){
                    sql="INSERT INTO huanzhe(id,name,sex,dh,age,jtdz) Values("+"'"+id.getText()+"'"+
                            ","+"'"+ name.getText()+"'"+",'" +sex.getText()+"',"+"'"+dh.getText()+"'"+","+Integer.valueOf(age.getText())+",'"+jtdz.getText()+"')";
                    JOptionPane.showMessageDialog(this, "添加成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    sql = "update huanzhe set id='"+id.getText()+" ',name= '"+ name.getText()+"', age="+Integer.valueOf(age.getText())+
                            ", sex='"+sex.getText()+"' ,jtdz='"+ jtdz.getText()+"',dh='"+dh.getText()+"' where id= '"+s+"'";

                    JOptionPane.showMessageDialog(this, "修改成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                }

                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
                this.setVisible(false);
                this.removeAll();
                this.add(new 患者列表());
                this.setVisible(true);
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }
}
