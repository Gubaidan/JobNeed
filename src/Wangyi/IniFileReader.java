package Wangyi;

import java.util.*;


public class IniFileReader {

	/**
	 * 去除ini文件中的注释，以";"或"#"开头，
	 * 
	 * @param source
	 * @return
	 */
	private static String removeIniComments(String source) {
		String result = source;

		if (result.contains(";")) {
			result = result.substring(0, result.indexOf(";"));
		}

		return result.trim();
	}

	public static Map<String, Object> readIniFile(List<String> art) {
		Map<String, List<String>> listResult = new HashMap<>();
		Map<String, Object> result = new HashMap<>();

		String globalSection = "global"; // Map中存储的global properties的key

		String currentSection = globalSection; // 处理缺省的section
		List<String> currentProperties = new ArrayList<>();

		// 一次读入一行（非空），直到读入null为文件结束
		// 先全部放到listResult<String, List>中
		for (String str : art) {
			str = removeIniComments(str).trim(); // 去掉尾部的注释、去掉首尾空格

			if ("".equals(str) || str == null) {
				continue;
			}

			// 是否一个新section开始了
			if (str.startsWith("[") && str.endsWith("]")) {
				String newSection = str.substring(1, str.length() - 1).trim();

				// 如果新section不是现在的section，则把当前section存进listResult中
				if (!currentSection.equals(newSection)) {
					listResult.put(currentSection, currentProperties);
					currentSection = newSection;

					currentProperties = listResult.get(currentSection);
					if (currentProperties == null) {
						currentProperties = new ArrayList<>();
					}
				}
			} else {
				currentProperties.add(str);
			}
		}

		// 把最后一个section存进listResult中
		listResult.put(currentSection, currentProperties);

		// 整理拆开name=value对，并存放到MAP中：
		// 从listResult<String, List>中，看各个list中的元素是否包含等号“=”，如果包含，则拆开并放到Map中
		// 整理后，把结果放进result<String, Object>中
		for (String key : listResult.keySet()) {
			List<String> tempList = listResult.get(key);

			// 空section不放到结果里面
			if (tempList == null || tempList.size() == 0) {
				continue;
			}

			if (tempList.get(0).contains("=")) { // name=value对，存放在MAP里面
				Map<String, String> properties = new HashMap<>();
				for (String s : tempList) {
					int delimiterPos = s.indexOf("=");
					// 处理等号前后的空格
					properties.put(s.substring(0, delimiterPos).trim(),
							s.substring(delimiterPos + 1, s.length()).trim());
				}
				result.put(key, properties);
			} else { // 只有value，则获取原来的list
				result.put(key, listResult.get(key));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> art = new ArrayList<>();

		String s = scan.nextLine();
		while (!s.matches("\\s*")) {
			art.add(s);
			s = scan.nextLine();
		}

		Map<String, Object> ini = readIniFile(art);
		String key, val;
		for (String k : ini.keySet()) {
			String ssString = ini.get(k).toString();
			ssString = ssString.substring(1, ssString.length() - 1);
			String[] c = ssString.split(",");
			Arrays.sort(c);
			for (int i = c.length - 1; i >= 0; i--) {
				key = c[i].substring(0, c[i].indexOf("=")).trim();
				val = c[i].substring(c[i].indexOf("=") + 1, c[i].length()).trim();
				System.out.println("{" + k + "}" + "{" + key + "}" + "{" + val + "}");
			}
		}
	}

}