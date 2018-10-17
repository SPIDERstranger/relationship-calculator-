package demo;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/*
 * 整体框架的类
 */
public class QinQiJiSuanQi extends JFrame {
	/**
	 * 2018/09/23 编写了初步的图的读取
	 * 2018/09/28 搭好了大致界面框架，并且添加了部分按键功能
	 * 2018/10/01 修改了图的读取，提高录入数据时的便捷性，并且录入了少量数据
	 * 2018/10/02 增加了退格键的功能，修改了退格键的bug 
	 * 2018/10/03 增加了即时出现结果的功能，增加超出范围显示
	 * 2018/10/06 填充了AC键的功能
	 * 2018/10/08 修改了超出范围后，弹出提示窗口并清空输入值
	 * 2018/10/09 修改了关系需要判断大小是屏蔽其他按键 ，更改了字体大小
	 * 2018/10/11 增加了弹出超出范围的窗口 
	 * 2018/10/12 添加了输入过多时，弹窗且清空输入值的代码 ，并且将清空代码整合成一个通用方法
	 * 2018/10/13 修改了出现分歧时输出窗口的输出，修复了AC时按键不完全屏蔽的bug 
	 * 2018/10/14 修改了屏蔽按键时的bug，优化找出分歧的代码
	 * 2018/10/15 更改了界面颜色，更改按键尺寸
	 * 2018/10/17 增加了调皮的彩蛋,添加了批处理文件运行和打包成jar文件，更改了data的读取方式
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
		super("关系计算器");
		this.setLayout(null);
		// JPanel textpPanel=new JPanel();
		// textpPanel.setBackground(new Color(153, 187, 170));
		// textpPanel.setBounds(5, 10, 275, 100);
		// *************************文本域设置****************************************
		inpuTextArea = new JTextPane();
		inpuTextArea.setBounds(5, 10, 255, 50);
		inpuTextArea.setEditable(false);
		inpuTextArea.setBackground(new Color(220, 220, 220));
		inpuTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		resultTextArea = new JTextArea();
		resultTextArea.setBounds(5, 61, 255, 50);
		resultTextArea.setEditable(false);
		resultTextArea.setBackground(new Color(220, 220, 220));
		resultTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		resultTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// ******************下面是各种按钮***************************
		ButtonListener btnListener = new ButtonListener();

		// ******************************关系按键*******************************
		// 父 按钮
		fatherButton = new JButton("父");
		fatherButton.setBounds(5, 120, 60, 60);
		fatherButton.setBackground(new Color(250, 250, 250));
		fatherButton.setForeground(new Color(0, 0, 0));
		fatherButton.setFont(new Font("宋体", Font.BOLD, 20));
		fatherButton.addActionListener(btnListener);
		// 母 按钮
		motherButton = new JButton("母");
		motherButton.setBounds(70, 120, 60, 60);
		motherButton.setBackground(new Color(250, 250, 250));
		motherButton.setForeground(new Color(0, 0, 0));
		motherButton.setFont(new Font("宋体", Font.BOLD, 20));
		motherButton.addActionListener(btnListener);
		// 兄
		bortherButton = new JButton("兄");
		bortherButton.setBounds(5, 185, 60, 60);
		bortherButton.setBackground(new Color(250, 250, 250));
		bortherButton.setForeground(new Color(0, 0, 0));
		bortherButton.setFont(new Font("宋体", Font.BOLD, 20));
		bortherButton.addActionListener(btnListener);
		// 弟
		littleBortherButton = new JButton("弟");
		littleBortherButton.setBounds(70, 185, 60, 60);
		littleBortherButton.setBackground(new Color(250, 250, 250));
		littleBortherButton.setForeground(new Color(0, 0, 0));
		littleBortherButton.setFont(new Font("宋体", Font.BOLD, 20));
		littleBortherButton.addActionListener(btnListener);
		// 夫
		husbandButton = new JButton("夫");
		husbandButton.setBounds(135, 185, 60, 60);
		husbandButton.setBackground(new Color(250, 250, 250));
		husbandButton.setForeground(new Color(0, 0, 0));
		husbandButton.setFont(new Font("宋体", Font.BOLD, 20));
		husbandButton.addActionListener(btnListener);
		// 姐
		sisterButton = new JButton("姐");
		sisterButton.setBounds(5, 250, 60, 60);
		sisterButton.setBackground(new Color(250, 250, 250));
		sisterButton.setForeground(new Color(0, 0, 0));
		sisterButton.setFont(new Font("宋体", Font.BOLD, 20));
		sisterButton.addActionListener(btnListener);
		// 妹
		littleSisterButton = new JButton("妹");
		littleSisterButton.setBounds(70, 250, 60, 60);
		littleSisterButton.setBackground(new Color(250, 250, 250));
		littleSisterButton.setForeground(new Color(0, 0, 0));
		littleSisterButton.setFont(new Font("宋体", Font.BOLD, 20));
		littleSisterButton.addActionListener(btnListener);
		// 妻
		wifeButton = new JButton("妻");
		wifeButton.setBounds(135, 250, 60, 60);
		wifeButton.setBackground(new Color(250, 250, 250));
		wifeButton.setForeground(new Color(0, 0, 0));
		wifeButton.setFont(new Font("宋体", Font.BOLD, 20));
		wifeButton.addActionListener(btnListener);
		// 子
		sonButton = new JButton("儿");
		sonButton.setBounds(5, 315, 60, 60);
		sonButton.setBackground(new Color(250, 250, 250));
		sonButton.setForeground(new Color(0, 0, 0));
		sonButton.setFont(new Font("宋体", Font.BOLD, 20));
		sonButton.addActionListener(btnListener);
		// 女
		daughterbButton = new JButton("女");
		daughterbButton.setBounds(70, 315, 60, 60);
		daughterbButton.setBackground(new Color(250, 250, 250));
		daughterbButton.setForeground(new Color(0, 0, 0));
		daughterbButton.setFont(new Font("宋体", Font.BOLD, 20));
		daughterbButton.addActionListener(btnListener);
		// ******************************关系按键*******************************

		// ******************************控制按键*********************************
		// 小
		youngerButton = new JButton("小");
		youngerButton.setBounds(200, 250, 60, 60);
		youngerButton.setBackground(new Color(222, 222, 222));
		youngerButton.setForeground(new Color(0, 0, 0));
		youngerButton.setFont(new Font("宋体", Font.BOLD, 20));
		youngerButton.addActionListener(btnListener);
		// 大
		olderButton = new JButton("大");
		olderButton.setBounds(200, 185, 60, 60);
		olderButton.setBackground(new Color(222, 222, 222));
		olderButton.setForeground(new Color(0, 0, 0));
		olderButton.setFont(new Font("宋体", Font.BOLD, 20));
		olderButton.addActionListener(btnListener);
		// 等于
		resultButton = new JButton("=");
		resultButton.setBounds(135, 315, 125, 60);
		resultButton.setBackground(new Color(222, 222, 222));
		resultButton.setForeground(new Color(0, 0, 0));
		resultButton.setFont(new Font("宋体", Font.BOLD, 40));
		resultButton.addActionListener(btnListener);
		// 退格
		backButton = new JButton("←");
		backButton.setBounds(135, 120, 60, 60);
		backButton.setBackground(new Color(222, 222, 222));
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setFont(new Font("宋体", Font.BOLD, 20));
		backButton.addActionListener(btnListener);
		// 清零
		acButton = new JButton("AC");
		acButton.setBounds(200, 120, 60, 60);
		acButton.setBackground(new Color(222, 222, 222));
		acButton.setForeground(new Color(0, 0, 0));
		acButton.setFont(new Font("宋体", Font.BOLD, 16));
		acButton.addActionListener(btnListener);
		// ********************************控制按键************************************

		// ********************************按钮******************************
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
		// ********************************按钮******************************

		// *********************************文本框*************************************
		this.add(inpuTextArea);
		this.add(resultTextArea);
		this.setSize(280, 420);
		this.getContentPane().setBackground(new Color(233, 233, 233));
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);

		initData();
	}

	public static void main(String[] args) {
		new QinQiJiSuanQi();
	}
	
	/**
	 * 更改其他关系按键启用状态
	 * @param change 按键改变 true-开启  false-关闭
	 */
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
	
	
	/**
	 * 更改“大”和“小”按键启用状态
	 * @param change 按键改变 true-开启  false-关闭
	 */
	public static void setOldAndYoung(Boolean change) {
		youngerButton.setEnabled(change);
		olderButton.setEnabled(change);
	}

	
	/**
	 * 更改返回和清除按键启用状态
	 * @param change 按键改变 true-开启  false-关闭
	 */
	public static void setBackAndAC(Boolean change) {
		acButton.setEnabled(change);
		backButton.setEnabled(change);
	}

	
	/**
	 * 更改所有按键启用状态
	 * @param change 按键改变 true-开启  false-关闭
	 */
	public static void setAllButton(Boolean change) {
		setBackAndAC(change);
		setOldAndYoung(change);
		setRelationButton(change);
	}
	
	/**
	 * 初始化整个计算器
	 */
	void initData() {
		BufferedReader bfReader = null;
		
		

		//获取屏幕大小，将窗口放置中央
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		this.setLocation(screenWidth / 2 - 140, screenHeight / 2 - 210);

		try {
			bfReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/demo/data.txt"), "utf-8"));
//		} catch (FileNotFoundException e) {
//			JOptionPane.showMessageDialog(null, "数据文件不存在！");
//			setAllButton(false);
		}catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "数据文件不存在！");
			setAllButton(false);
		} 
		catch (UnsupportedEncodingException e) {

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
			setAllButton(false);
			Logger.getGlobal().info("数据载入失败");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "可能还有些小bug请见谅");
			Logger.getGlobal().info("数据载入完成->共加载数据" + dataHashtable.size() + "条");
			System.out.println("数据载入完成->共加载数据" + dataHashtable.size() + "条");
		}
		setOldAndYoung(false);
		setBackAndAC(false);
	}

}// class


/**
 * 监听按钮且处理关系的类
 */
class ButtonListener implements ActionListener {
	private ArrayList<String> stack = new ArrayList<>();// 泛型数组用作栈
	StringSubClass ss = new StringSubClass();
	String[] oldAndYoung = new String[2];

	public void actionPerformed(ActionEvent e) {
		String which = ((JButton) e.getSource()).getText();// 获取按键的文字
		if (which.equals("AC")) {
			QinQiJiSuanQi.now = reSetAll();
			stack.removeAll(stack);// 删除栈中的所有数据
		} else if (which.equals("=")) {

			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			// QinQiJiSuanQi.now="你";
		} else if (which.equals("←")) {
			QinQiJiSuanQi.inpuTextArea.setText(QinQiJiSuanQi.inpuTextArea.getText().substring(0,
					QinQiJiSuanQi.inpuTextArea.getText().length() - 1));// 删除输入值字符串的顶部
			QinQiJiSuanQi.setRelationButton(true);
			QinQiJiSuanQi.now = getLast();// 获取上一个得到的关系
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			QinQiJiSuanQi.setOldAndYoung(false);
			if (stack.size() == 0) {
				QinQiJiSuanQi.setBackAndAC(false);
			}

		} else if (which.equals("小")) {

			QinQiJiSuanQi.now = oldAndYoung[1];
			// System.out.println(oldAndYoung[1]);
			// System.out.println(QinQiJiSuanQi.now);
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			QinQiJiSuanQi.setOldAndYoung(false);
			QinQiJiSuanQi.setRelationButton(true);
		} else if (which.equals("大")) {

			QinQiJiSuanQi.now = oldAndYoung[0];
			QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
			QinQiJiSuanQi.setOldAndYoung(false);
			QinQiJiSuanQi.setRelationButton(true);
		} else {// 按下关系按钮时触发
			QinQiJiSuanQi.inpuTextArea.setText(QinQiJiSuanQi.inpuTextArea.getText() + which);
			// System.out.println(which);//
			QinQiJiSuanQi.now = getNext(which);
			if (QinQiJiSuanQi.now.charAt(0) == '<') {// 判断是否出现分歧的关系
				// QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);
				// System.out.println(QinQiJiSuanQi.now);
				QinQiJiSuanQi.setOldAndYoung(true);
				QinQiJiSuanQi.setRelationButton(false);
				oldAndYoung = ss.subStringAll(QinQiJiSuanQi.now, "<", ">");
				QinQiJiSuanQi.resultTextArea.setText(oldAndYoung[0] + "/" + oldAndYoung[1]);// 输出相应的关系
				//System.out.println(oldAndYoung[0] + "/" + oldAndYoung[1]);
			} else
				QinQiJiSuanQi.resultTextArea.setText(QinQiJiSuanQi.now);// 输出相应的关系
		} // 按键读取

	}

	static int hmout = 0;// 记录超出计算范围次数
	static int hmoutSize = 1;//记录超出文本次数
	static int maxSize = 15;//输入值最大值
	
	/**
	 * 返回的下一个关系
	 * @param what 此时的关系
	 * @return 返回的下一个关系
	 */
	String getNext(String what) {
		String relationsString = QinQiJiSuanQi.dataHashtable.get(QinQiJiSuanQi.now);
		stack.add(QinQiJiSuanQi.now);
		if (stack.size() >= maxSize) {
			inputTextTooLong();
			return reSetAll();
		}
		QinQiJiSuanQi.setBackAndAC(true);
		String[] relation = null;
		if (relationsString != null) {
			relation = ss.subStringAll(relationsString, "(", ")");
		} else {// 超出范围的情况
			boundWindowA();
			hmout++;
			return reSetAll();
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
		
	/**
	 * 返回上一个关系
	 * @return 返回上一个关系
	 */
	String getLast() {
		String laString = stack.remove(stack.size() - 1);
		return laString;
	}
	
	/**
	 * 重置所有的输入值
	 * @return 返回最初的关系“你”
	 */
	String reSetAll()
	{
		stack.removeAll(stack);
		QinQiJiSuanQi.setOldAndYoung(false);
		QinQiJiSuanQi.setRelationButton(true);
		QinQiJiSuanQi.setBackAndAC(false);
		QinQiJiSuanQi.inpuTextArea.setText("");
		QinQiJiSuanQi.resultTextArea.setText("");
		return "你";
	}
	
	
	
	//⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇彩蛋文本⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇
	void inputTextTooLong() {

		if (hmoutSize > 3 && hmoutSize < 6) {
			maxSize += 5;
			JOptionPane.showMessageDialog(null, "你是认真的吗？我给你加一下宽度");
		} else {
			if (hmoutSize <= 3) {
				JOptionPane.showMessageDialog(null, "你是真的闲，点这么多次");
			} else if (hmoutSize > 6) {
				JOptionPane.showMessageDialog(null, "文本框就这么大，加不动了");
			} else {
				JOptionPane.showMessageDialog(null, "我就加最后一次了，不要再闹了好吗");
				maxSize += 5;
			}
		}
		hmoutSize++;
	}

	void boundWindowA() {
		switch (hmout) {
		case 4:
			JOptionPane.showMessageDialog(null, "再玩就坏了");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "好吧其实玩不坏的吧~");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "真的有这么远的亲戚吗");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "真的这么喜欢玩吗");
			break;
		case 8:
			JOptionPane.showMessageDialog(null, "要是真的喜欢，可以用小米的亲戚计算器");
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "单纯为了让计算器坏了话，那真的很难，我劝你善良");
			break;
		case 10:
			JOptionPane.showMessageDialog(null, "要是觉得数据量太少了话，可以试试去自己添加");
			break;
		default:
			JOptionPane.showMessageDialog(null, "超出计算范围");
			break;
		}
	}

}// class
