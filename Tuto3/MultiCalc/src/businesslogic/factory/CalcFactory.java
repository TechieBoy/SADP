package businesslogic.factory;

import businesslogic.CalcInterface;
import businesslogic.ScientificCalc;
import businesslogic.SimpleCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcFactory {

    public CalcInterface getAppropriateCalc(String expr) {
        Pattern p = Pattern.compile("sin|cos|tan");
        Matcher matcher = p.matcher(expr);
        if(matcher.find()) {
            System.out.println("Creating scientific calc");
            return new ScientificCalc();
        }
        System.out.println("Creating simple calc");
        return new SimpleCalc();
    }
}
