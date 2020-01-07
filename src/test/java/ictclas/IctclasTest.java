package ictclas;

import org.junit.*;
import utils.FileOperateUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
        String text = "缺陷单经办人：开发人员\n" +
                "注意！！！如果模块功能/原型不符合用户需求，开发人员和测试人员需要在需求评审会议上提出；如果开发过程中发现了此类情况，" +
                "要和产品单独沟通用户需求的问题，如果产品改而且变动比较大，产品提改进类型的需求单，不必提缺陷单！";
        Ictclas.getWordFreqStatForSpecificPos(text, new String[]{"n", "a"}, 2, 0);
    }

    @Test
    @Ignore
    public void testUserDict() throws Exception {
        URL dir = IctclasTest.class.getClassLoader().getResource("dicts");

        ArrayList files = FileOperateUtils.getAllFilesPath(new File(dir.toURI()));
        for (Object file : files) {
            Ictclas.importUserDict(file.toString(), false);
        }
    }

}
