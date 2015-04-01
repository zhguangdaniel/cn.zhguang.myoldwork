package files;

import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NameGenerater {
	public static String generate(String name, String ext)
			throws NoSuchAlgorithmException {
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		Random ram = new Random();
		String ret = date + String.valueOf(Math.abs(name.hashCode()))
				+ ram.nextInt(999);
		if (ext.length() > 1)
			return ret + "." + ext;
		return ret;
	}
}
