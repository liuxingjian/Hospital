package t3.huanzhe.患者信息管理;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class 患者列表 extends JPanel implements ActionListener {
    private JTable m_view;
    private JPanel p3;
    public 患者列表(){
        JPanel p1=new JPanel(new BorderLayout());
        Connection con;
        Statement stmt;
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException f){
            System.out.println("SQLException:"+f.getLocalizedMessage());
        }
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yiyuan?characterEncoding=utf8","root","admin");
            stmt=con.createStatement(1005,1008);
            rs=stmt.executeQuery("select * from huanzhe");
            rs.last();
            int k=rs.getRow();
            if(k==0){
                JOptionPane.showMessageDialog(this,"您查询的表为空表！","系统提示",JOptionPane.WARNING_MESSAGE);
            }
            rs.beforeFirst();
            String ob[][]=new String[k][7];
            for(int i=0;i<k&&rs.next();i++){
                ob[i][0]=rs.getString("id");
                ob[i][1]=rs.getString("name");
                ob[i][2]=rs.getString("sex");
                ob[i][3]=rs.getString("dh");
                ob[i][4]=rs.getString("age");
                ob[i][5]=rs.getString("jtdz");
            }
            String s[]={"身份证号","姓名","性别","电话","年龄","家庭地址"};
            m_view=new JTable(ob,s);
            m_view.setSize(700,700);
            m_view.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JScrollPane sPane=new JScrollPane(m_view);
            sPane.setPreferredSize(new Dimension(m_view.getWidth()-200,m_view.getHeight()-200));
            p3=new JPanel(new FlowLayout());
            p1.add(p3,"Center");
            JPanel jp=new JPanel();
            jp.setSize(new Dimension(2000,3000));
            p3.add(jp);
            p3.add(sPane);
            this.add(p1);
            this.setVisible(true);
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e){
    }
}
