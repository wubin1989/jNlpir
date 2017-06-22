package code;

import com.sun.jna.Library;

public abstract interface CLibrary
  extends Library
{
  public abstract int NLPIR_Init(String paramString1, int paramInt, String paramString2);
  
  public abstract String NLPIR_ParagraphProcess(String paramString, int paramInt);
  
  public abstract String NLPIR_GetKeyWords(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract String NLPIR_GetFileKeyWords(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract int NLPIR_ImportUserDict(String paramString, boolean paramBoolean);
  
  public abstract int NLPIR_AddUserWord(String paramString);
  
  public abstract int NLPIR_DelUsrWord(String paramString);
  
  public abstract String NLPIR_GetLastErrorMsg();
  
  public abstract String NLPIR_WordFreqStat(String paramString);
  
  public abstract String NLPIR_FileWordFreqStat(String paramString);
  
  public abstract int NLPIR_GetParagraphProcessAWordCount(String paramString);
  
  public abstract void NLPIR_Exit();
}
