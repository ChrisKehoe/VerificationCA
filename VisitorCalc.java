package cm;

import java.math.BigDecimal;

public class VisitorCalc  extends Calc {

    public BigDecimal calculation(BigDecimal initialPrice){
        BigDecimal finalPrice;

        //If baseCost < 8, final cost is free
        if (initialPrice.compareTo(new BigDecimal(8)) <= 0) {
            finalPrice = new BigDecimal(0);
        }
        //Else, finalCost is reduced by 8 and 50% discount on the remainder
        else {
            finalPrice = initialPrice.subtract(new BigDecimal(8));
            finalPrice = finalPrice.divide(new BigDecimal(2));
        }

        return finalPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

}
