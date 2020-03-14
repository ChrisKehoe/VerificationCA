package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

import cm.CarParkKind;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MurphyKehoeChrisTestTask1 {
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

        Assert.assertEquals(testRate.calculate(Stay,kind) ,new BigDecimal(55));
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

    //-------------------normalPeriods and reducedRate Periods Tests------------------
    @Test(expected = NullPointerException.class)
    public void nullnormalPeriods() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = null;
        Period period2 = new Period(8, 12);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

        CarParkKind kind = CarParkKind.VISITOR;

        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }


    @Test(expected = IllegalArgumentException.class)
    public void nullreducedPeriods() {
        ArrayList<Period> normalPeriod = new ArrayList<Period>();
        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        Period period1 = new Period(0, 7);
        Period period2 = null;

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
        Period period2 = new Period(4, 9);

        normalPeriod.add(period1);
        reducedPeriod.add(period2);

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




}