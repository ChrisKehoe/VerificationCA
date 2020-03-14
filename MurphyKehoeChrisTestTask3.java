package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

import cm.CarParkKind;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MurphyKehoeChrisTestTask3 {
    //Test calculate
    @Test
    public void successCalculate() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 8);
        Period period2 = new Period(9, 15);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);

        Period Stay = new Period(6,12);

        Assert.assertEquals(testRate.calculate(Stay,kind) ,new BigDecimal("13.50"));
    }

    @Test(expected = NullPointerException.class)
    public void NullcalculatePeriod() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);

        Period Stay = null;

        Assert.assertEquals(testRate.calculate(Stay,kind), new BigDecimal(15));
    }


    //Success Test
    @Test
    public void successfulTest() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 8);
        Period period2 = new Period(9, 13);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    //--------------------------------------cm.Rate Tests----------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void nullNormalRate() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 8);
        Period period2 = new Period(9, 13);


        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;

        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullReducedRate() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = null;

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minusNormalRate() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(5, 10);
        Period period2 = new Period(8, 15);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(-10);
        BigDecimal reducedRate = new BigDecimal(10);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minusReducedRate() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(5, 10);
        Period period2 = new Period(11, 15);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(-1);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }



    @Test(expected = IllegalArgumentException.class)
    public void normalRateLessReducedRate() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(10);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }


    //-------------------normalPeriods and reducedPeriods Tests------------------
    @Test(expected = IllegalArgumentException.class)
    public void nullnormalPeriods() {
        ArrayList<Period> normalPeriod = null;
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();


        Period period2 = new Period(8, 12);


        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }



    @Test(expected = IllegalArgumentException.class)
    public void nullreducedPeriods() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = null;

        Period period1 = new Period(0, 7);

        normalPeriod.add(period1);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalreducedPeriod() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 10);


        Period period5 = new Period(8, 12);
        Period period6 = new Period(10, 14);

        normalPeriod.add(period1);
        normalPeriod.add(period2);


        reducedPeriod.add(period5);
        reducedPeriod.add(period6);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalnormalPeriod() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(4, 8);


        Period period5 = new Period(9, 12);
        Period period6 = new Period(13, 14);

        normalPeriod.add(period1);
        normalPeriod.add(period2);


        reducedPeriod.add(period5);
        reducedPeriod.add(period6);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }



    @Test(expected = IllegalArgumentException.class)
    public void overlappingPeriodlist() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(7, 12);
        Period period2 = new Period(4, 9);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlappingPeriods() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(7, 12);
        Period period2 = new Period(10, 11);
        Period period3 = new Period(10, 12);
        Period period4 = new Period(8, 9);

        normalPeriod.add(period1);
        normalPeriod.add(period3);
        reducedPeriod.add(period2);
        reducedPeriod.add(period4);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlappingPeriodsandlength() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();




        Period period1 = new Period(9, 12);
        Period period2 = new Period(10, 15);
        Period period3 = new Period(10, 12);
        Period period4 = new Period(11, 12);
        Period period5 = new Period(10, 11);
        Period period6 = new Period(13, 14);


        normalPeriod.add(period1);
        normalPeriod.add(period3);
        normalPeriod.add(period5);
        reducedPeriod.add(period2);
        reducedPeriod.add(period4);
        reducedPeriod.add(period6);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void equalPeriodsandlength() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();


        Period period1 = new Period(0, 1);
        Period period2 = new Period(2, 3);
        Period period3 = new Period(4, 5);
        Period period4 = new Period(0, 1);
        Period period5 = new Period(2, 3);
        Period period6 = new Period(4, 5);

        normalPeriod.add(period1);
        normalPeriod.add(period2);
        normalPeriod.add(period3);
        reducedPeriod.add(period4);
        reducedPeriod.add(period5);
        reducedPeriod.add(period6);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }



    @Test(expected = IllegalArgumentException.class)
    public void startHourGreaterEndHourNormal() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(15, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void startHourGreaterEndHourReduced() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 9);
        Period period2 = new Period(13, 10);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void startHourZeroReduced() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(5, 7);
        Period period2 = new Period(-6, 3);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }


    @Test(expected = IllegalArgumentException.class)
    public void startHourZeroNormal() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(-5, 12);
        Period period2 = new Period(13, 16);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void EndHourGreater24Reduced() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 8);
        Period period2 = new Period(9, 27);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void endHourGreater24Normal() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(14, 27);
        Period period2 = new Period(0, 13);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    //------------------------------------Task Three Tests--------------------------------------------------------

    @Test
    public void calculateVisitorReducedRateTest() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(3);
        BigDecimal reduced = new BigDecimal(2);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1,6);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("3.50"));
    }

    @Test
    public void calculateFreeVisitorTest() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(2,4);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("0.00"));
    }
    //first 8 is free
    @Test
    public void calculateVisitorEightTest() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(2,5);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("0.00"));

    }

    @Test
    public void calculateManagementMin() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.MANAGEMENT;

        BigDecimal normal = new BigDecimal(1);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(9,10);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("3.00"));
    }

    @Test
    public void calculateManagementGreaterThanMin() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.MANAGEMENT;

        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1,4);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("6.00"));
    }

    @Test
    public void calculateStudentlessthanFiveFifty() {
        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        normalPeriod.add(period1);
        reducedPeriod.add(period2);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(1);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1,4);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("3.00"));
    }

    @Test
    public void calculateStudentFiveFifty() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2.75);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1, 3);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("5.50"));
    }

    @Test
    public void calculateStudentWithDiscount() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STUDENT;

        BigDecimal normal = new BigDecimal(4);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1, 6);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("16.38"));
    }

    @Test
    public void calculateStaffLessThanMax() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STAFF;

        BigDecimal normal = new BigDecimal(3);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1, 4);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("9.00"));
    }


    @Test
    public void calculateStaffGreaterThanMax() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1, 7);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("60.00"));
    }

    @Test
    public void calculateStaffMax() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.STAFF;

        BigDecimal normal = new BigDecimal(4);
        BigDecimal reduced = new BigDecimal(0);

        Rate testRate = new Rate(kind, normal, reduced, reducedPeriod, normalPeriod);
        Period periodStay = new Period(1, 5);

        assertEquals(testRate.calculate(periodStay,kind), new BigDecimal("16.00"));
    }

}
