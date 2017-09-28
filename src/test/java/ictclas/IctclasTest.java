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
		String text = "setUp()和High5制霸青春	tearDown()胡咏梅方法也依赖@Before和@After标记，这样做的最大的好处是在继承体系内不必担心忘记了在setUp()方法中调用父类的super.setUp()方法，JUnit框架会自动处理父类的@Before和@After标记的方法。\n" + 
				"\n" + 
				"并且，JUnit框架对@Before和@After的调用顺序类似于类的构造方法和析构方法，即@Before按照父类到子类的顺序调用，@After则相反，这样保证了资源的正确获取和释放。\n" + 
				"\n" + 
				"当然，不再强迫必须使用setUp和tearDown作为方法名，可以使用更有意义的方法名，例如：initDatabase()和closeDatabase()，只要它们被标注了@Before和@After即可。";
		
		text = text.replaceAll("[^\\u4e00-\\u9fa5a-zA-Z\\d]", " ").trim();
		Map.Entry<String, Integer>[] stats = Ictclas.getWordFreqStatForSpecificPos(text, "n", 2, 0);
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
