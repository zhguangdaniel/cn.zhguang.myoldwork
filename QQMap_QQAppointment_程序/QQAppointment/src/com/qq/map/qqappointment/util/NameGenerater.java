package com.qq.map.qqappointment.util;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NameGenerater {
    public static String generate(String name, String ext) throws NoSuchAlgorithmException {
        String date = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
        String hash = String.valueOf(Math.abs(name.hashCode()));
        hash = hash.length() < 5 ? hash : hash.substring(0, 4);
        StringBuffer ret = new StringBuffer();
        ret.append(date).append(hash).append(new Random().nextInt(999));
        if (ext.length() > 1) {
            ret.append(".").append(ext);
        } else {
            ret.append(".").append("jpg");
        }
        return ret.toString();
    }
}
