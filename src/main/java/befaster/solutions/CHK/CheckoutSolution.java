package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        int[] numberOfItems = new int[6];

        for (int i = 0; i < skus.length(); i++)
        {
            Character character = skus.charAt(i);
            if (character < 65 || character > 70 )
                return -1;
            numberOfItems[character - 65]++;
        }

        //Process the new offer, for 2 of E you get 1 B free
        numberOfItems[1] = numberOfItems[1] - numberOfItems[4] / 2;
        if (numberOfItems[1] < 0 )
            numberOfItems[1] = 0;

        int totalCheckout = 0;
        //Adding the value of items A
        //First get the 5 items offer
        totalCheckout += (numberOfItems[0] / 5) * 200;
        int remainingAItems = numberOfItems[0] % 5;
        //Than the 3 items offer
        totalCheckout += (remainingAItems / 3 ) * 130;
        totalCheckout += (remainingAItems % 3 ) * 50;
        //Adding the value of items B
        totalCheckout += (numberOfItems[1] / 2) * 45;
        totalCheckout += (numberOfItems[1] % 2) * 30;
        //Adding the value of items C
        totalCheckout += numberOfItems[2] * 20;
        //Adding the value of items D
        totalCheckout += numberOfItems[3] * 15;
        //Adding the value of items E
        totalCheckout += numberOfItems[4] * 40;

        //Adding the value of items F
        totalCheckout += (numberOfItems[5] / 3) * 80; //80 = 2 * F, so we charge 3 items for the price of 2
        totalCheckout += (numberOfItems[5] % 3) * 40;

        return totalCheckout;
    }
}


