package id.nadiar.babynames_tests;

import id.nadiar.babynames.MiniProject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniProjectTest {
    private MiniProject miniProject;

    @Before
    public void setup() {
        miniProject = new MiniProject();
    }

    @Test
    public void testRunning() {
        String expected = "running!!";
        System.out.println("EXPECTED " + expected);
        assertEquals(expected, miniProject.running());
    }
}
