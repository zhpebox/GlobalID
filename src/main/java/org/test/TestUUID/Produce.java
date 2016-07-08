package org.test.TestUUID;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class Produce 
{
	public static void main(String[] args) throws Exception {
        
		int i=0;
		while(i++<100){
			Date date = new Date();
			UUID uuid = uuidForDate(date);
	        long timestamp = uuid.timestamp();
	        String time = new SimpleDateFormat("yyMMddHHmmss-SSS").format(new Date());
	        System.out.println("timestamp : " + timestamp + " -》 "+time+" "+date.getTime() +" ->> "+time
//	        		+" version:"+uuid.version()+""
	        		+ " uuid:"+uuid);
	        //毫秒级：
			System.out.println(System.currentTimeMillis());
			//纳秒级： 
			System.out.println(System.nanoTime());;

			System.out.println();
			
		}
        
		/*
        
        UUID uuid2 = java.util.UUID.randomUUID();
        System.out.println(uuid2);
        String str = uuid2.toString();
        String temp = str.substring(0, 8) 
        		+ str.substring(9, 13) 
        		+ str.substring(14, 18)
        		+ str.substring(19, 23)
        		+ str.substring(24);
        System.out.println(temp);
        System.out.println(uuid2.hashCode());
        */
        
//        int i = 0;
//        while(i++<100){
//        	UUID u = java.util.UUID.randomUUID();
//        	System.out.println(u.toString()+"   -  "+Math.abs(u.hashCode()));
//        }
        
        String x = generateShortUuid();
        System.out.println("X "+x);
    }
    
    public static UUID uuidForDate(Date d)
    {
        final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 0x01b21dd213814000L;
  
        long origTime = d.getTime();
//        System.out.println(origTime);
        long time = origTime * 10000 + NUM_100NS_INTERVALS_SINCE_UUID_EPOCH;
//        System.out.println(Long.toBinaryString(time));
//        System.out.println(Long.toBinaryString(0xffffffffL));
//        System.out.println(Long.toBinaryString(0xffff00000000L));
//        System.out.println(Long.toBinaryString(0xfff000000000000L));
        long timeLow = time &       0xffffffffL;
//        System.out.println(Long.toBinaryString(timeLow));
        long timeMid = time &   0xffff00000000L;
//        System.out.println(Long.toBinaryString(timeMid));
        long timeHi = time & 0xfff000000000000L;
//        System.out.println(Long.toBinaryString(timeHi));
        long upperLong = (timeLow << 32) | (timeMid >> 16) | (1 << 12) | (timeHi >> 48) ;
//        System.out.println("upperLong "+Long.toBinaryString(upperLong));
        return new java.util.UUID(upperLong, 0xC000000000000000L);
    }
    
    public static String[] chars = new String[] { 
  //  0-10	
    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
 //   11-20	
    "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
  //  21-30	
    "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
 //   31-40	
    "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
 //   41-50	
    "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
 //   51-60	
    "O", "P", "Q", "R", "S", "T", "U", "V",	"W", "X",
 //   61-62	
    "Y", "Z" };
    public static String[] chars1 = new String[] { 
		  "01", "02", "03", "04", "05", "06", "07", "08", "09",
	"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
	"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
	"30", "31", "32", "33", "34", "35", "36", "37",	"38", "39",
	"40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
	"50", "51", "52", "53", "54", "55", "56", "57", "58", "59",
	"60", "61", "62", "63", "64", "65", "66", "67", "68", "69",
	"70", "71", "72", "73", "74", "75", "76", "77", "78", "79",
	"80", "81", "82", "83", "84", "85", "86", "87", "88", "89",
	"90", "91", "92", "93", "94", "95", "96", "97", "98", "99"};


	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		StringBuffer shortBuffer1 = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append((x % 0x63)+" ");
			shortBuffer1.append(chars1[x % 0x63]);
		}
		return shortBuffer.toString()+" \n"+shortBuffer1.toString();
	}
	public static String generateShortUuid1() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars1[x % 0x3E]);
		}
		return shortBuffer.toString();

	}
}
