import static org.junit.Assert.*;

import org.junit.Test;


public class IntSetTests {

    @Test
    public void testIsMemberTrue() {
        IntSet setIsMember = new IntSet(new int[] {2,4,7,1,8,3,5});
        assertTrue(setIsMember.isMember(7));
    }
    
    @Test
    public void testIsMemberFalse() {
        IntSet setIsMember = new IntSet(new int[] {33,41,67,1,77,3,50});
        assertFalse(setIsMember.isMember(44));
    }
    
    @Test
    public void testSizeShouldReturn7() {
        IntSet setSize = new IntSet(new int[] {33,41,67,1,77,3,50});
        assertEquals(setSize.size(),7);
    }
    
    @Test
    public void testSizeShouldNotReturn7() {
        IntSet setSize = new IntSet(new int[] {2,4,7,1,8,3,5,10,22,16});
        assertNotEquals(setSize.size(),7);
    }

    @Test
    public void testIsSubsetTrue() {
        IntSet set = new IntSet(new int[] {2,4,7,1,8,3,5});
        IntSet setSubset = new IntSet(new int[] {7,5,8});
        assertEquals(setSubset.isSubSet(set),true);
    }
    
    @Test
    public void testIsSubsetReturnTrue() {
        IntSet set = new IntSet(new int[] {12,44,67,21,8,33,95});
        IntSet setSubset = new IntSet(new int[] {21,44,95});
        assertEquals(setSubset.isSubSet(set),true);
    }
    
    @Test
    public void testIsSubsetFalse() {
        IntSet set = new IntSet(new int[] {33,41,67,1,77,3,50,22,16});
        IntSet setSubset = new IntSet(new int[] {7,1,8});
        assertEquals(setSubset.isSubSet(set),false);
    }
    
    @Test
    public void testComplementSetTrue() {
        IntSet set = new IntSet(new int[] {1,4,7});
        int[] actualComplement = {2,3,5,6,8,9,10};
        int[] exComplement=set.getComplement();
        assertArrayEquals(exComplement,actualComplement);
    }
    
    @Test
    public void testComplementSetFalse() {
        IntSet set = new IntSet(new int[] {1,4,8,3,7});
        int[] actualComplement = {2,3,5,6,8,9,10};
        int[] exComplement=set.getComplement();
        for(int i=0;i<actualComplement.length;i++) {
            assertNotEquals(exComplement[i],actualComplement[i]);
        }
    }
    
    @Test
    public void testUnionSetTrue() {
        IntSet setS1 = new IntSet(new int[] {1,4,7,9,2});
        IntSet setS2 = new IntSet(new int[] {2,6,8,9,10,5});
        IntSet setUnion = new IntSet();
        int[] actualUnion = new int[] {1,2,4,5,6,7,8,9,10};
        assertArrayEquals(setUnion.unionSet(setS1,setS2),actualUnion);
    }
    
    @Test
    public void testUnionSetFalse() {
        IntSet setS1 = new IntSet(new int[] {1,77,34,19,20});
        IntSet setS2 = new IntSet(new int[] {23,6,89,96,10,57});
        IntSet setUnion = new IntSet();
        int[] actualUnion = new int[] {1,2,4,5,6,7,8,9,10};
        assertArrayEquals(setUnion.unionSet(setS1,setS2),actualUnion);
    }
}
