package org.test.TestUUID;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

public class produce2 {
	public static void main(String[] args) {
		//毫秒级：
//		System.out.println(System.currentTimeMillis());
		
		//纳秒级： 
//		int i=0;
//		while(i++<100){
//			System.out.println(System.nanoTime());
//		}
		try {
			InetAddress ia = InetAddress.getLocalHost();
			String s = ia.getHostAddress();
//			System.out.println(s);
			String[] items = s.split("\\.");//点需要字符转义，而反斜杠有时转义字符，所以需要两个  
			for(String it : items){
//				System.out.println(it);
			}
//			System.out.println(x+"   "+y);
			
			long time = System.currentTimeMillis();
//			long nano = System.nanoTime();
			int x = 323 + Integer.parseInt(items[0]);
			int y = 232 + Integer.parseInt(items[1]);
			int w = 156 + Integer.parseInt(items[2]);
			int z = 468 + Integer.parseInt(items[3]);
//			int xx = (int) (Math.random()*1000000);
//			xx = xx >= 900000 ?xx:(xx+100000);
			int  xx = java.util.concurrent.ThreadLocalRandom.current().nextInt(1000)+1000;
			String xstr = (xx+"").substring(1, 3);
			System.out.println(xstr);

			String id = time+"-"+x+"-"+y+"-"+w+"-"+z+"-"+xx +"";
			String ids = time+""+x+""+y+""+w+""+z+""+xx +"";
			
			
			System.out.println(time);
			System.out.println(x);
			System.out.println(y);
			System.out.println(xx);
			System.out.println(id);
			System.out.println(ids);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
	
	public static void main2(String[] args) throws SocketException, UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		NetworkInterface netInterface = NetworkInterface.getByInetAddress(ia.getLocalHost());
		
		byte[] macAddr = netInterface.getHardwareAddress();
		
		StringBuffer sb = new StringBuffer("");
		for(int i=0;i<macAddr.length;i++){
			if(i!=0){
				sb.append("-");
			}
			//字节转换为整数
			int temp = macAddr[i] & 0xFF;
			String str = Integer.toHexString(temp);
			System.out.println(macAddr[i]+"  "+temp+"   "+str);
			if(str.length()==1){
				sb.append("0"+str);
			}else{
				sb.append(str);
			}
		}
		System.out.println(sb.toString().toUpperCase());
		
	}

	public static void main3(String[] args) {
		int i = 0;
		while(i++<1000){
//			Date date = new Date();
//			long x = date.getTime();
//			System.out.println(x);
//			System.out.println(System.currentTimeMillis()+"  "+(System.nanoTime()%1000+1000)+"   "+Math.random());
//			System.out.println("  "+(System.nanoTime()%10000+10000));
//			int xx = (int) (Math.random()*1000000);
//			xx = xx >= 900000 ?xx:(xx+100000);
//			System.out.println(xx);
			int  xx = java.util.concurrent.ThreadLocalRandom.current().nextInt(1000)+1000;
			
			String xstr = (xx+"").substring(1, 4);
			System.out.println(xx+"  "+xstr);
		}
	}
	
}
