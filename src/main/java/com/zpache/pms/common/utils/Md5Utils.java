package com.zpache.pms.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/16 16:43
 */
@Slf4j
public class Md5Utils {

    public static String md5(String plainText) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes = messageDigest.digest(plainText.getBytes());
            return Hex.encodeHexString(md5bytes).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            log.error("md5加密失败", e);
            throw new RuntimeException("md5加密失败");
        }
    }

}
