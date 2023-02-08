package com.ezen.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA256 {
	private static final String SALT = "dlwpszjavbxj!@34";
	
	private SHA256() {
		
	}

	public static String encode(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA256"); //message digest: 메시지를 해시함
			md.update((SALT + source).getBytes());
			
			byte[] bytes = md.digest(); //digest()메서드는 업데이트된 md값을 가져옴 bytes = SALT+source
			StringBuilder sb = new StringBuilder();
			for(byte b : bytes) {
				sb.append(String.format("%02X", b)); //바이트를  스트링형태로 바꿔서 추가
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
