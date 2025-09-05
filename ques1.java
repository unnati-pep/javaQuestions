// Create a class BankAccount with deposit/withdraw methods and test concurrency using threads.
public class ques1 {
    private double balance;
    //constructor
    public ques1(double bal){
        this.balance=bal;
    }
    public synchronized void deposit(double amt){
        balance+=amt;
        System.out.println(Thread.currentThread().getName()+" deposited: "+amt+". Balance: "+balance);
    }
    public synchronized void withdraw(double amt){
        if(balance>=amt){
            balance-=amt;
            System.out.println(Thread.currentThread().getName()+" withdrew: "+amt+". Balance: "+balance);
        }
        else{
            System.out.println("Not enough balance for"+Thread.currentThread().getName());
        }
    }
    public double getBalance(){
        return balance;
    }
    public static void main(String[] args){
        ques1 account=new ques1(100);
        Runnable depositTask=()->{
            for(int i=0;i<5;i++)
                account.deposit(100);
        };
        Runnable withdrawTask=()->{
            for(int i=0;i<5;i++)
                account.withdraw(150);
        };
        Thread t1=new Thread(depositTask,"Deposit Thread");
        Thread t2=new Thread(withdrawTask,"Withdraw Thread");
        t1.start();
        t2.start();
    }
}
