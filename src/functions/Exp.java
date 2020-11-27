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
public class Exp extends UnaryOperation {
	
	public Exp(Operation op) {
		super(op);
	}

	public String toString(){
		return "e<STARTsup>(" + op.toString() + ")<ENDsup>";
 	}

	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Exp)) return false;
		Exp abs = (Exp) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 31 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Product(new Exp(op), op.getDerivative());
    }
}
