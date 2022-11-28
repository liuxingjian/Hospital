package t3;

import t3.MySnake.MyFrame;
import t3.geren.显示和修改信息;
import t3.huanzhe.患者信息管理.患者信息管理;
import t3.huanzhe.看病记录管理.看病信息管理;
import t3.text登录和注册.Login_Register;
import t3.yaopin.药品信息管理;
import t3.yisheng.医生信息管理;
import t3.帮助.帮助;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 主界面 implements ActionListener {
    private JButton 药品信息管理,医生信息管理,患者信息管理,个人信息管理,帮助,退出系统,放松一下;
    private JPanel p3;
    String account;
    public 主界面(String account){
        this.account=account;
        JFrame app=new JFrame("主界面");
        Container c=app.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setBackground(Color.white);
        c.add(p1,"West");
        p1.setLayout(new GridLayout());
        JPanel p2=new JPanel(new GridLayout(7,1));
        p1.add(p2);
        药品信息管理=new JButton("药品信息管理");
        p2.add(药品信息管理);
        药品信息管理.addActionListener(this);
        医生信息管理=new JButton("医生信息管理");
        p2.add(医生信息管理);
        医生信息管理.addActionListener(this);
        患者信息管理=new JButton("患者信息管理");
        p2.add(患者信息管理);
        患者信息管理.addActionListener(this);
        个人信息管理=new JButton("个人信息管理");

        p2.add(个人信息管理);
        放松一下=new JButton("放松一下");


        p2.add(放松一下);
        放松一下.addActionListener(this);
        个人信息管理.addActionListener(this);
        帮助=new JButton("帮助");
        p2.add(帮助);
        帮助.addActionListener(this);
        退出系统=new JButton("退出系统");
        p2.add(退出系统);
        退出系统.addActionListener(this);

        Image icon = new ImageIcon("..\\实训图片\\2021.3\\001.png").getImage();
       // p3=new JPanel((LayoutManager) icon);
        p3=new BackgroundPanel(icon);



       JLabel cp1=new JLabel("                          欢          迎        进        入");
        cp1.setSize(500,300);
        cp1.setOpaque(false);
        cp1.setBackground(Color.RED);
        cp1.setForeground(Color.RED);
        cp1.setFont(new Font("黑体", Font.BOLD, 20));
        p3.setLayout(new FlowLayout(100,300,200));
        p3.add(cp1);

       JScrollPane spane=new JScrollPane(p3);
        c.add(spane,"Center");
        JPanel p5=new JPanel(new GridLayout(3,1));
        p5.setBackground(Color.GREEN);
        c.add(p5,"South");
        p5.add(new JLabel("java实训",JLabel.CENTER));
        p5.add(new JLabel("医院信息管理",JLabel.CENTER));
        p5.add(new JLabel("软件工程-2021",JLabel.CENTER));
        JPanel p6=new JPanel(new FlowLayout(FlowLayout.CENTER));
        p6.setBackground(Color.yellow);
        c.add(p6,"North");

//        JLabel title=new JLabel("医院信息管理系统");
//        title.setFont(new Font("宋体",1,30));
//        title.setForeground(Color.YELLOW);
//        p6.add(title,JLabel.CENTER);




        app.setSize(1700,740);
        app.setLocation(100,80);
        app.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p3.setLayout(new FlowLayout());
        if(e.getActionCommand()=="药品信息管理"){
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 药品信息管理());
            p3.setVisible(true);
        }
        if(e.getActionCommand()=="医生信息管理"){
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 医生信息管理());
            p3.setVisible(true);
        }
        if(e.getActionCommand()=="患者信息管理"){
            p3.setVisible(false);
            p3.removeAll();
            p3.setLayout(new FlowLayout(1,2,300));

            JButton jb1 = new JButton("患者管理");
            JButton jb2 = new JButton("看病管理");
            jb1.setPreferredSize(new Dimension(200,50));
            jb2.setPreferredSize(new Dimension(200,50));
            jb1.addActionListener(this);
            jb2.addActionListener(this);
            p3.add(jb1);
            p3.add(jb2);

           // p3.add(new 患者看病界面());
            p3.setVisible(true);
        }
        if(e.getActionCommand()=="患者管理"){
            p3.setVisible(false);
            p3.removeAll();
            p3.add( new 患者信息管理());
            p3.setVisible(true);


        }
         if(e.getActionCommand()=="看病管理") {
             p3.setVisible(false);
             p3.removeAll();
             p3.add(new 看病信息管理());
             p3.setVisible(true);
         }
             if(e.getActionCommand()=="个人信息管理"){
            p3.setVisible(false);
            p3.removeAll();
            p3.setLayout(new BorderLayout());

            p3.add(new 显示和修改信息(account));



            p3.setVisible(true);
        }
        if(e.getActionCommand()=="放松一下")
        {
            new MyFrame().setVisible(true);
        }
        if(e.getActionCommand()=="帮助"){
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new 帮助());
            p3.setVisible(true);
        }
        if(e.getActionCommand()=="退出系统"){
            System.exit(0);
        }
    }


    public static void main(String []args) {
        //主程序
        //登录窗口
        Login_Register login_register = new Login_Register();

    }

}
