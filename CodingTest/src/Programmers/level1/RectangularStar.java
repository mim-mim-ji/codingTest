package Programmers.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangularStar {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     int a = sc.nextInt();
	     int b = sc.nextInt();
	     
	     for(int i=0;i<b;i++) {
	    	 for(int j=0;j<a;j++) {
	    		 System.out.print("*");
	    	 }
	    	 System.out.println("");
	     }
     
	     ArrayList<String> matchMusic = new ArrayList<String>();
	    
	     String[] musicinfos = {"12:00","12:14","HELLO","CDEFGAB", 
					"13:00","13:05","WORLD","ABCDEF"};
	     
	     for(String str : musicinfos) {
	    	 
	    	 matchMusic.add(str);
	     }
	    	     
	     
	     System.out.println(matchMusic);
    	 System.out.println("===========");
    	 
	     
	     if(matchMusic.size()>0) {
	    	 String aa = matchMusic.get(0);
	    	 System.out.println(aa);
	     }
	     
	}

}
