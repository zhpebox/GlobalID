package org.test.TestUUID;

import com.util.GlobalID.ProduceGlobalID;

public class TestGlobalID {
	public static void main(String[] args) {
		int i = 0;
		long s = System.currentTimeMillis();
		while(i++<1000){
			System.out.println(ProduceGlobalID.generateRandomId());
		}
		long e = System.currentTimeMillis();
	}
}
