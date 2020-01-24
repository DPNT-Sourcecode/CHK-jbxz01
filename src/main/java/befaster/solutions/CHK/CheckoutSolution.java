package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int[] numberOfItems = new int[4];

        for (int i = 0; i < skus.length(); i++)
        {
            Character character = skus.charAt(i);
            if (character < 65 || character > 68 )
                return -1;
            numberOfItems[character - 65]++;
        }

        int totalCheckout = 0;

        System.out.println(skus);

        return -1;
    }
}


