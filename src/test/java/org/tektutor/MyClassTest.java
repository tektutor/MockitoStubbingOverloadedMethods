package org.tektutor;

import org.junit.Test;
import org.junit.Assert; 

import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;

public class MyClassTest {

    @Test
    public void testMethodUnderTest(){

        DependentClass mockedDependentObj = Mockito.mock( DependentClass.class );

        Answer<Integer> intAnswer =  new Answer<Integer>() {
                public Integer answer( InvocationOnMock invocation ) {
                    System.out.println ("Stubbed method - int");
                    return 10;
                }
        };
        
        Mockito.when(mockedDependentObj.overloadMethod(Mockito.anyInt()))
            .thenAnswer(intAnswer);

        Answer<Double> doubleAnswer =  new Answer<Double>() {
                public Double answer( InvocationOnMock invocation ) {
                    System.out.println ("Stubbed method - double");
                    return 20.0;
                }
        };
        Mockito.when(mockedDependentObj.overloadMethod(Mockito.anyDouble()))
            .thenAnswer(doubleAnswer);

        MyClass objectUnderTest = new MyClass( mockedDependentObj );

        Assert.assertEquals ( 30.0, objectUnderTest.methodUnderTest( 5 ), 0.001 );
    }

}