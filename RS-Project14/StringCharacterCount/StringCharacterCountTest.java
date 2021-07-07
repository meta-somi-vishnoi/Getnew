package employee;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCharacterCountTest {

    @Test
    public void testWithCount10() {
        StringCharacterCount count = new StringCharacterCount();
        assertEquals(10, count.getCharacterCount("This is a dog."));
    }
    
    @Test
    public void testWithCount() {
        StringCharacterCount count = new StringCharacterCount();
        assertEquals(10, count.getCharacterCount("This is a dog."));
        assertEquals(14, count.getCharacterCount("We went Delhi by bus"));
        assertEquals(10, count.getCharacterCount("This is a dog."));
    }
    
    @Test
    public void testWithCount2() {
        StringCharacterCount count = new StringCharacterCount();
        assertEquals(11, count.getCharacterCount("Where is Radhs?"));
        assertEquals(16, count.getCharacterCount("Can we Go! Who is there?"));
    }
    
    @Test
    public void testWithCount3() {
        StringCharacterCount count = new StringCharacterCount();
        assertEquals(10, count.getCharacterCount("@  this man ##"));
    }

}
