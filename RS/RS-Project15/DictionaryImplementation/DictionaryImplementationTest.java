package dictionarymanagement;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DictionaryImplementationTest {
    public final String FILENAME = "C:\\Users\\user39\\Downloads\\Meaning.json";
    DictionaryImplementation operation;

    @Before
    public void testAddDictionaryEntry() {
        operation = new DictionaryImplementation();
        operation.addDictionaryEntry(FILENAME);
    }

    @Test(expected = AssertionError.class)
    public void testGetValueOfKey() {
        operation = new DictionaryImplementation();
        assertEquals("Anger", operation.deleteDictionaryEntry("Fright"));
    }

    @Test
    public void testDeleteDromTreePanache() {
        operation = new DictionaryImplementation();
        assertEquals("Panache", operation.deleteDictionaryEntry("Panache"));
    }

    @Test
    public void testDeleteDromTreeUncanny() {
        operation = new DictionaryImplementation();
        assertEquals("Uncanny", operation.deleteDictionaryEntry("Uncanny"));
    }

    @Test
    public void testDeleteDromTreeFrown() {
        operation = new DictionaryImplementation();
        assertEquals("Frown", operation.deleteDictionaryEntry("Frown"));
    }

    @Test
    public void testGetValueOfKeyPanache() {
        operation = new DictionaryImplementation();
        assertEquals("Approved", operation.getValueOfKey("Panache"));
    }

    @Test
    public void testGetValueOfKeyFalseCase() {
        operation = new DictionaryImplementation();
        assertNotEquals("Quiet", operation.getValueOfKey("Frown"));
    }

    @Test
    public void testGetValueOfKeyFrown() {
        operation = new DictionaryImplementation();
        assertEquals("Anger", operation.getValueOfKey("Frown"));
    }

    @Test
    public void testSortKeyValue() {
        operation = new DictionaryImplementation();
        Map<String, String> tree = operation.sortDictionaryByKey();
        ArrayList<String> keyArray = new ArrayList<String>(Arrays.asList("Frown", "Panache", "Peace", "Uncanny"));
        ArrayList<String> dataArray = new ArrayList<String>(Arrays.asList("Anger", "Approved", "Quiet", "Normal"));
        int index = 0;
        for (String key : tree.keySet()) {
            assertEquals(keyArray.get(index), key);
            assertEquals(dataArray.get(index), tree.get(key));
            index++;
        }
    }

    @Test
    public void testSortKeyValueWithSpecifiedKey() {
        operation = new DictionaryImplementation();
        ArrayList<String> tree = operation.sortDictionaryWithKeyValueSpecified("Panache", "Unacnny");
        ArrayList<String> keyArray = new ArrayList<String>(Arrays.asList("Panache", "Peace", "Uncanny"));
        int index = 0;
        for (String key : tree) {
            assertEquals(keyArray.get(index), key);
            index++;
        }
    }
}
