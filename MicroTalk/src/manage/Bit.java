package manage;

/**
 * 实现常用的位操作和基于位的进制转换
 * 
 * @author 张广
 * 
 */
public class Bit {
	private final static int intBit[] = { 0x80000000, 0x40000000, 0x20000000,
			0x10000000, 0x08000000, 0x04000000, 0x02000000, 0x01000000,
			0x00800000, 0x00400000, 0x00200000, 0x00100000, 0x00080000,
			0x00040000, 0x00020000, 0x00010000, 0x00008000, 0x00004000,
			0x00002000, 0x00001000, 0x00000800, 0x00000400, 0x00000200,
			0x00000100, 0x00000080, 0x00000040, 0x00000020, 0x00000010,
			0x00000008, 0x00000004, 0x00000002, 0x00000001 };

	private final static int charBit[] = { 0x8000, 0x4000, 0x2000, 0x1000, 0x0800,
			0x0400, 0x0200, 0x0100, 0x0080, 0x0040, 0x0020, 0x0010, 0x0008,
			0x0004, 0x0002, 0x0001 };

//	public static byte[] getBytes(String str){
//		
//	}
	/**
	 * 获得整数i的二进制形式的第index位的值
	 * 
	 * @param i
	 * @param index
	 * @return 1/0
	 */
	public static int getBitAt(int i, int index) {
		if (index < 0 || index > 31)
			return -1;
		if (intBit[index] == (intBit[index] & i))
			return 1;
		else
			return 0;
	}

	/**
	 * 获得字符ch的二进制形式的第index位的值
	 * 
	 * @param ch
	 * @param index
	 * @return 1/0
	 */
	public static int getBitAt(char ch, int index) {
		if (index < 0 || index > 31)
			return -1;
		if (charBit[index] == (charBit[index] & ch))
			return 1;
		else
			return 0;
	}

	/**
	 * 设置整数i的二进制形式的第index位，具体的设置值由bit指定
	 * 
	 * @param i
	 * @param index
	 * @param bit
	 *            指定位要设置的值，只能是0或1
	 * @return 设置了指定位后的值
	 */
	public static int setBitAt(int i, int index, int bit) {
		if (index < 0 || index > 31)
			return -1;
		if (bit == 0)
			return i & (~intBit[index]);
		else if (bit == 1)
			return i | intBit[index];
		else
			return -1;
	}

	/**
	 * 设置字符ch的二进制形式的第index位，具体的设置值由bit指定
	 * 
	 * @param i
	 * @param index
	 * @param bit
	 *            指定位要设置的值，只能是0或1
	 * @return 设置了指定位后的值
	 */
	public static int setBitAt(char i, int index, int bit) {
		if (index < 0 || index > 31)
			return -1;
		if (bit == 0)
			return i & (~charBit[index]);
		else if (bit == 1)
			return i | charBit[index];
		else
			return -1;
	}

	/**
	 * 得到字符的二进制形式，用16位1或0表示
	 * 
	 * @param ch
	 * @return binary 二进制形式的数（字符串形式）
	 */
	public static String charToBinary(char ch) {
		// 注意，这里得到的二进制，都应该是16位二进制数
		// 但java默认是如果前面几位为0，则这几位将舍去
		// 因此，在这里，我们要把这舍去的几位0给加上
		String zero = "";
		String binary = Integer.toBinaryString(ch);
		if (binary.length() - 16 < 0) {
			for (int j = 0; j < 16 - binary.length(); j++) {
				zero += 0;
			}
		}
		binary = zero + binary;

		return binary;
	}

	/**
	 * 得到字符的16进制形式，用4位16进制数表示
	 * 
	 * @param ch
	 * @return 十六进制数（字符串形式）
	 */
	public static String charToHex(char ch) {
		return binaryToHex(charToBinary(ch));
	}

	/**
	 * 得到16进制整数的二进制字符串表示，整数的每位用4位二进制表示，如果不够4位，在前面补0
	 * 
	 * @param i
	 * @return binary 二进制形式的数（字符串形式）
	 */
	public static String intToBinary(int i) {
		String zero = "";
		String binary = Integer.toBinaryString(i);
		if (binary.length() % 4 != 0) {
			for (int j = 0; j < 4 - binary.length() % 4; j++) {
				zero += 0;
			}
		}
		binary = zero + binary;

		return binary;
	}

	/**
	 * 得到整数的16进制字符串表示，得到的字符串共8位，如果一个整数不够表示成8位，则前面补0
	 * 
	 * @param i
	 * @return binary 二进制形式的数（字符串形式）
	 */
	public static String intToHex(int i) {
		String zero = "";
		String hex = Integer.toHexString(i);
		if (hex.length() % 8 != 0) {
			for (int j = 0; j < 8 - hex.length(); j++) {
				zero += 0;
			}
		}
		hex = zero + hex;

		return hex;
	}

	/**
	 * 将16位2进制数（字符串形式）转换为它的值对应的字符
	 * 
	 * @param binary
	 * @return 对应的字符
	 */
	public static char binaryToChar(String binary) {
		return (char) Integer.parseInt(binary, 2);
	}

	/**
	 * 将4位16进制数（字符串形式）转换成它的值对应的字符
	 * 
	 * @param hex
	 * @return 对应的字符
	 */
	public static char hexToChar(String hex) {
		return (char) Integer.parseInt(hex, 16);
	}

	/**
	 * 1个16位二进制数（字符串形式）转换为4位16进制数（字符串形式）
	 * 
	 * @param binary
	 *            二进制数（字符串形式）
	 * @return 16进制数（字符串形式）
	 */
	public static String binaryToHex(String binary) {
		String hex = Integer.toHexString(Integer.parseInt(binary, 2));
		String zero = "";
		if (hex.length() - 4 < 0) {
			for (int j = 0; j < 4 - hex.length(); j++) {
				zero += 0;
			}
		}
		hex = zero + hex;
		return hex;
	}

	/**
	 * 1个4位16进制数（字符串形式）转换为16位二进制数（字符串形式）
	 * 
	 * @param hex
	 *            16进制数（字符串形式）
	 * @return 二进制数（字符串形式）
	 * 
	 */
	public static String hexToBinary(String hex) {
		String zero = "";
		String binary = Integer.toBinaryString(Integer.parseInt(hex, 16));
		if (binary.length() - 16 < 0) {
			for (int j = 0; j < 16 - binary.length(); j++) {
				zero += 0;
			}
		}
		binary = zero + binary;
		return binary;
	}

	/**
	 * 对binaryBlock进行循环左移i位的运算，移出的部分被放到右边
	 * 
	 * @param binaryBlock
	 * @param i
	 * @return 返回移位后的二进制字符串
	 */
	public static String shiftLeft(String binaryBlock, int i) {
		String shiftedBlock = "";
		shiftedBlock = binaryBlock.substring(i) + binaryBlock.substring(0, i);
		return shiftedBlock;
	}

	/**
	 * 对binaryBlock进行循环右移i位的运算，移出的部分被放到左边
	 * 
	 * @param binaryBlock
	 * @param i
	 * @return 返回移位后的二进制字符串
	 */
	public static String shiftRight(String binaryBlock, int i) {
		String shiftedBlock = "";
		int index = binaryBlock.length() - i;
		shiftedBlock = binaryBlock.substring(index)
				+ binaryBlock.substring(0, index);
		return shiftedBlock;
	}

	/**
	 * 对二进制字符串a，b进行与操作,前提是a，b长度相等，否则返回为null
	 * 
	 * @param a
	 * @param b
	 * @return 与后的二进制字符串
	 */
	public static String AND(String a, String b) {
		if (a.length() != b.length())
			return null;
		String str = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == 0 || b.charAt(i) == 0)
				str += '0';
			else
				str += '1';
		}
		return str;
	}

	/**
	 * 对二进制字符串a，b进行或操作,前提是a，b长度相等，否则返回为null
	 * 
	 * @param a
	 * @param b
	 * @return 或后的二进制字符串
	 */
	public static String OR(String a, String b) {
		if (a.length() != b.length())
			return null;
		String str = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == 0 && b.charAt(i) == 0)
				str += '0';
			else
				str += '1';
		}
		return str;
	}

	/**
	 * 对二进制字符串a进行非操作
	 * 
	 * @param a
	 * @return 取非后的二进制字符串
	 */
	public static String NOT(String a) {
		String str = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == 0)
				str += '1';
			else
				str += '0';
		}
		return str;
	}

	/**
	 * 对二进制字符串a，b进行异或操作,前提是a，b长度相等，否则返回为null
	 * 
	 * @param a
	 * @param b
	 * @return 异或后的二进制字符串
	 */
	public static String XOR(String a, String b) {
		if (a.length() != b.length())
			return null;
		String str = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				str += '1';
			else
				str += '0';
		}
		return str;
	}

}
