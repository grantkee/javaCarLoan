public class CarLoan {
  int carLoan;
  int loanLength;
  int interestRate;
  int downPayment;


  // constructor
  public CarLoan(int loan, int duration, int apr, int initialPayment){
    carLoan = loan;
    loanLength = duration;
    interestRate = apr;
    downPayment = initialPayment;
  }

  public void calculatePayment(){
    if(loanLength <= 0 || interestRate <= 0){
      System.out.println("Error! You must take out a valid car loan.");
    } else if (downPayment >= carLoan){
      System.out.println("The car can be paid in full.");
    } else {
      int remainingBalance = carLoan - downPayment;
      int months = loanLength * 12;
      int monthlyBalance = remainingBalance / months;
      int interest = monthlyBalance * interestRate / 100;
      int monthlyPayment = monthlyBalance + interest;
      System.out.println(monthlyPayment);
    }
  }

  // main method
	public static void main(String[] args) {
    CarLoan max = new CarLoan(10000, 3, 5, 2000);
    max.calculatePayment();
	}
}
