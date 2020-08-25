
package vella_thejosephusproblem;

import java.util.Scanner;

/****************************
 ***Class Name: TheJosephusProblem
 ***Author: Devin Vella
 ****************************
 ***Purpose: The purpose of this class is to allow the user to create a language
 ***consisting of the letters a and b by utilizing deterministic finite automation. 
 ***It does this by allowing the user to set the initial state, accepting state, 
 ***and the rule used to change states. The user can then test if a word is 
 ***accepted by the rules they set.
 **************************** 
 ***Date: 3/20/2019
 ****************************/
public class TheJosephusProblem 
{
    static int lastPerson(int n, int k)
    {
        //if there is only 1 person then the last person is the 1st person
        if(n == 1)
        {
            return 1;
        }
        
        //if there is more then 1 person use this formula to find last person
        else
        {
            return(lastPerson(n -1, k) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) 
    {
        int n = 0;
        int k = 0;
        boolean flag = false;
               
        Scanner scanner = new Scanner(System.in);
        
        //get number of people in the circle
        System.out.println("Enter number of people in the circle.");
        
        //loop until an integer is entered
        while(flag == false)
        {
            try
            {
                //save input to n
                n = Integer.parseInt(scanner.nextLine());
                
                //catch if user enters a negative integer
                if(n < 1)
                {
                    //error message
                    System.out.println("Please enter an integer that is greater than 0.");
                }
                else
                {
                    //brake loop
                    flag = true; 
                }                
            }
            catch(Exception e)
            {
               //error message
               System.out.println("Please enter an integer value.");
            }
        }
        
        //reset flag
        flag = false;
        
        //get the number of people skipped per turn
        System.out.println("Enter the number of people skipped per turn.");
        
        //loop until an integer is entered
        while(flag == false)
        {
            try
            {   
                //save input to k
                k = Integer.parseInt(scanner.nextLine());
                
                //catch if user enters a negative integer
                if(k < 1)
                {
                    //error message
                    System.out.println("Please enter an integer that is greater than 0.");
                }
                else
                {
                    //brake loop
                    flag = true; 
                } 
            }
            catch(Exception e)
            {
               //error message 
               System.out.println("Please enter an integer value.");
            }
        }
        
        System.out.println("");
        
        //display output
        System.out.println("Number of people in the circle: " + n);
        System.out.println("Number of people skipped per turn: " + k);
        
        if(lastPerson(n, k)%10 == 1)
        {
            System.out.println("The last person to be executed in the circle is the " + lastPerson(n, k) + "st person.");
        }
        else if(lastPerson(n, k)%10 == 2)
        {
            System.out.println("The last person to be executed in the circle is the " + lastPerson(n, k) + "nd person.");
        }
        else if(lastPerson(n, k)%10 == 3)
        {
            System.out.println("The last person to be executed in the circle is the " + lastPerson(n, k) + "rd person.");
        }
        else
        {
            System.out.println("The last person to be executed in the circle is the " + lastPerson(n, k) + "th person.");
        }
    }   
}