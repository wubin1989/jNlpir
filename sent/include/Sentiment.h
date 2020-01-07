/****************************************************************************
 *
 * NLPIR Sentimental Analysis System Copyright (c) 2000-2015
 *     Dr. Kevin Zhang (Hua-Ping Zhang)
 *     All rights reserved.
 *
 * This file is the confidential and proprietary property of 
 * Kevin Zhang and the possession or use of this file requires 
 * a written license from the author.
 * Filename: 
 * Abstract:
 *          Sentiment.h: definition of the NLPIR Sentiment Analysis system API
 * Author:   Kevin Zhang 
 *          Email: pipy_zhang@msn.com kevinzhang@bit.edu.cn
 *			Weibo: http://weibo.com/drkevinzhang
 *			Homepage: http://www.nlpir.org
 * Date:     2013-12-19
 *
 * Notes:
 *                
 ****************************************************************************/
#ifndef SENTIMENTANALYSIS_H
#define SENTIMENTANALYSIS_H

#define ENCODING_GBK 0
#define ENCODING_UTF8 ENCODING_GBK+1
#define ENCODING_BIG5 ENCODING_GBK+2
#define ENCODING_GBK_FANTI ENCODING_GBK+3//GBK�а�������
#define ENCODING_FANTI_UTF8 ENCODING_GBK+4
#define ENCODING_COUNT 4


#ifdef __cplusplus
#define EXTERNC extern "C"
#else
#define EXTERNC 
#endif

#ifdef OS_LINUX
	#define ST_API EXTERNC 
#else
#ifdef ST_EXPORTS
#define ST_API EXTERNC __declspec(dllexport)
#else
#define ST_API EXTERNC __declspec(dllimport)
#endif
#endif

/*********************************************************************
 *
 *  Func Name  : ST_Init
 *
 *  Description: Init ST_Init
 *               The function must be invoked before any operation listed as following
 *
 *  Parameters : const char * sInitDirPath=NULL
 *				 sDataPath:  Path where Data directory stored.
 *				 the default value is NULL, it indicates the initial directory is current working directory path
 *				 encode: encoding code;
 *				 sLicenseCode: license code for unlimited usage. common user ignore it
 *  Returns    : success or fail
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2013-6-8
 *********************************************************************/
ST_API int ST_Init(const char * sDataPath, int encode, const char*sLicenceCode);
/*********************************************************************
 *
 *  Func Name  : ST_Exit
 *
 *  Description: Exist ST and free related buffer
 *               Exit the program and free memory
 *				 The function must be invoked while you needn't any lexical anlysis
 *
 *  Parameters : None
 *
 *  Returns    : success or fail
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2015-8-6
 *********************************************************************/
ST_API int ST_Exit();

/*********************************************************************
 *
 *  Func Name  : ST_GetOneObjectResult
 *
 *  Description: Get one object sentimental result
 *
 *  Parameters : sTitle: document title
 *               sContent: document content
 *               sObject: given an object, such as a product, a person or a brand
 *
 *  Returns    : const char * result buffer
 *               sample see  Appendix I:Sentimental analysis result sample
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2016-3-20
 *********************************************************************/
ST_API const char * ST_GetOneObjectResult(const char *sTitle, const char *sContent, const char *sObject);

/*********************************************************************
 *
 *  Func Name  : ST_GetMultiObjectResult
 *
 *  Description: Get multiple object sentimental result
 *
 *  Parameters : sTitle: document title
 *               sContent: document content
 *               sObjectRuleFile: see Appendix II: Multiple Object configure sample
 *
 *  Returns    : const char * result buffer
 *               sample see  Appendix I:Sentimental analysis result sample
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2016-3-20
 *********************************************************************/
ST_API const char * ST_GetMultiObjectResult(const char *sTitle, const char *sContent, const char *sObjectRuleFile);

/*********************************************************************
 *
 *  Func Name  : ST_GetSentimentPoint
 *
 *  Description: Get multiple object sentimental result
 *
 *  Parameters : sSentence: sentence memory
 *
 *  Returns    : const char * result buffer
 *               sample see  Appendix I:Sentimental analysis result sample
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2016-3-20
 *********************************************************************/
ST_API const char *  ST_GetSentencePoint(const char *sSentence);
/*********************************************************************
 *
 *  Func Name  : ST_GetSentimentPoint
 *
 *  Description: Get multiple object sentimental result
 *
 *  Parameters : sSentence: sentence memory
 *
 *  Returns    : double,Sentimental point
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2016-3-20
 *********************************************************************/
ST_API double ST_GetSentimentPoint(const char *sSentence);

/*********************************************************************
 *
 *  Func Name  : ST_ImportUserDict
 *
 *  Description: Import User-defined dictionary
 *  Parameters : 
 *				sFilename:Text filename for user dictionary 
 *				bOverwrite: true,  overwrite the existing dictionary 
 *						   false, add to  the existing dictionary 		
 *  Returns    : The  number of  lexical entry imported successfully
 *  Author     : Kevin Zhang
 *  History    : 
 *              1.create 2014-8-3
 *********************************************************************/
ST_API int ST_ImportUserDict(const char *sFilePath, int bOverwrite);
/*********************************************************************
 *
 *  Func Name  : ST_GetLastErrMsg
 *
 *  Description: Get Last ErrorMessage
 *    
 *
 *  Parameters : void
 *               
 *				  
 *  Returns    : the result buffer pointer 
 *
 *  Author     : Kevin Zhang  
 *  History    : 
 *              1.create 2014-2-27
 *********************************************************************/
ST_API const char * ST_GetLastErrMsg();

#endif
