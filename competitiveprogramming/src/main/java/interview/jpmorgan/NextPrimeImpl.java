package interview.jpmorgan;

public class NextPrimeImpl implements NextPrime {

    @Override
    public int nextPrime(int number) {
        if (number + 1 <= 0) {
            number = 0;
        }
        while (true) {
            number++;
            if (isPrime(number)) {
                return number;
            }

        }
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 2) return true;
        var numSqrt = Math.sqrt(num);
        for (int i = 2; i <= numSqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
