package ictclas;

import com.sun.jna.Library;

public interface CLibrary extends Library {
	int NLPIR_Init(String paramString1, int paramInt, String paramString2);

	String NLPIR_ParagraphProcess(String paramString, int paramInt);

	String NLPIR_GetKeyWords(String paramString, int paramInt, boolean paramBoolean);

	String NLPIR_GetFileKeyWords(String paramString, int paramInt, boolean paramBoolean);

	int NLPIR_ImportUserDict(String paramString, boolean paramBoolean);

	int NLPIR_AddUserWord(String paramString);

	int NLPIR_DelUsrWord(String paramString);

	String NLPIR_GetLastErrorMsg();

	String NLPIR_WordFreqStat(String paramString);

	String NLPIR_FileWordFreqStat(String paramString);

	int NLPIR_GetParagraphProcessAWordCount(String paramString);

	void NLPIR_Exit();
}
