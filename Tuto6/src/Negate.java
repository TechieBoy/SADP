public class Negate extends UnaryExpression {

    public Negate(Expression right) {
        super(right);
    }

    @Override
    public double calculate() {
        return -right.calculate();
    }
}