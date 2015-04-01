package files;

import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NameGenerater {
	public static String generate(String name, String ext)
			throws NoSuchAlgorithmException {
		String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		Random ram = new Random();
		String hash = String.valueOf(Math.abs(name.hashCode()));
		hash = hash.length() < 5 ? hash.substring(0, hash.length()) : hash
				.substring(0, 4);
		String ret = date + hash + ram.nextInt(999);
		if (ext.length() > 1)
			return ret + "." + ext;
		return ret;
	}
}
