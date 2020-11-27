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

public class Sin extends UnaryOperation {

	public Sin(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "sin(" + op.toString() + ")";
 	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Sin)) return false;
		Sin abs = (Sin) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 47 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Product(new Cos(op),op.getDerivative());
    }
}

