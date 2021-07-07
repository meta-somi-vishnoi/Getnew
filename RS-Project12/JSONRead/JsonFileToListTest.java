package nestedlist;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class JsonFileToListTest {
    JSONReadFile integersList;
    public final String FILEINTEGER = "C:\\Users\\user39\\workspace\\NestedList\\src\\nestedlist\\Integers1.json";
    public final String JSONFILE = "C:\\Users\\user39\\workspace\\NestedList\\src\\nestedlist\\Integers2.json";
    public final String FILE = "C:\\Users\\user39\\workspace\\NestedList\\src\\nestedlist\\Integers3.json";
    public final String FILETEST = "C:\\Users\\user39\\workspace\\NestedList\\src\\nestedlist\\Integers4.json";

    @Before
    public void init() throws FileNotFoundException {
        integersList = new JSONReadFile();
        integersList.addList(FILEINTEGER);
        integersList.addList(JSONFILE);
        integersList.addList(FILE);
    }

    @Test
    public void addListTest() throws FileNotFoundException {
        assertTrue(integersList.addList(FILETEST));
    }

    @Test
    public void addAllIntegersTest() {
        assertEquals(206, integersList.addAllIntegers());
    }

    @Test
    public void largestIntegerTest() {
        assertEquals(576, integersList.largestInteger());
    }

    @Test
    public void searchElementTest() {
        assertTrue(integersList.searchList(22));
    }

    @Test
    public void addListWithNull() throws FileNotFoundException {
        try {
            integersList.addList(null);
        } catch (NullPointerException ex) {
            assertEquals("FileName Can't be Empty", ex.getMessage());
        }
    }

    @Test
    public void addListFileNotFound() {
        // Add a file which not exist
        try {
            integersList.addList("AddInteger.json");
        } catch (FileNotFoundException ex) {
            assertEquals("File not Found in addList", ex.getMessage());
        }
    }
}
