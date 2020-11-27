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


public class Negate extends UnaryOperation {

	public Negate(Operation op) {
		super(op);
	}

	public String toString(){
		return "-" + op.toString();
 	}

	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Negate)) return false;
		Negate abs = (Negate) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 41 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Negate(op.getDerivative());
    }
}
