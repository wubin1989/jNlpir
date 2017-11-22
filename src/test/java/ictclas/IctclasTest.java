package ictclas;

import static org.junit.Assert.*;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.FileOperateUtils;

public class IctclasTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Ictclas.init();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Ictclas.destroy();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFenci() throws IOException {
//		FileInputStream is = new FileInputStream(new File("/home/hadoop/workspace/jNlpir/test.txt"));
//		StringWriter writer = new StringWriter();
//		IOUtils.copy(is, writer, StandardCharsets.UTF_8.name());
//		String text = writer.toString().replaceAll("[^\\u4e00-\\u9fa5a-zA-Z\\d]", " ").trim();
//		int total=0;
//		for(int i=0; i<1000; i++){
//			long begin = System.nanoTime();
//			Ictclas.getWordFreqStatForSpecificPos(text, new String[]{"n", "a"}, 2, 0);
//			total += (System.nanoTime() - begin) / 1000000;
//		}
//		System.out.println(total / 1000);
//		if (stats != null) {
//			for (Map.Entry<String, Integer> stat : stats) {
//				System.out.println(stat.getKey() + " >> " + stat.getValue());
//			}
//		}
	}
	
	@Test
	public void testUserDict() throws Exception {
		URL dir = IctclasTest.class.getClassLoader().getResource("dicts");
		
		ArrayList files = FileOperateUtils.getAllFilesPath(new File(dir.toURI()));
		for(Object file : files) {
			Ictclas.importUserDict(file.toString(), false);
		}
	}

}
