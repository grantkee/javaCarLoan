import java.text.DecimalFormat;

public class CarLoan {
  double carLoan;
  double loanLength;
  double interestRate;
  double downPayment;
  double creditScore;
  String cosigner;


  // constructor
  public CarLoan(double loan, double duration, double apr, double initialPayment, double credit){
    carLoan = loan;
    loanLength = duration;
    interestRate = apr;
    downPayment = initialPayment;
    creditScore = credit;
  }

  public void calculatePayment(){
    if(loanLength <= 0 || interestRate <= 0){
      System.out.println("Error! You must take out a valid car loan.");
    } else if (downPayment >= carLoan){
      System.out.println("The car can be paid in full.");
    } else if (creditScore <= 550 && cosigner == null){
      System.out.println("You will need a cosigner for this loan.");
    } else {
      double remainingBalance = carLoan - downPayment;
      double months = loanLength * 12;
      double monthlyBalance = remainingBalance / months;
      double interest = monthlyBalance * interestRate / 100;
      double monthlyPayment = monthlyBalance + interest;
      monthlyPayment = Math.round(monthlyPayment * 100);
      monthlyPayment = monthlyPayment / 100;
      System.out.println(monthlyPayment + " per month");
    }
  }

  // main method
	public static void main(String[] args) {
    CarLoan max = new CarLoan(10000, 3, 5, 2000, 555);
    max.calculatePayment();
	}
}
