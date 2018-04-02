public abstract class BinaryExpression extends UnaryExpression {

    protected Expression left;

    public BinaryExpression(Expression left, Expression right) {
        super(right);
        this.left = left;
    }
}