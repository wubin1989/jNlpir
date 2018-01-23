package sentiment;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ictclas.Ictclas;

@Ignore
public class SentTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(Sent.init());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Sent.destroy();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String text = "'咔'点着一支烟，看着烟雾缭绕，男孩突然记起来";
//		text = text.replaceAll("[^\\u4e00-\\u9fa5a-zA-Z\\d]", " ").trim();
		System.out.println(Sent.getSentimentPoint(text));
	}

}
