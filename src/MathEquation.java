public class MathEquation{
	
	private double leftVal;
	private double rightVal;
	private char opCode;
	private double result;
	
	private static int numberOfCalculations;
	private static double sumOfResults;
	
	
	
	public MathEquation() {}
	
	public MathEquation(char opCode) {
		this.opCode = opCode;
	}
	
	public MathEquation(char opCode, double leftVal, double rightVal) {
		this(opCode);
		this.leftVal = leftVal;
		this.rightVal = rightVal;
	}
	
	void execute() {
		switch(opCode){
	      case 'a':
	          setResult(leftVal + rightVal);
	          break;
	      case 's':
	          setResult(leftVal - rightVal);
	          break;
	      case 'm':
	          setResult(leftVal * rightVal);
	          break;
	      case 'd':
	          setResult(leftVal / rightVal);
	          break;
	      default:
	          System.out.println("Invalid opCode: " + opCode);
	          setResult(0.0d);
	          break;                
	    }
		
		numberOfCalculations++;
		sumOfResults += getResult();
	  
	}
	
	
	 void execute(double leftVal, double rightVal) {
		 this.leftVal = leftVal;
		 this.rightVal = rightVal;
		 
		 execute();
	 }
	 void execute(int leftVal, int rightVal) {
		 this.leftVal = leftVal;
		 this.rightVal = rightVal;
		 
		 execute();
		 result = (int)getResult();
	 }
	public static double getAverageResults() {
		
		return sumOfResults /  numberOfCalculations;
	}

	public double getRightVal() {
		return rightVal;
	}

	void setRightVal(double rightVal) {
		this.rightVal = rightVal;
	}

	public char getOpCode() {
		return opCode;
	}

	public void setOpCode(char opCode) {
		this.opCode = opCode;
	}

	public double getLeftVal() {
		return leftVal;
	}
	void setLeftVal(double leftVal) {
		this.leftVal = leftVal;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
}
