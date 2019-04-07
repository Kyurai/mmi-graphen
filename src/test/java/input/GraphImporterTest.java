package input;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphImporterTest {

    @Test
    public void test_extractValues_singleValue() {

        //given
        String line = "10";

        //when
        List<Integer> values = GraphImporter.extractValues(line);

        //then
        assertEquals(1, values.size());
        assertEquals(Integer.valueOf(10), values.get(0));
    }

    @Test
    public void test_extractValues_singleValue_withBlanks() {

        //given
        String line = "      10";

        //when
        List<Integer> values = GraphImporter.extractValues(line);

        //then
        assertEquals(1, values.size());
        assertEquals(Integer.valueOf(10), values.get(0));
    }

    @Test
    public void test_extractValues_mutlipleValues() {

        //given
        String line = "10      5";

        //when
        List<Integer> values = GraphImporter.extractValues(line);

        //then
        assertEquals(2, values.size());
        assertEquals(Integer.valueOf(10), values.get(0));
        assertEquals(Integer.valueOf(5), values.get(1));
    }

    @Test
    public void test_extractValues_mutlipleValues_withBlanks() {

        //given
        String line = "   10      5";

        //when
        List<Integer> values = GraphImporter.extractValues(line);

        //then
        assertEquals(2, values.size());
        assertEquals(Integer.valueOf(10), values.get(0));
        assertEquals(Integer.valueOf(5), values.get(1));
    }
}