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
public class Cos extends UnaryOperation {

	public Cos(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "cos(" + op.toString() + ")";
 	}

	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Cos)) return false;
		Cos abs = (Cos) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 29 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Negate(new Product(new Sin(op), op.getDerivative()));
    }

}

