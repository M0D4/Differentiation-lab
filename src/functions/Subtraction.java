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

public class Subtraction extends BinaryOperation {

	public Subtraction(Operation left, Operation right) {
		super(left, right);
	}

	public Operation getLeft(){
		return left;
	}
	
	public Operation getRight(){
		return right;
	}
	
	public String toString(){
		return left.toString() + "-" + right.toString();
	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Subtraction)) return false;
		Subtraction abs = (Subtraction) o;
		return (left.equals(abs.left) && right.equals(abs.right));
	}
	
	public int hashCode(){
		return 79 * (left.hashCode() + right.hashCode());
	}

    @Override
    public Operation getDerivative() {
        return new Subtraction(left.getDerivative(),right.getDerivative());
    }
}
