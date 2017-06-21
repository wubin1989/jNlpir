package code;

import com.sun.jna.Library;

public interface CLibrary extends Library {
	public int NLPIR_Init(String sDataPath, int encoding,
			String sLicenceCode);

	public String NLPIR_ParagraphProcess(String sText, int bPOSTagged);

	public String NLPIR_GetKeyWords(String sText, int nMaxKeyLimit,
			boolean bWeightOut);

	public String NLPIR_GetFileKeyWords(String sFilePath, int nMaxKeyLimit,
			boolean bWeightOut);

	public int NLPIR_AddUserWord(String sWord);// add by qp 2008.11.10

	public int NLPIR_DelUsrWord(String sWord);// add by qp 2008.11.10

	public String NLPIR_GetLastErrorMsg();
	
	public String NLPIR_WordFreqStat(String sText);
	
	public String NLPIR_FileWordFreqStat(String sFilePath);
	
	public abstract int NLPIR_GetParagraphProcessAWordCount(String paramString);
	
	public void NLPIR_Exit();
}