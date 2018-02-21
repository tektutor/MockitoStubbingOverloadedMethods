package org.tektutor;

public class MyClass {

    private DependentClass dependentObj;

    public MyClass() {
        this.dependentObj = new DependentClass();
    }

    public MyClass( DependentClass dependentObj ) {
        this.dependentObj = dependentObj;
    }

    public double methodUnderTest( double x ) {
        double result1 = dependentObj.overloadMethod( 5 );
        double result2 = dependentObj.overloadMethod( 10.0 );

        return result1 + result2;
    }

}