
import java.util.Scanner;

public class SalesReport {
    int salespeople;
    int sum;
    int sales[];
    int newvalue;
    double average;
    
    Scanner scan = new Scanner(System.in);
    
    public SalesReport (int howMany) {
      this.salespeople = howMany;
      this.sales = new int[salespeople];
    }
    
    public SalesReport() {
      System.out.print("Enter the number of salespersons: ");
      
        this.salespeople = scan.nextInt();
        this.sales = new int[salespeople];
        
    }
     
    public void testMe() {
      getSalesInput();
      provideSalesOutput();
      findMax();
      findMinimum();
      computeAverage();
      newValue();
    }
    
    public void computeAverage() {
  
      average = (double) sum/salespeople;
      System.out.println("\nAverage sales: $" + average);
    
    }
    
    public void getSalesInput() {
      Scanner scan = new Scanner(System.in);
      
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
      System.out.println("\nTotal sales: $" + sum);
    }
    public void findMax() {
      int max = sales[0];
      int who = 0;
      for (int i=0; i<sales.length; i++) {
        if (max<sales[i]) {
          max=sales[i];
        who = i;
      }
      }
      System.out.println("\nSalesperson " + (who+1) + " had the highest sale with $" + max);
      }
    
    public void findMinimum() {
      int minimum = sales[0];
      int who = 0;
      for (int i=0; i<sales.length; i++) {
        if (minimum>sales[i]) {
          minimum=sales[i];
        who=i;
      }
      }
      System.out.println("\nSalesperson " + (who+1) + " had the lowest sale with $" + minimum);
}
    public void newValue() {
      int who = 0;
      int total = 0;
      Scanner scan = new Scanner(System.in);
        System.out.print("Enter new value: $");
        newvalue = scan.nextInt();
        for (int i=0; i<sales.length; i++) {
          
          if (sales[i]>newvalue) {
            salespeople=sales[i];
            who=i;
            System.out.println("\nSalesperson " + (who+1) + " exceeded the new value with $" + sales[i]);  
            total++;
        }
         
       
        }
        System.out.println("\nThe total number of salespeople that exceeded the new value is: " + total);
    }
   
    }
   




