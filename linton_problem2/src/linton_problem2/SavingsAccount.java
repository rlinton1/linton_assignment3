package linton_problem2;

public class SavingsAccount {
	
	//variable to store annual interest rate
    static private double annualInterestRate;
    private double savingBalance;

    //constructor method
    public SavingsAccount()
    {
        this.savingBalance = 0;
    }
    public SavingsAccount(double savingBalance)
    {
            this.savingBalance = savingBalance;
    }
    //Get saving balance
    public double getSavingBalance()
    {
            return this.savingBalance;
    }
    public double[] getMonthsSavingBalance(int total_months)
    {
              double[] monthlyI_month=new double[total_months];
            double monthlyI;
            for(int i = 0; i < total_months;i++)
            {
               monthlyI= (double)(this.savingBalance * annualInterestRate / 12);
               this.savingBalance += monthlyI;
               monthlyI_month[i] = this.savingBalance;
           }
            return monthlyI_month;
    }
    // Modify interest rate by setting annual interest rate to a new value
    public static void modifyInterestRate(double newInterestRate)
    {
            annualInterestRate = newInterestRate;
    }
    //Method to calculate monthly interest
    public void calculateMonthlyInterest()
    {
            double monthlyI;
            monthlyI= (double)(this.savingBalance * annualInterestRate / 12);
            this.savingBalance += monthlyI;
    }
    }