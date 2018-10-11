package demo;

import java.util.HashMap;
import java.util.Map;

public class ljw {
	
	private Map<String, Map<String, String>> data;
	
	public ljw() {
		data = new HashMap<>();
		initData();
	}
	
	private void initData() {
		Map<String, Map<String, String>> relation = new HashMap<>();	
		Map<String, String> fa = new HashMap<>();
		fa.put("¸¸", "Ò¯Ò¯");
		/*........*/
		
		relation.put("¸¸Ç×", fa);
		
		String display = "¸¸Ç×";
		String btn = "¸¸";
				
		display = relation.get(display).get(btn);
		
	}
	
}
