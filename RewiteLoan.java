
import java.util.Scanner;

public class RewiteLoan {

	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Enter yearly interest rate
		System.out.print("\nEnter yearly interest rate(EX : 8.25): ");
		double annualInterestRate = input.nextDouble();

		// Enter number of years
		System.out.print("\nEnter number of years as an integer: ");
		int numberOfYears = input.nextInt();

		// Enter loan amount
		System.out.print("\nEnter loan amount(EX : 120000.95): ");
		double loanAmount =  input.nextDouble();
		
		try {
			// Create Loan object
			new RewiteLoan(annualInterestRate, numberOfYears, loanAmount);
			
		}catch (Exception ex) {
			System.out.println(ex);
		}
		
		System.out.println("\nThank you for using the program.");
	}
	
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public RewiteLoan() {
		this(2.5, 1, 1000);
	}

	/** Construct a loan with specified annual interest rate,
		number of years and loan amount 
	*/
	public RewiteLoan(double annualInterestRate, int numberOfYears,	double loanAmount) {
		if (annualInterestRate <= 0) {
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		}
		
		if (numberOfYears <= 0) {
			throw new IllegalArgumentException("Number of years must be positive.");
		}
		
		if (loanAmount <= 0) {
			throw new IllegalArgumentException("Loan amount must be positive.");
		}
		
		setAnnualInterestRate(annualInterestRate);
		setNumberOfYears(numberOfYears);
		setLoanAmount(loanAmount);
		loanDate = new java.util.Date();
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate <= 0) {
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		}
		
		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears */
	public int getNumberOfYears() {
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears) {
		if (numberOfYears <= 0) {
			throw new IllegalArgumentException("Number of years must be positive.");
		}
		
		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}

	/** Set a newloanAmount */
	public void setLoanAmount(double loanAmount) {
		if (loanAmount <= 0) {
			throw new IllegalArgumentException("Loan amount must be positive.");
		}
		
		this.loanAmount = loanAmount;
	}

	/** Find monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
			(Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		return monthlyPayment;    
	}

	/** Find total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;    
	}

	/** Return loan date */
	public java.util.Date getLoanDate() {
		return loanDate;
	}
}
