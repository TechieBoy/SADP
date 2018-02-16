package main;

import controller.CalcController;
import model.SimpleCalc;
import view.CalcView;


public class Main {

    public static void main(String[] args) {
        SimpleCalc sc = getNewCalc();
        CalcView ui = new CalcView();

        CalcController controller = new CalcController(sc, ui);

        controller.updateView();
        controller.setExpr("987-98*76");
        controller.updateView();


    }

    private static SimpleCalc getNewCalc(){
        SimpleCalc sc = new SimpleCalc();
        sc.setExpr("(100-22*3)");
        return sc;
    }
}
