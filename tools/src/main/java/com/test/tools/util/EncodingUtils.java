package com.test.tools.util;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.IOException;
import java.nio.charset.Charset;


public abstract class EncodingUtils {

	private static final int MINIMAL_CONFIDENCE_LEVEL = 70;

	public static String getAutoDecodedString(byte[] data, String defaultEncoding) throws IOException {
		return new String(data, detectEncoding(data, defaultEncoding));
	}

	public static String detectEncoding(byte[] data, String defaultEncoding) throws IOException {
		CharsetDetector detector = new CharsetDetector();
		detector.setText(data);
		CharsetMatch cm = detector.detect();
		String estimatedEncoding = cm.getName();
		boolean isReliable = Charset.isSupported(estimatedEncoding) && cm.getConfidence() >= MINIMAL_CONFIDENCE_LEVEL;
		return isReliable ? estimatedEncoding : defaultEncoding;
	}

	public static void main(String[] args) throws IOException{
		String testStr = "12345678ikbsdfghjklsd你好lzxcvbnm,.:LGF)(&^%^RYVG";
		String rtnStr = EncodingUtils.getAutoDecodedString(testStr.getBytes("UTF-8"), "UTF-8");
		System.out.println(rtnStr);

	}

}
