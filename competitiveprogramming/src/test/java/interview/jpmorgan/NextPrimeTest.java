package interview.jpmorgan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NextPrimeTest {
    NextPrime nextPrime;
    
    @BeforeEach
    void setup(){
        nextPrime=new NextPrimeImpl();
    }

    @Test
    public void whenValuePassedIs1ThenReturn2(){
        var nextPrimeNumber= nextPrime.nextPrime(1);
        Assertions.assertEquals(2,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIs2ThenReturn3(){
        var nextPrimeNumber= nextPrime.nextPrime(2);
        Assertions.assertEquals(3,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIs3ThenReturn5(){
        var nextPrimeNumber= nextPrime.nextPrime(3);
        Assertions.assertEquals(5,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIs5ThenReturn7(){
        var nextPrimeNumber= nextPrime.nextPrime(5);
        Assertions.assertEquals(7,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIs13ThenReturn17(){
        var nextPrimeNumber= nextPrime.nextPrime(13);
        Assertions.assertEquals(17,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIs0ThenReturn1(){
        var nextPrimeNumber= nextPrime.nextPrime(0);
        Assertions.assertEquals(1,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIsMaxIntegerThenThrowIllegalArgumentException(){
        var nextPrimeNumber= nextPrime.nextPrime(Integer.MAX_VALUE);
        Assertions.assertEquals(1,nextPrimeNumber);
    }

    @Test
    public void whenValuePassedIsNegativeThenReturn1(){
        var nextPrimeNumber= nextPrime.nextPrime(-10);
        Assertions.assertEquals(1,nextPrimeNumber);
    }

    @Test
    public void whenValuePassed1LessThanMaxIntegerThenThrowIllegalArgumentException(){
        var nextPrimeNumber= nextPrime.nextPrime(Integer.MAX_VALUE-1);
        Assertions.assertEquals(2147483647,nextPrimeNumber);
    }

}