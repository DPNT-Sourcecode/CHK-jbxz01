package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkout;

    @Before
    public void setUp() {

        checkout = new CheckoutSolution();
    }

    @Test
    public void computeCheckout() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }
}
