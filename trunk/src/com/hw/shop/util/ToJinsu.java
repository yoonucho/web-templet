package com.hw.shop.util;



import java.math.BigDecimal;

import sun.misc.BASE64Encoder;

/**
 * Class Name	:	ToJinsu.java
 * Description	:	진수 변환 클래스	
 * Modification Information 
 * 
 * 		수  정  일			수정자		수정내용
 * 	  --------------   --------    ---------------------------------------------
 * 		2010. 7. 16.	김형욱		최초생성
 * 
 * 
 * @author		:	김형욱
 * @since		:	2010. 7. 16.
 * @version		:	1.0
 */
public class ToJinsu {
	/**
	 * Hex -> 10진수 변환
	 * 
	 * @param hex
	 * @return
	 */
	public String getHexToDec(String hex) {
		long v = Long.parseLong(hex, 16);
		return String.valueOf(v);
	}

	/**
	 * 10진수 -> Hex 변환
	 * 
	 * @param dec
	 * @return
	 */
	public String getDecToHex(String dec) {

		Long intDec = Long.parseLong(dec);
		return Long.toHexString(intDec).toUpperCase();
	}
	
	/**
	 * 10진수를 64진수로 변경
	 * 0-9 A-Z a-z 로 가지고 생성
	 * @param dec
	 * @return
	 */
	//정렬 기준을 가지고 아래와 같이 64비트생성
	public static final char[] Jinsu64 = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '<', '>', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };
	public static int JINSU_BIT = 64; 

	public  String getJinsu(String val) {

		BigDecimal JIN_SU = new BigDecimal(JINSU_BIT);
		BigDecimal bdVal = new BigDecimal(val);

		// 들어온 값이 진수보다 크면
		if (bdVal.compareTo(JIN_SU) > -1) {

			BigDecimal namerji = bdVal.remainder(JIN_SU);
			BigDecimal moc = bdVal.divide(JIN_SU, BigDecimal.ROUND_DOWN);

			if (moc.compareTo(JIN_SU) > -1) {
				return getJinsu(moc.toString())
						+ Character.toString(Jinsu64[Integer.parseInt(namerji
								.toString())]);
			} else {
				return Jinsu64[Integer.parseInt(moc.toString())]
						+ Character.toString(Jinsu64[Integer.parseInt(namerji
								.toString())]);
			}
		} else {//들어온 값이 진수보다 작으면
			return Character.toString(Jinsu64[Integer.parseInt(val)]);
		}
	}
	
	public  String jinsuToDec(String val) {
		// TODO Auto-generated method stub

		for (int i = 0; i < val.length(); i++) {

			for (int j = 0; j < JINSU_BIT; j++) {
				if (Jinsu64[j] == val.charAt(i)) {
					BigDecimal JIN_SU = new BigDecimal(JINSU_BIT);

					if (i == val.length() - 1) {
						return Integer.toString(j);
					} else {
						BigDecimal val1 = JIN_SU.pow(val.length()-1);
						return val1.multiply(new BigDecimal(j)).add(
								new BigDecimal(jinsuToDec(val.substring(1, val
										.length())))).toString();
					}
				}
			}
		}
		return "0";
	}

	public static void main(String[] args) {
//		System.out.println("5 factorial = " + getJinsu("4095"));
//		System.out.println("5 factorial = " + jinsuToDec("zz"));
	}


}
