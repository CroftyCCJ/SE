package TestTask;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {
    private int a;
    private int b;

    private int expectedResult;
    private int actualResult;

    Math math = new Math();

    @Test
    public void addition() {
        a = 5;
        b = 2;

        expectedResult = 7;
        actualResult = math.addition(a, b);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sub() {
        a = 5;
        b = 2;

        expectedResult = 3;
        actualResult = math.sub(a, b);

        Assert.assertEquals(expectedResult, actualResult);
    }
}