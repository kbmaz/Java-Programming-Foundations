package salesIO;

import java.util.Scanner;
import utilities.SalesComputations;

public class SalesReport {
    
  int salespeople;
  int sum;
  int sales[];
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
    findMin();
    exceedsValue();
  }
 
  public void getSalesInput() {
    //Scanner scan = new Scanner(System.in); 
    for (int i=0; i<sales.length; i++) {
      System.out.print("Enter sales for salesperson " + (i+1) + ": ");
      sales[i] = scan.nextInt();
    }
  }
  
  public void provideSalesOutput() {
    System.out.println("\nSalesperson     Sales");
    System.out.println("----------------------");

    for (int i=0; i<sales.length; i++) {
      System.out.println("    " + (i+1) + "      " + sales[i]);
    }
    System.out.println("\nTotal sales: " + SalesComputations.computeSum(sales));
  }
  
  public void findMax() {
    System.out.println("\nSalesperson " + SalesComputations.findMaxIndex(sales) + " had the highest sale with $ " + SalesComputations.findMax(sales));
  }
  public void findMin() {
    System.out.println("\nSalesperson " + SalesComputations.findMinIndex(sales) + " had the lowest sale with $ " + SalesComputations.findMin(sales));
  }
  public void exceedsValue() {
    System.out.println("\nEnter value: ");
    int userVal = scan.nextInt();
    
    int[] exceedsValue = SalesComputations.exceedsValue(userVal, sales);
    int[] exceedsIndex = SalesComputations.exceedsIndex(userVal, sales);
    
    System.out.println("\nSalesperson     Sales");
    System.out.println("----------------------");
    
    for(int i = 0; i < sales.length; i++) {
      if(exceedsValue[i] != 0) {
        System.out.println("        " + exceedsIndex[i] + "        " + exceedsValue[i]);
      }
    }
  }
}


  
  
