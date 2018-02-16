package businesslogic;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixCalc implements MatMathInterface, CalcInterface {
    @Override
    public float calculate(String expr) {
        expr = expr.replaceAll("\\s", "");
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(expr.split("[(,)]")));
        switch (myList.get(0).toLowerCase()) {
            case "avg":
                return avg(myList);
            case "sum":
                return sum(myList);
            case "max":
                return max(myList);
            case "min":
                return min(myList);
        }
        return 0.0f;
    }

    @Override
    public ArrayList<ArrayList<Float>> add(ArrayList<ArrayList<Float>> a, ArrayList<ArrayList<Float>> b) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Float>> sub(ArrayList<ArrayList<Float>> a, ArrayList<ArrayList<Float>> b) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Float>> mul(ArrayList<ArrayList<Float>> a, ArrayList<ArrayList<Float>> b) {
        return null;
    }
}
