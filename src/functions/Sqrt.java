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

public class Sqrt extends UnaryOperation {
	
	public Sqrt(Operation op) {
		super(op);
	}

        @Override
	public String toString(){
		return "sqrt(" + op.toString() + ")";
 	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Sqrt)) return false;
		Sqrt abs = (Sqrt) o;
		return (op.equals(abs.op));
	}
	
        @Override
	public int hashCode(){
		return 53 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Division(op.getDerivative()
                , new Product(new Constant("2"), new Sqrt(op)));
     }
}
