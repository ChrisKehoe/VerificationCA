package cm;

import java.math.BigDecimal;

public class StudentCalc extends Calc
{
    BigDecimal calculation(BigDecimal initialPrice)
    {
        BigDecimal normalAmountLimit = new BigDecimal("5.50");

        BigDecimal reduction = new BigDecimal("0.75");

        //If less than 5.50, return baseCost
        if (initialPrice.compareTo(normalAmountLimit) <= 0)
        {
            return initialPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        //Else, return the discounted price at 25% discount above 5.50
        else
        {
            return initialPrice.subtract(normalAmountLimit).multiply(reduction).add(normalAmountLimit).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }
}
