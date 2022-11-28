package t3.huanzhe.看病记录管理;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class 添加看病记录 extends JPanel implements ActionListener {
    private JButton 提交,修改;
    private JTextField h_id;
    private JTextField y_id;
    private JTextField ypm;
    private JTextField feiyong;
    private JTextField num;
    private JTextField bk;
    private String s;




    public 添加看病记录(int a, String s){
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
            p4.add(new JLabel("身份证号*"));
            h_id=new JTextField();
            p4.add(h_id);
            p4.add(new JLabel("药品号*"));
            y_id=new JTextField();
            p4.add(y_id);
        }else {
            JLabel jLabel=new JLabel("请输入对应的药品号：");
            jLabel.setFont(new Font("宋体",1,15));
            p4.add(jLabel);
            y_id=new JTextField();
            p4.add(y_id);
        }





        p4.add(new JLabel("药品名"));
        ypm=new JTextField();
        p4.add(ypm);

        p4.add(new JLabel("数量"));
        num=new JTextField();
        p4.add(num);
        p4.add(new JLabel("费用"));
        feiyong=new JTextField();
        p4.add(feiyong);
        p4.add(new JLabel("病况"));
        bk=new JTextField();
        p4.add(bk);



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
                    sql="INSERT INTO kanbing(h_id,y_id,ypm,num,feiyong,bk) Values("+"'"+h_id.getText()+"'"+
                            ","+"'"+ y_id.getText()+"'"+",'" +ypm.getText()+"',"+"'"+Integer.valueOf(feiyong.getText())+"'"+","+Integer.valueOf(num.getText())+",'"+bk.getText()+"')";
                    JOptionPane.showMessageDialog(this, "添加成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    sql = "update kanbing set ypm='"+ypm.getText()+"',bk='"+bk.getText()+"',num="+Integer.valueOf(num.getText())+",feiyong="+Integer.valueOf(feiyong.getText())+    " where y_id='"+y_id.getText()+"' and h_id='"+s+"'";
//sql="update kanbing set ypm ='101' where h_id='"+s+"'";
                    JOptionPane.showMessageDialog(this, "修改成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
                }

                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
                this.setVisible(false);
                this.removeAll();
                this.add(new 看病记录列表(0,null));
                this.setVisible(true);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "药品或患者不存在！", "系统提示", JOptionPane.WARNING_MESSAGE);
               // ex.printStackTrace();
            }
        }

    }
}
