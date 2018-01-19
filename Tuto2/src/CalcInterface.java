
public interface CalcInterface {
	public float add(float a,float b);
	//Substration
	public float subs(float a,float b);
	//Multiplication
	public float mul(float a,float b);
	//Division
	public  float div(float a,float b);
	public  int priority(char c);
	public  boolean isNum(char c);
	public  boolean isOp(char c);
	public  float calc(char c,float num1,float num2);
}
