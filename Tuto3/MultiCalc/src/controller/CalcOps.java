package controller;

import businesslogic.CalcInterface;
import businesslogic.factory.CalcFactory;

public class CalcOps {
    private CalcInterface sCalc;
    private CalcFactory factory;

    public CalcOps() {
        factory = new CalcFactory();
    }

    public float calc(String expr) {
        sCalc = factory.getAppropriateCalc(expr);
        return sCalc.calculate(expr);
    }
}