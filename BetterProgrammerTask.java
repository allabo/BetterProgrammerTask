/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja1;

import java.util.*;



/**
 *
 * @author ABogonosova
 */



public class BetterProgrammerTask {
    

    
    
    public static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
        boolean b = true; 
        int j = 0;
        for (int i=s.length(); i>(int)Math.ceil(s.length()/2); i--) {
            if ( s.substring(j,j+1).compareTo( s.substring(i-1,i) ) != 0 )
                b = false;
            j++;
        }         
    return b;    
    }    

	public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a set of elements that can be found only in set a or set b,
          but not in both Sets.
          The method should not change the content of the parameters.
         */
        Set<Object> out = new HashSet<Object>();
        boolean in;
        
        for (Object x: a) {
            in = false;
            for (Object y: b)
                if (x==y) in=true;
            if (!in) out.add(x);
        }

        for (Object x: b) {
            in = false;
            for (Object y: a)
                if (x==y) in=true;
            if (!in) out.add(x);
        }        
        
                
        return out;
    }   
	
	
	
	
	
	
	
	
	
	public static Object[] reverseArray(Object[] a) {
        /*
        Please implement this method to
        return a new array where the order 
        of elements has been reversed from 
        the original array.
        */
        int n = a.length;
        Object[] b = new Object[n];
        int j=n-1;
        for (int i=0; i<n; i++) {
            b[i]=a[j];
            j--;
        }               
    return b;    
    }   
      
	  
  
    
    public static String reverseWords(String s) {
        /*
          Assume that the parameter String can only contain spaces and alphanumeric characters.
          Please implement this method to
          reverse each word in the original String while maintaining the word order.
          For example:
          parameter: "Hello world", result: "olleH dlrow"
         */
        String temps=""; String results="";
        String[] exploded=s.split(" ");
        for (int k=0; k<exploded.length; k++) {
                temps=exploded[k];
                for (int j=temps.length()-1; j>=0; j--)
                    results=results+temps.substring(j,j+1); 
                if (k<exploded.length-1) 
                results=results+" ";
        }
        
    return results;  
    }
 
    public static int getSumOfNumbers(String s) {
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */
        int sum = 0;
        String[] sArr = s.split(" +");
        for (int i=0; i<sArr.length; i++) {
            if ( sArr[i].matches("[0-9]+") )
            sum = sum + Integer.parseInt(sArr[i]) ;
        }
        return sum;
    }


    public static void sortIgnoringSpaces(String[] a) {
        /*
          Please implement this method to
          sort a given array of Strngs in alphabetical order
          ignoring spaces (' ' symbols) within the strings.
         */
        String tempS ; 
        String firstS ; 
        int firstI;
        for (int i=0; i<a.length; i++) {            
            firstS = a[i].replace(" ", ""); 
            firstI = i;
            for (int j=i+1; j<a.length; j++)
                if ( firstS.compareTo(a[j].replace(" ", ""))>0 ) {
                    firstS=a[j].replace(" ", ""); 
                    firstI=j;
                }
            tempS = a[i];
            a[i] = a[firstI];
            a[firstI] = tempS;                    
        }
      
    }

    public static Change getCorrectChange(int allCents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.
         */
        int remainder = allCents;
        int mydollars=0, myquarters=0, mydimes=0, mynickels=0, mycents=0;        
        // first try
        if (allCents < 0) 
            return null;
        else {            
        while (remainder>100) {
            mydollars++;
            remainder -= 100;
        }
        while (remainder>25) {
            myquarters++;
            remainder -= 25;
        }
        while (remainder>10) {
            mydimes++;
            remainder -= 10;
        }
        while (remainder>5) {
            mynickels++;
            remainder -= 5;
        }   
        mycents = remainder; 
        //return new Change(mydollars, myquarters, mydimes, mynickels, mycents);
        }
        // second try
        mydollars=myquarters=mydimes=mynickels=mycents=0;                
        if (allCents < 0) 
            return null;
        else {    
        remainder = allCents;
        mydollars = (int) remainder / 100;
        remainder = (int)remainder % 100;   
        myquarters = (int) remainder / 25;
        remainder = (int)remainder % 25; 
        mydimes = (int) remainder / 10;
        remainder = (int)remainder % 10; 
        mynickels = (int) remainder / 5;
        remainder = (int)remainder % 5; 
        mycents = remainder; 
        return new Change(mydollars, myquarters, mydimes, mynickels, mycents);
        }         
    }


    // Please do not change this class
    static class Change {
        private final int _dollars;
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }  
    
    

    
    
    
 
    
    
    
}
