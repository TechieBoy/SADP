package controller;

import model.SimpleCalc;
import view.CalcView;

public class CalcController {
    private SimpleCalc sCalc;
    private CalcView cUI;

    public CalcController(SimpleCalc s, CalcView c) {
        sCalc = s;
        cUI = c;
    }

    public void setExpr(String expr){
        sCalc.setExpr(expr);
    }

    public float getVal(){
        return sCalc.getResult();
    }

    public void updateView() {
        cUI.printValue(sCalc.calculate());
    }
}