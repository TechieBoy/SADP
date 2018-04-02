
public class UnaryExpression implements Expression{
	protected Expression right;

    public UnaryExpression(Expression right) {
        this.right = right;
    }

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
