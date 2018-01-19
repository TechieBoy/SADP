import java.util.Scanner;
import java.util.Stack;

public class Calci implements CalcInterface{
	//Addition
	public  float add(float a,float b){
		return a+b;
	}
	//Substration
	public  float subs(float a,float b){
		return a-b;
	}
	//Multiplication
	public  float mul(float a,float b){
		return a*b;
	}
	//Division
	public  float div(float a,float b){
		return a/b;
	}
	public  int priority(char c){
		if(c=='+' || c=='-')
			return 0;
		else if(c=='*' || c=='/')
			return 1;
		return -1;
	}
	public  boolean isNum(char c){
		if((int)(c-'0')>=0 && (int)(c-'0')<10 )
			return true;
		else return false;
	}
	public  boolean isOp(char c){
		if(c=='+' || c=='-' || c=='*' || c=='/')
			return true;
		else return false;
	}
	public  float calc(char c,float num1,float num2){
		switch(c){
			case '+' :return (add(num1,num2));
			case '*' :return (mul(num1,num2));
			case '/' :return (div(num1,num2));
			case '-' :return (subs(num1,num2));
			default:return -1;
		}
	}
	public  float infix(String expr){
		Stack<Float> stnum=new Stack<Float>();
		Stack<Character> stchar=new Stack<Character>();
		String num="";
		for(int i=0;i<expr.length();i++){
			char c=expr.charAt(i);
			char d;
			
			if(i+1<expr.length())
				d=expr.charAt(i+1);
			else 
				d='\0';
			if(isNum(c)){
				//System.out.println("iteration:"+i+"num:"+num);
				num+=c;
				if(!isNum(d)){
					stnum.push(Float.parseFloat(num));
					num="";
				}
			}
			else if(isOp(c)){
				while(true){
					char top;
					if(!stchar.empty())
						top=stchar.peek();
					else
						top='\0';
					if(isOp(top)){
						if(!(priority(c)>priority(top))){
							float num2=stnum.pop();
							char op=stchar.pop();
							float num1=stnum.pop();
							stnum.push(calc(op,num1,num2));
							
						}
						else{ 
							stchar.push(c);
							break;
						}
					}
					else{
							stchar.push(c);
							break;
					}
				}
			}
			else if(c=='(')
				stchar.push(c);
			else if(c==')'){
				while(!stchar.empty()){
					c=stchar.pop();
					if(c=='(')
						break;
					else if(isOp(c)){
						float num2=stnum.pop();
						float num1=stnum.pop();
						stnum.push(calc(c,num1,num2));
					}
				}
			}
						
		}
		while(!stchar.empty()){
			char c=stchar.pop();
			if(c=='(')
				break;
			else if(isOp(c)){
				float num2=stnum.pop();
				float num1=stnum.pop();
				stnum.push(calc(c,num1,num2));
			}
		}
		return stnum.pop();
	}
//	public static void main(String args[]){
//		System.out.println("Enter Expression :");
//		Scanner sc=new Scanner(System.in);
//		String expr=sc.next();
//		//System.out.println(expr);
//		System.out.println(infix(expr));
//		
//	}
}
