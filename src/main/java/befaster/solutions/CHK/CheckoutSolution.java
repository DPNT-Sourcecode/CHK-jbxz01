package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

    static int[] PRICES = {50,30,20,15,40,10,20,10,35,60,80,90,15,40,10,50,30,50,30,20,40,50,20,90,10,50};

    public Integer checkout(String skus) {

        int[] numberOfItems = new int[26];

        System.out.println(PRICES.length);

        for (int i = 0; i < skus.length(); i++)
        {
            Character character = skus.charAt(i);
            if (character < 65 || character > 90 )
                return -1;
            numberOfItems[character - 65]++;
        }

        //First the offers that impact multiple products
        //E offer
        numberOfItems[1] = numberOfItems[1] - numberOfItems[4] / 2;
        if (numberOfItems[1] < 0 )
            numberOfItems[1] = 0;

        //N offer
        numberOfItems[12] = numberOfItems[12] - numberOfItems[13] / 3;
        if (numberOfItems[12] < 0 )
            numberOfItems[12] = 0;

        //R Offer


        //Process the new offer, for 2 of E you get 1 B free


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
        totalCheckout += (numberOfItems[5] / 3) * 20; //80 = 2 * F, so we charge 3 items for the price of 2
        totalCheckout += (numberOfItems[5] % 3) * 10;

        return totalCheckout;
    }
}

