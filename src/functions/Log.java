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

public class Log extends UnaryOperation {
	
	public Log(Operation op) {
		super(op);
	}

	public String toString(){
		return "log(" + op.toString() + ")";
 	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Log)) return false;
		Log abs = (Log) o;
		return (op.equals(abs.op));
	}
	
	public int hashCode(){
		return 37 * op.hashCode();
	}

    @Override
    public Operation getDerivative() {
        return new Division(op.getDerivative(), op);
    }
}

