final public class Poly {
    private int[] arrayOfDegree;
    private int[] arrayOfCoefficient;

    Poly() {
    }

    /**
     * initialises object of Poly
     * 
     * @param array of degree, array of coefficient
     */
    Poly(int[] degreeArray, int[] coefficientArray) {
        int countZeroCoefficient = 0;
        sortArray(degreeArray, coefficientArray);

        for (int i = 0; i < coefficientArray.length; i++) {
            if (coefficientArray[i] == 0) {
                countZeroCoefficient++;
            }
        }
        arrayOfDegree = new int[degreeArray.length - countZeroCoefficient];
        arrayOfCoefficient = new int[coefficientArray.length - countZeroCoefficient];
        int index = 0;
        for (int i = 0; i < (degreeArray.length - countZeroCoefficient); i++) {
            if (coefficientArray[i] != 0) {
                arrayOfDegree[i] = degreeArray[index];
                arrayOfCoefficient[i] = coefficientArray[index];
                index++;
            } else {
                index++;
            }
        }
    }

    public void sortArray(int degreeArray[], int coefficientArray[]) {
        for (int i = 0; i < degreeArray.length - 1; i++) {
            for (int j = 0; j < degreeArray.length - i - 1; j++) {
                if (degreeArray[j] < degreeArray[j + 1]) {
                    int swapValue = degreeArray[j];
                    int swapCoefficient = coefficientArray[j];
                    degreeArray[j] = degreeArray[j + 1];
                    coefficientArray[j] = coefficientArray[j + 1];
                    degreeArray[j + 1] = swapValue;
                    coefficientArray[j + 1] = swapCoefficient;
                }
            }
        }
    }

    /**
     * calculate degree of given polynomial
     * 
     */
    public int degree() {
        return this.arrayOfDegree[0];
    }

    public double evaluate(float variableValue) {
        double value = 0;
        for (int i = 0; i < this.arrayOfDegree.length; i++) {
            value = this.arrayOfCoefficient[i] * Math.pow(variableValue, (this.arrayOfDegree[i]));
        }
        return value;
    }

    /**
     * performs addition of two polynomials
     * 
     * @param firstPolynomial, secondPolynomial
     * @return added polynomial degree and coefficients
     */
    public int[][] addPolynomial(Poly firstPolynomial, Poly secondPolynomial) {
        int largeDegree;
        int degreeOfAddedPolynomial[];
        int coefficientOfAddedPolynomial[];
        if (firstPolynomial.degree() >= secondPolynomial.degree()) {
            largeDegree = firstPolynomial.degree();
        } else {
            largeDegree = secondPolynomial.degree();
        }
        largeDegree++;
        int[] degreeAdd = new int[largeDegree];
        for (int i = 0; i < largeDegree; i++) {
            degreeAdd[i] = 0;
        }
        for (int i = 0; i < firstPolynomial.arrayOfDegree.length; i++) {
            degreeAdd[firstPolynomial.arrayOfDegree[i]] = 1;
        }
        for (int i = 0; i < secondPolynomial.arrayOfDegree.length; i++) {
            degreeAdd[secondPolynomial.arrayOfDegree[i]] = 1;
        }
        int countDegree = 0;
        for (int i = 0; i < largeDegree; i++) {
            if (degreeAdd[i] == 1) {
                countDegree++;
            }
        }
        int[] addPolynomialDegree = new int[countDegree];
        int[] addPolynomialCoefficient = new int[countDegree];
        int firstPolynomialIndex = firstPolynomial.arrayOfDegree.length - 1;
        int secondPolynomialIndex = secondPolynomial.arrayOfDegree.length - 1;
        int p3Index = countDegree - 1;
        while (firstPolynomialIndex >= 0 && secondPolynomialIndex >= 0) {
            if (firstPolynomial.arrayOfDegree[firstPolynomialIndex] == secondPolynomial.arrayOfDegree[secondPolynomialIndex]) {
                addPolynomialDegree[p3Index] = firstPolynomial.arrayOfDegree[firstPolynomialIndex];
                addPolynomialCoefficient[p3Index] = firstPolynomial.arrayOfCoefficient[firstPolynomialIndex]
                        + secondPolynomial.arrayOfCoefficient[secondPolynomialIndex];
                firstPolynomialIndex--;
                secondPolynomialIndex--;
                p3Index--;
            } else if (firstPolynomial.arrayOfDegree[firstPolynomialIndex] < secondPolynomial.arrayOfDegree[secondPolynomialIndex]) {
                addPolynomialDegree[p3Index] = firstPolynomial.arrayOfDegree[firstPolynomialIndex];
                addPolynomialCoefficient[p3Index] = firstPolynomial.arrayOfCoefficient[firstPolynomialIndex];
                firstPolynomialIndex--;
                p3Index--;
            } else {
                addPolynomialDegree[p3Index] = secondPolynomial.arrayOfDegree[secondPolynomialIndex];
                addPolynomialCoefficient[p3Index] = secondPolynomial.arrayOfCoefficient[secondPolynomialIndex];
                secondPolynomialIndex--;
                p3Index--;
            }
        }
        while (firstPolynomialIndex >= 0) {
            addPolynomialDegree[p3Index] = firstPolynomial.arrayOfDegree[firstPolynomialIndex];
            addPolynomialCoefficient[p3Index] = firstPolynomial.arrayOfCoefficient[firstPolynomialIndex];
            firstPolynomialIndex--;
            p3Index--;
        }
        while (secondPolynomialIndex >= 0) {
            addPolynomialDegree[p3Index] = secondPolynomial.arrayOfDegree[secondPolynomialIndex];
            addPolynomialCoefficient[p3Index] = secondPolynomial.arrayOfCoefficient[secondPolynomialIndex];
            secondPolynomialIndex--;
            p3Index--;
        }
        int[][] addedPolynomial = new int[2][];
        addedPolynomial[0] = addPolynomialDegree;
        addedPolynomial[1] = addPolynomialCoefficient;
        return addedPolynomial;
    }

    /**
     * performs multiplication of two polynomials
     * 
     * @param firstPolynomial, secondPolynomial
     * @return multiplied polynomial degree and coefficients
     */
    public int[][] multiplyPolynomial(Poly firstPolynomial, Poly secondPolynomial) {
        int[] multiplyDegree = new int[firstPolynomial.arrayOfDegree.length * secondPolynomial.arrayOfDegree.length];
        int[] multiplyCoefficient = new int[firstPolynomial.arrayOfDegree.length * secondPolynomial.arrayOfDegree.length];
        int countDegree = 0;
        for (int i = 0; i < firstPolynomial.arrayOfDegree.length; i++) {
            for (int j = 0; j < secondPolynomial.arrayOfDegree.length; j++) {
                multiplyDegree[countDegree] = firstPolynomial.arrayOfDegree[i] + secondPolynomial.arrayOfDegree[j];
                multiplyCoefficient[countDegree] = firstPolynomial.arrayOfCoefficient[i] * secondPolynomial.arrayOfCoefficient[j];
                countDegree++;
            }
        }
        sortArray(multiplyDegree, multiplyCoefficient);
        int multiplyDegreeLength = multiplyDegree.length;
        for (int i = 1; i < multiplyDegreeLength; i++) {
            if (multiplyDegree[i] == multiplyDegree[i - 1]) {
                multiplyCoefficient[i - 1] += multiplyCoefficient[i];
                for (int j = i; j < multiplyDegree.length - 1; j++) {
                    multiplyDegree[j] = multiplyDegree[j + 1];
                    multiplyCoefficient[j] = multiplyCoefficient[j + 1];
                }
                multiplyDegreeLength--;
                i--;
            }
        }
        int index = 0;
        int[] multipliedPolynomialDegree = new int[multiplyDegreeLength];
        int[] multipliedPolynomialCoefficient = new int[multiplyDegreeLength];
        for (int i = 0; i < multiplyDegreeLength; i++) {
            multipliedPolynomialDegree[i] = multiplyDegree[index];
            multipliedPolynomialCoefficient[i] = multiplyCoefficient[index];
            index++;
        }
        int[][] multiplyPolynomial = new int[2][];
        multiplyPolynomial[0] = multipliedPolynomialDegree;
        multiplyPolynomial[1] = multipliedPolynomialCoefficient;
        return multiplyPolynomial;
    }
}
