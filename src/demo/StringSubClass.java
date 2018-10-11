package demo;

public class StringSubClass {

	public String subStringOne(String tempString, String upBarcket, String downBarcket) {
		return tempString.substring(tempString.indexOf(upBarcket) + 1, tempString.indexOf(downBarcket));
	}

	public static void main(String[] args) {
		StringSubClass subClass = new StringSubClass();
		subClass.subStringOne("[������]{(��-������)(ĸ-������)(��-������)(��-������)(��-������)(��-������)(��-������)(��-������)(��-������)(Ů-������)}", "[","]");
		subClass.subStringAll("(��-fu)(ĸ-mu)(��-������)(��-������)(��-������)(��-������)(��-������)(��-������)(��-������)(Ů-������)", "(", ")");
		subClass.subStringAll("<gege><didi>", "<",">" );
	}

	public String[] subStringAll(String tempString, String upBarcket, String downBarcket) {

		int count = 0;
		if (upBarcket == "(" && downBarcket == ")") {
			String[] strings = new String[10];
			int i = tempString.indexOf("-");
			while (count < 10) {
				strings[count] = tempString.substring(i + 1, tempString.indexOf(")", i));

				count++;
				i = tempString.indexOf("-", i + 1);
			}
			return strings;
		} else if (upBarcket == "<" && downBarcket == ">") {
			String[] strings = new String[2];
			int i = tempString.indexOf("<");
			while (count < 2) {
				strings[count] = tempString.substring(i + 1, tempString.indexOf(">", i));
				System.out.println(strings[count]);
				count++;
				i = tempString.indexOf("<", i + 1);
			}
			return strings;
		}
		return null;
	}

}
