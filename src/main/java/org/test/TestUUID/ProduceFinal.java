package org.test.TestUUID;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class ProduceFinal {
	
	/**
	 * 由时间戳(12)+机器码(12)+随机数(4)生成28位随机数，以BigDecimal形式输出
	 * @return BigDecimal
	 */
	public BigDecimal generateRandomId(){

		//毫秒级时间戳
		long time_stamp = System.currentTimeMillis() - 1000000000000L;
		
		//机器码（java本身做到与硬件分离，如果获取其他如CPU序列号等信息，或增加该过程的失效性）
		String host_stamp = "";
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
			String[] items = ia.getHostAddress().split("\\.");//点需要字符转义，而反斜杠有时转义字符，所以需要两个  
			String ip_a = 185 + Integer.parseInt(items[0]) +""; //加上固定数混淆
			String ip_b = 296 + Integer.parseInt(items[1]) +"";
			String ip_c = 152 + Integer.parseInt(items[2]) +"";
			String ip_d = 585 + Integer.parseInt(items[3]) +"";
			host_stamp = ip_a + ip_b + ip_c + ip_d;
		} catch (UnknownHostException e) {
			//如果出现异常，直接采用UUID生成12位随机数
			e.printStackTrace();
			String randomStr = generateShortUuid();
			String id = time_stamp + "" + randomStr;
			return new BigDecimal(id);
		} 
		
		//随机数默认4位
		int randomNum = java.util.concurrent.ThreadLocalRandom.current().nextInt(10000)+10000;
		String random = (randomNum+"").substring(1, 5);

		String id = time_stamp + "" + host_stamp + "" + random +"";
		
		//格式化输出
		String id_ = time_stamp + "-" + host_stamp + "-" + random +"";
		System.out.println(id_);
		
		return new BigDecimal(id);
	}
	
	//转化关系表
	public static String[] chars = new String[] { "01", "02", "03", "04",
		"05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
		"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
		"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37",
		"38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
		"49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59",
		"60", "61", "62" };
	
	/**
	 * 根据UUID产生16位随机数
	 * @return
	 */
	private static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]); //62进制
		}
		return shortBuffer.toString();

	}
	
	//测试方法
	/*
	public static void main(String[] args) {
		ProduceFinal s = new ProduceFinal();
		for(int i = 0;i<1000;i++){
			System.out.println(s.generateRandomId());
		}
		
	}
	*/
}
