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
public class Acos extends UnaryOperation {

	public Acos(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "acos(" + op.toString() + ")";
 	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Acos)) return false;
		Acos abs = (Acos) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 11 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
       return new Negate(new Division(op.getDerivative(), new Sqrt(new Subtraction(new Constant("1"), new Pow(op, new Constant("2"))))));
    }
}

