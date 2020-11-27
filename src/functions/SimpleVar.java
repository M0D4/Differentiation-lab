/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

/**
 *
 * @author Moustafa
 */


public class SimpleVar implements Operation {
	
	public String toString(){
		return "x";
 	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		return (o instanceof SimpleVar);
	}
	
	public int hashCode(){
		return 43;
	}

    @Override
    public Operation getDerivative() {
       return new Constant("1");
    }
}

