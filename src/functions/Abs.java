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
public class Abs extends UnaryOperation {
	
	public Abs(Operation op) {
		super(op);
	}
	
	public String toString(){
		return "|" + op.toString() + "|";
 	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Abs)) return false;
		Abs abs = (Abs) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 7 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Division(new Product(new Abs(op), op.getDerivative()), op);
        
    }
}
