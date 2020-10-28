import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//performCalculations();
		
		//Divider divide = new Divider();
		//doCalculations(divide, 100.0d, 50.0d);
		
		//Adder add = new Adder();
		//doCalculations(add,  25.0d, 92.0d);
		
		//performMoreCalculations();
		executeInteractively();
	}
	
	static void executeInteractively() {
		System.out.println("Please enter a operation and two numbers: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		String [] parts = userInput.split(" ");
		performOperations(parts);
	}
	
	private static void performOperations(String[] parts) {
		MathOperations operation = MathOperations.valueOf(parts[0].toUpperCase());
		double leftVal = Double.parseDouble(parts[1]);
		double rightVal = Double.parseDouble(parts[2]);
		CalculateBase  calculation = createCalculations(operation, leftVal, rightVal);
		calculation.calculate();
		System.out.println("Operation performed: " + operation);
		System.out.println(calculation.getResult());
	}

	@SuppressWarnings("unused")
	private static CalculateBase createCalculations(MathOperations  operation, double leftVal, double rightVal ) {
		CalculateBase calculation = null;
		switch(operation) {
		  case ADD:
			  calculation = new Adder(leftVal, rightVal);
			  break;
		  case SUBTRACT:
			  calculation = new Subtractor(leftVal, rightVal);
			  break;
		  case MULTIPLY:
			  calculation = new Multiplier(leftVal, rightVal);
			  break;
		  case DIVIDE:
			  calculation = new Divider(leftVal, rightVal);
			  break;
		  
		}
		return calculation;
		}

	private static void performMoreCalculations() {
		CalculateBase [] cal = {
				new Divider(100.0d, 50.0d),
				new Adder(25.0d, 92.0d),
				new Multiplier(225.0d, 17.0d),
				new Subtractor(11.0d, 3.0d)
		};
		
		System.out.println();
		System.out.println("Array Calculations");
		
		for (CalculateBase calculations : cal) {
			calculations.calculate();
			System.out.println("results = " + calculations.getResult());
		}
		
	}

	static void performCalculations() {
		
		MathEquation [] equations = new MathEquation[4];
		
		equations[0] = new MathEquation('d', 100.0d, 50.0d);
		equations[1] = new MathEquation('a', 25.0d, 92.0d);
		equations[2] = new MathEquation('s', 225.0d, 17.0d);
		equations[3] = new MathEquation('m', 11.0d, 3.0d);
		
		for(MathEquation equation : equations) {
			equation.execute();
			System.out.println("results: " + equation.getResult());
		}
		
		System.out.println("Average results: " + MathEquation.getAverageResults());
			
	
		System.out.println();
		System.out.println("Using execute overloads");
		System.out.println();
		
		MathEquation equationOverload = new MathEquation('d');
		double left = 9.0d;
		double right = 4.0d;
		
		equationOverload.execute(left, right);
		System.out.println("overloaded results with doubles: " + equationOverload.getResult());
		
		int leftInt = 9;
		int rightInt = 4;
		equationOverload.execute(leftInt, rightInt);
		System.out.println("overloaded results with int: " + equationOverload.getResult());
		
	}
	
	
	static void doCalculations(CalculateBase cal, double leftVal , double rightVal) {
		
		cal.setLeftVal(leftVal);
		cal.setRightVal(rightVal);
		cal.calculate();
		
		System.out.println("Calculation Result: " + cal.getResult());
	}


	
	
}