import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class polynomialTest {

    @Test
    public void testPolynomialDegreeWithReturnValue4() {
        Poly firstPolynomial = new Poly(new int[] { 4, 1, 0 }, new int[] { 3, 2, 1 });
        assertEquals(firstPolynomial.degree(), 4);     
    }
    
    @Test
    public void testPolynomialDegreeWithReturnValue7() {
        Poly firstPolynomial = new Poly(new int[] { 6, 7, 0, 3 }, new int[] { 2, 8, 1, 2 });
        assertEquals(firstPolynomial.degree(), 7); 
    }
    
    @Test
    public void testPolynomialDegreeWithFalseCase() {
        Poly firstPolynomial = new Poly(new int[] { 0, 2, 3 }, new int[] { 1, 2, 5 });
        assertNotEquals(firstPolynomial.degree(), 2); 
    }
    
    @Test
    public void testPolynomialDegreeWithReturnValue5() {
        Poly firstPolynomial = new Poly(new int[] { 5, 2, 3 }, new int[] { 1, 0, 5 });
        assertNotEquals(firstPolynomial.degree(), 2); 
    }

    @Test
    public void testPolynomialEvaluateWithReturnValue8() {
        Poly firstPolynomial = new Poly(new int[] { 0, 2, 3 }, new int[] { 1, 2, 5 });
        assertEquals(firstPolynomial.evaluate(1), 8, 0);     
    }
    
    @Test
    public void testPolynomialEvaluateWithReturnValue53() {
        Poly firstPolynomial = new Poly(new int[] { 4, 1, 0 }, new int[] { 3, 2, 1 });
        assertEquals(firstPolynomial.evaluate(2), 53, 0);   
    }
    
    @Test
    public void testPolynomialEvaluateWithReturnValue13() {
        Poly firstPolynomial = new Poly(new int[] { 6, 7, 0, 3 }, new int[] { 2, 8, 1, 2 });
        assertEquals(firstPolynomial.evaluate(1), 13, 0);   
    }
    
    @Test
    public void testPolynomialEvaluateWithFalseCase() {
        Poly firstPolynomial = new Poly(new int[] { 4, 1, 0 }, new int[] { 3, 2, 1 });
        assertNotEquals(firstPolynomial.evaluate(2), 12, 0);   
    }
    
    @Test
    public void testAddPolynomial() {
        Poly firstPolynomial = new Poly(new int[] { 4, 1, 0 }, new int[] { 3, 2, 1 });
        Poly secondPolynomial = new Poly(new int[] { 0, 3 }, new int[] { 1, 2 });
        int[] addedPolynomialDegree = new int[] { 4, 3, 1, 0 };
        int[] addedPolynomialCoefficient = new int[] { 3, 2, 2, 2 };
        Poly thirdPolynomial = new Poly();
        int addedResult[][] = thirdPolynomial.addPolynomial(firstPolynomial, secondPolynomial);
        assertArrayEquals(addedResult[0], addedPolynomialDegree);
        assertArrayEquals(addedResult[1], addedPolynomialCoefficient);
    }
    
    @Test
    public void testAddPolynomialFalseCase() {
        Poly firstPolynomial = new Poly(new int[] { 4, 1, 0 }, new int[] { 3, 2, 1 });
        Poly secondPolynomial = new Poly(new int[] { 0, 3 }, new int[] { 1, 2 });
        int[] addedPolynomialDegree = new int[] { 10, 1, 1, 0 };
        int[] addedPolynomialCoefficient = new int[] { 1, 2, 7, 2 };
        Poly thirdPolynomial = new Poly();
        int addedResult[][] = thirdPolynomial.addPolynomial(firstPolynomial, secondPolynomial);
        assertFalse(Arrays.equals(addedResult[0], addedPolynomialDegree));
        assertFalse(Arrays.equals(addedResult[1], addedPolynomialCoefficient));
    }
    
    @Test
    public void testMultiplyPolynomial() {
        Poly firstPolynomial = new Poly(new int[] { 4, 1, 0 }, new int[] { 3, 2, 1 });
        Poly secondPolynomial = new Poly(new int[] { 0, 3 }, new int[] { 1, 2 });
        Poly thirdPolynomial = new Poly();
        int addedResult[][] = thirdPolynomial.addPolynomial(firstPolynomial, secondPolynomial);
        int[] multiplyPolynomialDegree = new int[] { 7, 4, 3, 1, 0 };
        int[] multiplyPolynomialCoefficient = new int[] { 6, 7, 2, 2, 1 };
        int multiplyResult[][] = thirdPolynomial.multiplyPolynomial(firstPolynomial, secondPolynomial);
        assertArrayEquals(multiplyResult[0], multiplyPolynomialDegree);
        assertArrayEquals(multiplyResult[1], multiplyPolynomialCoefficient);
    }

    @Test
    public void testMultiplyPolynomialFalsecase() {
        Poly firstPolynomial = new Poly(new int[] { 7, 3, 1, 0 }, new int[] { 3, 0, 2, 1 });
        Poly secondPolynomial = new Poly(new int[] { 1, 2, 3 }, new int[] { 6, 8, 2 });
        Poly thirdPolynomial = new Poly();
        int addedResult[][] = thirdPolynomial.addPolynomial(firstPolynomial, secondPolynomial);
        int[] multiplyPolynomialDegree = new int[] { 7, 4, 3, 1, 0 };
        int[] multiplyPolynomialCoefficient = new int[] { 6, 7, 2, 2, 1 };
        int multiplyResult[][] = thirdPolynomial.multiplyPolynomial(firstPolynomial, secondPolynomial);
        assertFalse(Arrays.equals(multiplyResult[0], multiplyPolynomialDegree));
        assertFalse(Arrays.equals(multiplyResult[1], multiplyPolynomialCoefficient));
    }
}
