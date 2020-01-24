package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

    static int[] PRICES = {50,30,20,15,40,10,20,10,35,60,70,90,15,40,10,50,30,50,20,20,40,50,20,17,20,21};

    public Integer checkout(String skus) {

        int[] numberOfItems = new int[26];

        for (int i = 0; i < skus.length(); i++)
        {
            Character character = skus.charAt(i);
            if (character < 65 || character > 90 )
                return -1;
            numberOfItems[character - 65]++;
        }

        //First the offers that impact multiple products
        //E offer
        numberOfItems['B' - 65] = numberOfItems['B' - 65] - numberOfItems['E' - 65] / 2;
        if (numberOfItems['B' - 65] < 0 )
            numberOfItems['B' - 65] = 0;

        //F offer
        numberOfItems['F' - 65] = numberOfItems['F' - 65] - numberOfItems['F' - 65] / 3;

        //N offer
        numberOfItems['M' - 65] = numberOfItems['M' - 65] - numberOfItems['N' - 65] / 3;
        if (numberOfItems['M' - 65] < 0 )
            numberOfItems['M' - 65] = 0;

        //R Offer
        numberOfItems['Q' - 65] = numberOfItems['Q' - 65] - numberOfItems['R' - 65] / 3;
        if (numberOfItems['Q' - 65] < 0 )
            numberOfItems['Q' - 65] = 0;

        //U offer
        numberOfItems['U' - 65] = numberOfItems['U' - 65] - numberOfItems['U' - 65] / 4;

        //They have all the same price so we could combine them
        numberOfItems['Y' - 65] += numberOfItems['S' - 65] + numberOfItems['T' - 65];
        numberOfItems['S' - 65] = 0;
        numberOfItems['T' - 65] = 0;



        int totalCheckout = 0;
        int remainingAItems;


        //The logic for the group of items of 45
        int groupTotal = numberOfItems['X' - 65] + numberOfItems['Y' - 65] + numberOfItems['Z' - 65];
        totalCheckout += (groupTotal / 3) * 45; //First we take care of the offers.
        int notInOfferItems = groupTotal % 3;

        //For X Y and Z we have a separate logic
        for (int i = 0; i < 23; i++)
        {
            char c = (char)(i + 65);
            switch (c)
            {
                case 'A':
                    totalCheckout += (numberOfItems[i] / 5) * 200;
                    remainingAItems = numberOfItems[i] % 5;

                    totalCheckout += (remainingAItems / 3 ) * 130;
                    totalCheckout += (remainingAItems % 3 ) * 50;
                    break;
                case 'B':
                    totalCheckout += (numberOfItems[i] / 2) * 45;
                    totalCheckout += (numberOfItems[i] % 2) * 30;
                    break;
                case 'H':
                    totalCheckout += (numberOfItems[i] / 10) * 80;
                    remainingAItems = numberOfItems[i] % 10;

                    totalCheckout += (remainingAItems / 5 ) * 45;
                    totalCheckout += (remainingAItems % 5 ) * 10;
                    break;
                case 'K':
                    totalCheckout += (numberOfItems[i] / 2) * 120;
                    totalCheckout += (numberOfItems[i] % 2) * 70;
                    break;
                case 'P':
                    totalCheckout += (numberOfItems[i] / 5) * 200;
                    totalCheckout += (numberOfItems[i] % 5) * 50;
                    break;
                case 'Q':
                    totalCheckout += (numberOfItems[i] / 3) * 80;
                    totalCheckout += (numberOfItems[i] % 3) * 30;
                    break;
                case 'V':
                    totalCheckout += (numberOfItems[i] / 3) * 130;
                    remainingAItems = numberOfItems[i] % 3;

                    totalCheckout += (remainingAItems / 2 ) * 90;
                    totalCheckout += (remainingAItems % 2 ) * 50;
                    break;
                default:
                    totalCheckout += numberOfItems[i] * PRICES[i];
            }
        }

        return totalCheckout;
    }
}



