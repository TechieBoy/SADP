package businesslogic;

import java.util.ArrayList;
import java.util.Arrays;

public class StatCalc implements StatCalcInterface, CalcInterface {
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
    public float max(ArrayList<String> a) {
        float m = Float.MIN_VALUE;
        for (int i = 1; i < a.size(); i++) {
            float val = Float.valueOf(a.get(i));
            if(val > m)
                m = val;
        }
        return m;
    }

    @Override
    public float min(ArrayList<String> a) {
        float m = Float.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            float val = Float.valueOf(a.get(i));
            if(val < m)
                m = val;
        }
        return m;
    }

    @Override
    public float avg(ArrayList<String> a) {
        int len = a.size() - 1;
        float sum = 0;
        for (int i = 1; i < a.size(); i++) {
            sum += Float.valueOf(a.get(i));
        }
        return (sum / (float) len);
    }

    @Override
    public float sum(ArrayList<String> a) {
        float sum = 0;
        for (int i = 1; i < a.size(); i++) {
            sum += Float.valueOf(a.get(i));
        }
        return sum;
    }
}
