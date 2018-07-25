import static org.junit.Assert.*;

import org.junit.Test;


public class polynomial {

    @Test
    public void testPolynomial() {
        Poly firstPolynomial=new Poly(new int[]{4,1,0},new int[]{3,2,1});
        Poly secondPolynomial=new Poly(new int[]{0,3},new int[]{1,2});
        assertEquals(firstPolynomial.degree(),4);
        assertEquals(secondPolynomial.degree(),3);
        int[] addedPolynomialDegree=new int[]{4,3,1,0};
        int[] addedPolynomialCoefficient=new int[]{3,2,2,2};
        Poly thirdPolynomial=new Poly();
        assertEquals(firstPolynomial.evaluate(2),53);
        int addedResult[][]=thirdPolynomial.addPolynomial(firstPolynomial,secondPolynomial);
        assertArrayEquals(addedResult[0],addedPolynomialDegree);
        assertArrayEquals(addedResult[1],addedPolynomialCoefficient);
        int[] multiplyPolynomialDegree=new int[]{7,4,3,1,0};
        int[] multiplyPolynomialCoefficient=new int[]{6,7,2,2,1};
        int multiplyResult[][]=thirdPolynomial.multiplyPolynomial(firstPolynomial,secondPolynomial);
        assertArrayEquals(multiplyResult[0],multiplyPolynomialDegree);
        assertArrayEquals(multiplyResult[1],multiplyPolynomialCoefficient);
    }

}
