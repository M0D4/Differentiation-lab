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
public class Atan extends UnaryOperation {

	public Atan(Operation op) {
		super(op);
	}

	public String toString(){
		return "atan(" + op.toString() + ")";
 	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Atan)) return false;
		Atan abs = (Atan) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 17 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Division(op.getDerivative(),
                new Addition(new Constant("1"), new Pow(new Cos(op),
                        new Constant("2"))));
    }
}
