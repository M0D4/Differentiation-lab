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

public class Tan extends UnaryOperation {

	public Tan(Operation op) {
		super(op);
	}

	public String toString(){
		return "tan(" + op.toString() + ")";
 	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Tan)) return false;
		Tan abs = (Tan) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 59 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
       return new Division(op.getDerivative(), new Pow(new Cos(op), new Constant("2")));
    }
}
