package t3.huanzhe;

import t3.huanzhe.患者信息管理.患者信息管理;
import t3.huanzhe.看病记录管理.看病信息管理;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 患者看病界面 extends JPanel implements ActionListener {
    JButton jb1,jb2;

    public JButton getJb1() {
        return jb1;
    }

    public JButton getJb2() {
        return jb2;
    }

    // JPanel jp1;
    public 患者看病界面(){
        jb1=new JButton("患者管理");
        jb2=new JButton("看病管理");
        jb1.setPreferredSize(new Dimension(200,50));
        jb2.setPreferredSize(new Dimension(200,50));

        jb1.addActionListener(this);
        jb2.addActionListener(this);
       // this.setLayout(null);
       // jp1=new JPanel(new FlowLayout(1,50,500));
      //  this.add(jb1);
      //  this.add(jb2);
       // this.add(jp1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="患者管理"){
            this.setVisible(false);
            this.removeAll();
            this.add( new 患者信息管理());
            this.setVisible(true);


        }
        else if(e.getActionCommand()=="看病管理"){
            this.setVisible(false);
            this.removeAll();
            this.add( new 看病信息管理());
            this.setVisible(true);

        }

    }
}
