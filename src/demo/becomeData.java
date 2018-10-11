package demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class becomeData {
	static Hashtable<String, String> dataHashtable = new Hashtable<String, String>();

	public static void main(String[] args) {
		StringSubClass ss = new StringSubClass();
		BufferedReader bfReader = null;
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
				String[] relation = new String[10];
				dataHashtable.put(ss.subStringOne(tempString, "[", "]"), ss.subStringOne(tempString, "{", "}"));
			String	relationString = ss.subStringOne(tempString, "{", "}");
				relation = ss.subStringAll(relationString, "(",")");
				System.out.println("\""+ss.subStringOne(tempString, "[", "]")+"\"to object:HashMap<Buttom,String>(){\n"
								 + " init {\n" 
								 + "put(btn_fa,\""+ relation[0] +"\")\n"
								 + "put(btn_ma,\""+ relation[1] +"\")\n"
								 + "put(btn_ge,\""+ relation[2] +"\")\n"
								 + "put(btn_di,\""+ relation[3] +"\")\n"
								 + "put(btn_jie,\""+ relation[4] +"\")\n"
								 + "put(btn_mei,\""+ relation[5] +"\")\n"
								 + "put(btn_fu,\""+ relation[6] +"\")\n"
								 + "put(btn_qi,\""+ relation[7] +"\")\n"
								 + "put(btn_zi,\""+ relation[8] +"\")\n"
								 + "put(btn_nv,\""+ relation[9] +"\")\n"
								 + "}}");

				tempString = bfReader.readLine();
			} // while
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "数据载入失败!");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "说明");
			System.out.println("数据转化完毕->共加载数据" + dataHashtable.size() + "条");
		}
	}
}
