package ui;


import controller.CalcOps;

public class CalcUI {
    private String expr;

    public CalcUI(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public void runUI() {
        CalcOps c = new CalcOps();
        System.out.println(c.calc(expr));
    }
}
