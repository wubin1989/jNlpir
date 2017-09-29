package ictclas;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sun.jna.Native;

import utils.ReadConfigUtil;

public class Ictclas {
		
	private static String soPath;
	private static String arguPath;
	
	static {
		soPath = ReadConfigUtil.getValue("ictclas.so.path");
		arguPath = ReadConfigUtil.getValue("ictclas.data.dir.path");
	}
	
	private static CLibrary Instance = (CLibrary) Native.loadLibrary(
			soPath,
			CLibrary.class);

	public static boolean init() {
		String argu = arguPath;
		int charset_type = 1;
		int init_flag = Instance.NLPIR_Init(argu, charset_type, "0");
		String nativeBytes = null;
		if (0 == init_flag) {
			nativeBytes = Instance.NLPIR_GetLastErrorMsg();
			System.err.println("Nlpir initialization failed! The reason is " + nativeBytes);
			return false;
		}
		return true;
	}

	public static void destroy() {
		Instance.NLPIR_Exit();
	}

	public static String processParagraph(String text) {
		String nativeBytes = null;
		nativeBytes = Instance.NLPIR_ParagraphProcess(text, 1);
		return nativeBytes;
	}
	
	public static void importUserDict(final String sFilePath, final boolean bOverwrite) {
        Ictclas.Instance.NLPIR_ImportUserDict(sFilePath, bOverwrite);
    }

	public static void addUserWord(String word) {
		Instance.NLPIR_AddUserWord(word);
	}

	public static void delUserWord(String word) {
		Instance.NLPIR_DelUsrWord(word);
	}

	public static String getKeyWords(String text) {
		String nativeByte = Instance.NLPIR_GetKeyWords(text, 10, false);
		return nativeByte;
	}

	public static String getFileKeyWords(String filePath) {
		String nativeByte = Instance.NLPIR_GetFileKeyWords(filePath, 10, false);
		return nativeByte;
	}

	public static String getWordFreqStat(String text) {
		String nativeByte = Instance.NLPIR_WordFreqStat(text);
		return nativeByte;
	}
	
	public static int getParagraphProcessAWordCount(final String text) {
        final int count = Ictclas.Instance.NLPIR_GetParagraphProcessAWordCount(text);
        return count;
    }

	public static Map.Entry<String, Integer>[] getWordFreqStatForSpecificPos(String text, String[] pos, int minLength,
			int top) {
		String nativeByte = Instance.NLPIR_WordFreqStat(text);
		if (nativeByte.length() != 0) {
			String[] wordStats = nativeByte.split("#");
			LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
			for (String wordStat : wordStats) {
				String[] stat = wordStat.split("/");
				if (stat.length < 3) {
					return null;
				}
				String word = stat[0];
				String _pos = stat[1];
				Integer freq = Integer.parseInt(stat[2]);
				List<String> posList = Arrays.asList(pos);
				if (posList.contains(_pos) && word.length() >= minLength) {
					lhm.put(word, freq);
				}
			}
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer>[] result = lhm.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toArray(size -> new Map.Entry[size]);
			if (top > 0) {
				result = Arrays.copyOfRange(result, 0, top);
			}
			return result;
		}
		return null;
	}

	public static String transString(String aidString, String ori_encoding, String new_encoding) {
		try {
			return new String(aidString.getBytes(ori_encoding), new_encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] encode(char[] charArray) {
		try {
			Charset charset = Charset.forName("UTF-8");
			CharsetEncoder encoder = charset.newEncoder();
			ByteBuffer bb = encoder.encode(CharBuffer.wrap(charArray));
			byte[] ba = new byte[bb.limit()];
			bb.get(ba);
			return ba;
		} catch (CharacterCodingException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
