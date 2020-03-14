package cm;

import java.math.BigDecimal;

//Calculate payment for management

public class ManagementCalc extends Calc{

    BigDecimal calculation(BigDecimal initialPrice){
        //If base cost is less than 3, payment should be 3
        if (initialPrice.compareTo(new BigDecimal(3)) <= 0) {
            BigDecimal cost = new BigDecimal(3);
            return cost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        //Otherwise, require regular payment
        else {
            return initialPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }
}
