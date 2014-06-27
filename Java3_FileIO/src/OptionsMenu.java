import java.util.Scanner;
import java.util.*;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;

public class OptionsMenu {
  
  String userInput;
  List<String> storedTextList = new ArrayList<String>();
  Scanner in = new Scanner(System.in);

public void start() {
  
  while(true) {
    System.out.println("Click in the Console," 
        + "\n then Enter a command: (choose)"
        + "\n E (then Enter) to Enter text"
        + "\n S (then Enter) to Save text"
        + "\n R (then Enter) to Read text"
        + "\n Q (then Enter) to Quit the program.");
    
    userInput = in.nextLine();
    checkInputs(userInput);
  }
}
    public void checkInputs(String command) {
      
    if(command.charAt(0) == 'E') {
      enterText();
    }
    
    else if(command.charAt(0) == 'S') {
      saveText();
    }
    
    else if(command.charAt(0) == 'R') {
      readText();
      System.out.println("Enter any key to go to options menu: ");
      String s = in.nextLine();
      if(s.length()!=0)
      start();
    }
    
    else if(command.charAt(0) == 'Q'){
      quit();
    }
    
    else {
      System.out.println("Invalid command.  Please enter either E, S, R, or Q.");
    }
    return;
  }
    
    public void enterText() {
      
      System.out.println("Enter text: ");
      String enteredText = in.nextLine();
      try {
        while ((enteredText != null) && (!enteredText.isEmpty())) {
          storedTextList.add(enteredText);
          enteredText = in.nextLine();
          System.out.println("\n");
        }
        
      }catch(Exception e) {
        System.err.println("Error: " + e.getMessage());
      }
      return; 
    }
    
    public void saveText() {
      
      System.out.println("Enter file name to save text: ");
      
      try {
        String fileName = in.nextLine();
        File myFile = new File(fileName + ".txt");
        
        FileWriter fStream = new FileWriter(myFile);

        for(String element : storedTextList) {
          fStream.write(element);
        }   
        fStream.close();
        
      } catch (Exception e) {
        System.err.println("Document did not save: " + e.getMessage());
      }
      System.out.println("Successful save.");
      return;
    }
    
    public void readText() {
      System.out.println("Enter file you wish to read: ");
      
      try {
        String fileName = in.nextLine();
        File myFile = new File(fileName + ".txt");
        
        FileReader fStream = new FileReader(myFile);
        BufferedReader br = new BufferedReader(fStream);

        String strLine;
        
        while((strLine = br.readLine()) != null) { 
          System.out.println(strLine);
        }
        br.close();
        fStream.close();
        
      } catch (Exception e) {
        System.err.println("Cannot open: " + e.getMessage());
      }
      return; 
    }
 
    public void quit() {
      System.out.println("Program terminated.");
      System.exit(0);
    }

  public static void main(String[] args) {
    new OptionsMenu().start();  
  }
}
