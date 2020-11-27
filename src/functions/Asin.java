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
public class Asin extends UnaryOperation {

	public Asin(Operation op) {
		super(op);
	}
	
        @Override
	public String toString(){
		return "asin(" + op.toString() + ")";
 	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Asin)) return false;
		Asin abs = (Asin) o;
		return (op.equals(abs.op));
	}
	
        @Override
	public int hashCode(){
		return 13 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Division(op.getDerivative(), new Sqrt(new Subtraction(new Constant("1"), new Pow(op, new Constant("2")))));
    }
}

