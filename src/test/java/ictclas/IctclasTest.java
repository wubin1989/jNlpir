package ictclas;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

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
	public void testFenci() {
		String text = "'咔'点着一支烟，看着烟雾缭绕，男孩突然记起来​​​​";
		text = text.replaceAll("[^\\u4e00-\\u9fa5a-zA-Z\\d]", " ").trim();
		Map.Entry<String, Integer>[] stats = Ictclas.getWordFreqStatForSpecificPos(text, new String[]{"n", "a"}, 2, 0);
		if (stats != null) {
			for (Map.Entry<String, Integer> stat : stats) {
				System.out.println(stat.getKey() + " >> " + stat.getValue());
			}
		}
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
