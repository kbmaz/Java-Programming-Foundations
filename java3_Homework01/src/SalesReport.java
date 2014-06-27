
import java.util.Scanner;

public class SalesReport {
  int i;
  double average;
  int salespeople;
    int sum;
    int sales[];
    Scanner scan = new Scanner(System.in);
    
    public SalesReport() {
      System.out.print("Enter the number of salespersons: ");
        this.salespeople = scan.nextInt();
        this.sales = new int[salespeople];  
    }
    
    public void testMe() {
      getSalesInput();
      provideSalesOutput();
      computeAverage();
    }
    
    public void computeAverage() {
  
      average = (double) sum/salespeople;
      System.out.println("\nAverage sales: " + average);
    }
 
    public void getSalesInput() {
      
      for (int i=0; i<sales.length; i++) {
        System.out.print("Enter sales for salesperson " + (i+1) + ": ");
        sales[i] = scan.nextInt();
    }
    }
    
    public void provideSalesOutput() {
      System.out.println("\nSalesperson     Sales");
      System.out.println("----------------------");
      sum = 0;
      for (int i=0; i<sales.length; i++) {
        System.out.println("    " + (i+1) + "      " + sales[i]);
        sum = sum + sales[i];
      }
      System.out.println("\nTotal sales: " + sum);
      
      
    }

    
    
}
