package t3.huanzhe.看病记录管理;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class 看病记录列表 extends JPanel implements ActionListener {
    private JTable m_view;
    private JPanel p3;
    public 看病记录列表(int kk,String id){
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
            if(kk==0){
                rs=stmt.executeQuery("select * from kanbing");
            }else {
                rs=stmt.executeQuery("select * from kanbing where h_id='"+id+"'");
            }

            rs.last();
            int k=rs.getRow();
            if(k==0){
                JOptionPane.showMessageDialog(this,"您查询的表为空表！","系统提示",JOptionPane.WARNING_MESSAGE);
            }
            rs.beforeFirst();
            String ob[][]=new String[k][7];
            for(int i=0;i<k&&rs.next();i++){
                ob[i][0]=rs.getString("h_id");
                ob[i][1]=rs.getString("y_id");
                ob[i][2]=rs.getString("ypm");
                ob[i][3]=rs.getString("num");
                ob[i][4]=rs.getString("feiyong");
                ob[i][5]=rs.getString("bk");
            }
            String s[]={"身份证号", "药品号","药品名","购买数量","费用", "病况"};
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
