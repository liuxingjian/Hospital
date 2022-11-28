package t3.帮助;


import javax.swing.*;
import java.awt.*;

public class 帮助 extends JPanel  {

    private JTextArea jt;
    public 帮助() {
        jt=new JTextArea(10, 10);
        jt.setSize(600,200);
        jt.setLineWrap(true);
        jt.setForeground(Color.BLACK);    //设置字体色
        jt.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
      //  jt.setBackground(Color.YELLOW);    //设置背景色

        String str="当您使用 SOLIDWORKS 遇到问题时，您可以通过其他多种方法找到答案。\n" +
                "\n" +
                "在帮助菜单上：\n" +
                "\n" +
                "欢迎使用 SOLIDWORKS\t链接到客户门户、用户组、探讨论坛、教学资源、技术新闻和提醒。\n" +
                "SOLIDWORKS 帮助\t帮助主题汇编（包括您正在阅读的此篇帮助主题）。 您可以浏览目录或通过搜索查找感兴趣的主题。\n" +
                "SOLIDWORKS 指导教程\t逐步课程带有示例文件，涵盖 SOLIDWORKS 及诸多插件。 还可通过课程选项卡的欢迎对话框访问。\n" +
                "API 帮助\t应用程序编程界面帮助。\n" +
                "搜索\t搜索信息、命令、文件和模型。 在 SOLIDWORKS 中和 SOLIDWORKS 知识库、论坛、博客、3D ContentCentral、Twitter 和 YouTube 等位置进行搜索。\n" +
                "新版本说明\t有关最新 service pack 的最新信息。\n" +
                "新增功能\t含当前 SOLIDWORKS 发行版新功能相关信息的帮助文件或 PDF 文件。 还可通过主页选项卡的欢迎对话框进行访问。\n" +
                "新增功能 > 交互新增功能\t单击新菜单项旁边的  以及新增和更改的 PropertyManager 标题，便可链接到新增功能中的相应主题。\n" +
                "SOLIDWORKS 入门 (PDF)\t提供 SOLIDWORKS 产品的概述。 还可通过课程选项卡的欢迎对话框访问。\n" +
                "从 2D 过渡到 3D\t帮助您从 2D CAD 软件过渡到 3D SOLIDWORKS 软件。 此帮助比较术语和概念，解释 SOLIDWORKS 的设计方法，提供 SOLIDWORKS 帮助、指导教程的链接以及其他资源。\n" +
                "使用 SOLIDWORKS Web 帮助\t在 Web 帮助和本地帮助之间切换。\n" +
                "检查更新\t立即检查或排定定期检查看是否有最新的 Service Pack。\n" +
                "激活许可\t初始化许可激活过程。\n" +
                "停用许可\t将许可停用以转回 SOLIDWORKS，以便您可在不同的或重建的计算机上激活。\n" +
                "显示许可\t显示当前激活的产品。\n" +
                "我的产品\t显示您当前可用的所有 SOLIDWORKS 产品，还可根据您的激活和网络许可，指明您或您的机构当前拥有的产品。\n" +
                "关于 SOLIDWORKS\t显示有关 SOLIDWORKS 产品、其版本、版权、许可协议以及活动序列号的信息。 单击 连接 以链接到 SOLIDWORKS 网站。\n" +
                "在 SOLIDWORKS 用户界面中：\n" +
                "\n" +
                "PropertyManagers 及对话框\t在激活的 PropertyManager 或对话框中，单击 帮助 ，单击 帮助 按钮，或按 F1 来打开上下文相关帮助。\n" +
                "工具提示\t将指针停留以查看有关工具栏上的工具及 PropertyManager 和对话框中项目等的信息。\n" +
                "状态栏\t当前状态和活动的简要说明出现在 SOLIDWORKS 窗口底部的状态栏中。\n" +
                "内容\n" +
                "\n" +
                "访问帮助\n" +
                "当您访问帮助时，文献的 Web 版本在基于 Web 的视图中显示。如果您的 Internet 连接较慢或无法使用，您仍可选择查阅本地帮助文件 (.chm)。\n" +
                "\n" +
                "交互新增功能\n" +
                "提供新增功能手册中有关新菜单项以及新的和更改的 PropertyManagers 的主题链接。 这些主题说明了 SOLIDWORKS 软件以前版本发行以来新增的功能，通常包括范例文件的示例。";
        jt.setText(str);
        this.add(jt);

    }


}




