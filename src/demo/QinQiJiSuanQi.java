package demo;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/*
 * 
 */
public class QinQiJiSuanQi extends JFrame {
	/**
	 * 2018/10/8 修改了超出范围后，弹出提示窗口并清空输入值 下次将修改按键“后”和按键“的”为大和小 2018/10/9
	 * 修改了关系需要判断大小是屏蔽其他按键
	 */
	private static final long serialVersionUID = 1L;
	static Hashtable<String, String> dataHashtable = new Hashtable<String, String>();
	StringSubClass ss = new StringSubClass();
	static String now = "你";
	static JTextPane inpuTextArea;
	static JTextArea resultTextArea;
	static JButton acButton;
	static JButton backButton;
	static JButton youngerButton;
	static JButton olderButton;
	static JButton fatherButton;
	static JButton motherButton;
	static JButton bortherButton;
	static JButton littleBortherButton;
	static JButton husbandButton;
	static JButton sisterButton;
	static JButton littleSisterButton;
	static JButton wifeButton;
	static JButton sonButton;
	static JButton daughterbButton;
	static JButton resultButton;


	public QinQiJiSuanQi() {
		super("亲戚计算器");
		this.setLayout(null);
		// JPanel textpPanel=new JPanel();
		// textpPanel.setBackground(new Color(153, 187, 170));
		// textpPanel.setBounds(5, 10, 275, 100);
		// ********文本域****************************************
		inpuTextArea = new JTextPane();
		inpuTextArea.setBounds(5, 10, 250, 50);
		inpuTextArea.setEditable(false);
		inpuTextArea.setBackground(new Color(153, 187, 170));
		inpuTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		resultTextArea = new JTextArea();
		resultTextArea.setBounds(5, 61, 250, 50);
		resultTextArea.setEditable(false);
		resultTextArea.setBackground(new Color(153, 187, 170));
		resultTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		resultTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// ******************下面是各种按钮***************************
		ButtonListener btnListener = new ButtonListener();
		// 父 按钮
		fatherButton = new JButton("父");
		fatherButton.setBounds(5, 120, 55, 55);
		fatherButton.setBackground(new Color(95, 95, 95));
		fatherButton.setForeground(Color.white);
		fatherButton.setFont(new Font("宋体", Font.BOLD, 20));
		fatherButton.addActionListener(btnListener);
		// 母 按钮
		motherButton = new JButton("母");
		motherButton.setBounds(70, 120, 55, 55);
		motherButton.setBackground(new Color(95, 95, 95));
		motherButton.setForeground(Color.white);
		motherButton.setFont(new Font("宋体", Font.BOLD, 20));
		motherButton.addActionListener(btnListener);
		// 退格
		backButton = new JButton("←");
		backButton.setBounds(135, 120, 55, 55);
		backButton.setBackground(new Color(217, 2, 0));
		backButton.setForeground(Color.white);
		backButton.setFont(new Font("宋体", Font.BOLD, 20));
		backButton.addActionListener(btnListener);
		// 清零
		acButton = new JButton("AC");
		acButton.setBounds(200, 120, 55, 55);
		acButton.setBackground(new Color(217, 2, 0));
		acButton.setForeground(Color.white);
		acButton.setFont(new Font("宋体", Font.BOLD, 16));
		acButton.addActionListener(btnListener);
		// 兄
		bortherButton = new JButton("兄");
		bortherButton.setBounds(5, 185, 55, 55);
		bortherButton.setBackground(new Color(95, 95, 95));
		bortherButton.setForeground(Color.white);
		bortherButton.setFont(new Font("宋体", Font.BOLD, 20));
		bortherButton.addActionListener(btnListener);
		// 弟
		littleBortherButton = new JButton("弟");
		littleBortherButton.setBounds(70, 185, 55, 55);
		littleBortherButton.setBackground(new Color(95, 95, 95));
		littleBortherButton.setForeground(Color.white);
		littleBortherButton.setFont(new Font("宋体", Font.BOLD, 20));
		littleBortherButton.addActionListener(btnListener);
		// 夫
		husbandButton = new JButton("夫");
		husbandButton.setBounds(135, 185, 55, 55);
		husbandButton.setBackground(new Color(95, 95, 95));
		husbandButton.setForeground(Color.white);
		husbandButton.setFont(new Font("宋体", Font.BOLD, 20));
		husbandButton.addActionListener(btnListener);
		// 是否年长
		olderButton = new JButton("大");
		olderButton.setBounds(200, 185, 55, 55);
		olderButton.setBackground(new Color(212, 98, 2));
		olderButton.setForeground(Color.white);
		olderButton.setFont(new Font("宋体", Font.BOLD, 20));
		olderButton.addActionListener(btnListener);
		// 姐
		sisterButton = new JButton("姐");
		sisterButton.setBounds(5, 250, 55, 55);
		sisterButton.setBackground(new Color(95, 95, 95));
		sisterButton.setForeground(Color.white);
		sisterButton.setFont(new Font("宋体", Font.BOLD, 20));
		sisterButton.addActionListener(btnListener);
		// 妹
		littleSisterButton = new JButton("妹");
		littleSisterButton.setBounds(70, 250, 55, 55);
		littleSisterButton.setBackground(new Color(95, 95, 95));
		littleSisterButton.setForeground(Color.white);
		littleSisterButton.setFont(new Font("宋体", Font.BOLD, 20));
		littleSisterButton.addActionListener(btnListener);
		// 妻
		wifeButton = new JButton("妻");
		wifeButton.setBounds(135, 250, 55, 55);
		wifeButton.setBackground(new Color(95, 95, 95));
		wifeButton.setForeground(Color.white);
		wifeButton.setFont(new Font("宋体", Font.BOLD, 20));
		wifeButton.addActionListener(btnListener);
		// 大
		youngerButton = new JButton("小");
		youngerButton.setBounds(200, 250, 55, 55);
		youngerButton.setBackground(new Color(212, 98, 2));
		youngerButton.setForeground(Color.white);
		youngerButton.setFont(new Font("宋体", Font.BOLD, 20));
		youngerButton.addActionListener(btnListener);
		// 子
		sonButton = new JButton("儿");
		sonButton.setBounds(5, 315, 55, 55);
		sonButton.setBackground(new Color(95, 95, 95));
		sonButton.setForeground(Color.white);
		sonButton.setFont(new Font("宋体", Font.BOLD, 20));
		sonButton.addActionListener(btnListener);
		// 女
		daughterbButton = new JButton("女");
		daughterbButton.setBounds(70, 315, 55, 55);
		daughterbButton.setBackground(new Color(95, 95, 95));
		daughterbButton.setForeground(Color.white);
		daughterbButton.setFont(new Font("宋体", Font.BOLD, 20));
		daughterbButton.addActionListener(btnListener);
		// 等于
		resultButton = new JButton("=");
		resultButton.setBounds(135, 315, 120, 55);
		resultButton.setBackground(new Color(212, 98, 2));
		resultButton.setForeground(Color.white);
		resultButton.setFont(new Font("宋体", Font.BOLD, 40));
		resultButton.addActionListener(btnListener);
		// *********************************************************

		this.add(fatherButton);
		this.add(motherButton);
		this.add(backButton);
		this.add(acButton);
		this.add(bortherButton);
		this.add(littleBortherButton);
		this.add(husbandButton);
		this.add(olderButton);
		this.add(sisterButton);
		this.add(littleSisterButton);
		this.add(wifeButton);
		this.add(youngerButton);
		this.add(sonButton);
		this.add(daughterbButton);
		this.add(resultButton);
		// **以上为按钮**
		this.add(inpuTextArea);
		this.add(resultTextArea);
		this.setSize(280, 420);
		this.getContentPane().setBackground(new Color(51, 51, 51));
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		initData();
	}

	public static void main(String[] args) {
		new QinQiJiSuanQi();

	}

	public static void setRelationButton(Boolean change) {
		fatherButton.setEnabled(change);
		motherButton.setEnabled(change);
		bortherButton.setEnabled(change);
		littleBortherButton.setEnabled(change);
		husbandButton.setEnabled(change);
		sisterButton.setEnabled(change);
		littleSisterButton.setEnabled(change);
		wifeButton.setEnabled(change);
		sonButton.setEnabled(change);
		daughterbButton.setEnabled(change);
		resultButton.setEnabled(change);
	}
	public static void setOldAndYoung(Boolean change)
	{
		youngerButton.setEnabled(change);
		olderButton.setEnabled(change);
	}

	void initData() {
		BufferedReader bfReader = null;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		this.setLocation(screenWidth/2-130, screenHeight/2-200);
		setOldAndYoung(false);
		try {
			bfReader = new BufferedReader(new InputStreamReader(new FileInputStream("data.txt"), "utf-8"));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "数据文件不存在！");
		} catch (UnsupportedEncodingException e) {

		}

		String tempString;
		try {
			tempString = bfReader.readLine();
			while (tempString.length() > 3) {
				dataHashtable.put(ss.subStringOne(tempString, "[", "]"), ss.subStringOne(tempString, "{", "}"));
				tempString = bfReader.readLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "数据载入失败!");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "说明");
			System.out.println("数据载入完成->共加载数据" + dataHashtable.size() + "条");
		}
		
	}

}// class

class ButtonListener implements ActionListener {
	private ArrayList<String> stack = new ArrayList<>();
	StringSubClass ss = new StringSubClass();

	// 按键读取
	public void actionPerformed(ActionEvent e) {
		String which = ((JButton) e.getSource()).getText();
		String[] oldAndYoung = new String[2];
		if (which.equals("AC")) {
			QinQiJiSuanQi.now = "你";
			QinQiJiSuanQi.olderButton.setBackground(new Color(212, 98, 2));
			QinQiJiSuanQi.inpuTextArea.setText("");
			QinQiJiSuanQi.resultTextArea.setText("");
			QinQiJiSuanQi.setRelationButton(true);
		} else if (which.equals("=")) {
			QinQiJiSuanQi.olderButton.setBackground(new Color(212, 98, 2));
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			// QinQiJiSuanQi.now="你";
		} else if (which.equals("←")) {
			if (QinQiJiSuanQi.inpuTextArea.getText().length() > 0) {
				QinQiJiSuanQi.olderButton.setBackground(new Color(212, 98, 2));
				QinQiJiSuanQi.inpuTextArea.setText(QinQiJiSuanQi.inpuTextArea.getText().substring(0,
						QinQiJiSuanQi.inpuTextArea.getText().length() - 1));
				QinQiJiSuanQi.setRelationButton(true);
				QinQiJiSuanQi.now = getLast();
				QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			}
		} else if (which.equals("小")) {
			oldAndYoung = ss.subStringAll(QinQiJiSuanQi.now, "<", ">");
			QinQiJiSuanQi.now = oldAndYoung[1];
			System.out.println(oldAndYoung[1]);
			System.out.println(QinQiJiSuanQi.now);
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			QinQiJiSuanQi.setOldAndYoung(false);
			QinQiJiSuanQi.setRelationButton(true);
		} else if (which.equals("大")) {
			oldAndYoung = ss.subStringAll(QinQiJiSuanQi.now, "<", ">");
			QinQiJiSuanQi.now = oldAndYoung[0];
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			QinQiJiSuanQi.setOldAndYoung(false);
			QinQiJiSuanQi.setRelationButton(true);
		} else {// 按下关系按钮时
			QinQiJiSuanQi.olderButton.setBackground(new Color(212, 98, 2));
			QinQiJiSuanQi.inpuTextArea.setText(QinQiJiSuanQi.inpuTextArea.getText() + which);
			System.out.println(which);//
			QinQiJiSuanQi.now = getNext(which);
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);// 输出相应的关系
			if (QinQiJiSuanQi.now.charAt(0) == '<') {
				// QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
				System.out.println(QinQiJiSuanQi.now);
				QinQiJiSuanQi.setOldAndYoung(true);
				QinQiJiSuanQi.setRelationButton(false);
			}
		}

	}

	String getNext(String what) {// 获取下一个关系
		String relationsString = QinQiJiSuanQi.dataHashtable.get(QinQiJiSuanQi.now);
		stack.add(QinQiJiSuanQi.now);
		String[] relation = null;
		if (relationsString != null) {
			relation = ss.subStringAll(relationsString, "(", ")");
		} else {// 超出范围的情况
			JOptionPane.showMessageDialog(null, "超出计算范围");
			QinQiJiSuanQi.now = "你";
			QinQiJiSuanQi.olderButton.setBackground(new Color(212, 98, 2));
			QinQiJiSuanQi.inpuTextArea.setText("");
			QinQiJiSuanQi.resultTextArea.setText("");
			return QinQiJiSuanQi.now;
		}

		if (what.equals("父")) {
			return relation[0];
		} else if (what.equals("母")) {
			return relation[1];
		} else if (what.equals("兄")) {
			return relation[2];
		} else if (what.equals("弟")) {
			return relation[3];
		} else if (what.equals("姐")) {
			return relation[4];
		} else if (what.equals("妹")) {
			return relation[5];
		} else if (what.equals("夫")) {
			return relation[6];
		} else if (what.equals("妻")) {
			return relation[7];
		} else if (what.equals("儿")) {
			return relation[8];
		} else if (what.equals("女")) {
			return relation[9];
		} else {
			return QinQiJiSuanQi.now;
		}

	}

	String getLast() {// 返回上一个关系
		String laString = stack.remove(stack.size() - 1);
		return laString;
	}
}// class
