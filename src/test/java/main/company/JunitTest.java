package main.company;

import main.java.com.company.CoinChangeProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTest {

    @Test
    public void test_Junit() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
        Assertions.assertFalse(coinChangeProblem ==null);
    }
}
