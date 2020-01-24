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
        //Adding the value of items A
        totalCheckout += (numberOfItems[0] / 3) * 130;
        totalCheckout += (numberOfItems[0] % 3) * 50;
        //Adding the value of items B
        totalCheckout += (numberOfItems[1] / 2) * 45;
        totalCheckout += (numberOfItems[1] % 2) * 30;
        //Adding the value of items C
        totalCheckout += numberOfItems[2] * 20;
        //Adding the value of items D
        totalCheckout += numberOfItems[3] * 15;

        return totalCheckout;
    }
}




