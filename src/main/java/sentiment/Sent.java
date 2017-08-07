package sentiment;

import com.sun.jna.Native;

import utils.ReadConfigUtil;

public class Sent {
		
	private static String soPath;
	private static String arguPath;
	
	static {
		soPath = ReadConfigUtil.getValue("sent.so.path");
		arguPath = ReadConfigUtil.getValue("sent.data.dir.path");
	}
	
	private static CLibrarySentiment Instance = (CLibrarySentiment) Native.loadLibrary(soPath,
			CLibrarySentiment.class);

	public static boolean init() {
		String argu = arguPath;
		int charset_type = 1;
		if (!Instance.ST_Init(argu, charset_type, ""))
        {
			System.out.println(Instance.ST_GetLastErrorMsg());
            System.out.println("初始化失败");
            System.exit(1);
        }
        else
        {
            System.out.println("初始化成功");
        }
		return true;
	}

	public static void destroy() {
		Instance.ST_Exit();
	}
	
	public static double getSentimentPoint(final String text) {
        final double score = Instance.ST_GetSentimentPoint(text);
        return score;
    }
	
}
