package cm;

import java.math.BigDecimal;

public class StaffCalc extends Calc{
    BigDecimal calculate(BigDecimal initialPrice)
    {
        BigDecimal maxPayable = new BigDecimal(16);

        //If initialPrice is less than 16, return initialPrice
        if (initialPrice.compareTo(maxPayable) <= 0)
        {
            return initialPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        // Else return the maximum payable of 16
        else
        {
            return maxPayable.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }
}
