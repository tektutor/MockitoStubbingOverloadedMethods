package org.tektutor;

public class DependentClass implements IDependentClass {

    public int overloadMethod( int x ) {
        System.out.println ("Overloaded Method that takes int ");
        return x + 5;
    }

    public double overloadMethod( double x ) {
        System.out.println ("Overloaded Method that takes double");
        return x + 10.0;
    }

}