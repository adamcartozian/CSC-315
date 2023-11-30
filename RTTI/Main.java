package RTTI;

import java.util.ArrayList;

public class Main {
	
	public static void main (String[] args) {
	    Base pbase0 = new Base();
	    Base pbase1 = new Base();
	    Derived pderived = new Derived();
	    Base pbase2;
	    
	    if (pbase0 instanceof Derived) {
	    	System.out.println("pbase0 is a Derived");
	    }
	    else {
	    	System.out.println("pbase0 is not a Derived");
	    }
		   
		if (pderived instanceof Derived) {
	    	System.out.println("pbase0 is a Derived");
	    }
	    else {
	    	System.out.println("pbase0 is not a Derived");
	    }

		if (pderived instanceof Base) {
	    	System.out.println("pbase0 is a Base");
	    }
	    else {
	    	System.out.println("pbase0 is not a Base");
	    }
	}
    
    
    

}
