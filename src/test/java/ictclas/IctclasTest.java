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
		String text = "#那年花开月正圆#胡咏梅下毒终于被揭发！快乐开心然而网友们却跑到幸福网易考拉海购的广告里怒怼胡咏梅。。。"
				+ "求给胡咏梅下毒求让胡咏梅触电的弹幕刷满屏，只想说网友们真的入戏好深。默默#心疼下线的胡咏梅#3秒。L网易考拉海购的秒拍视频 ​​​​";
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
