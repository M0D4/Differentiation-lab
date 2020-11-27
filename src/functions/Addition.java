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
public class Addition extends BinaryOperation {

	public Addition(Operation left, Operation right) {
		super(left, right);
	}

	public Operation getLeft(){
		return left;
	}
	
	public Operation getRight(){
		return right;
	}
	
	@Override
	public String toString(){
		return left.toString() + "+" + right.toString();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Addition)) return false;
		Addition abs = (Addition) o;
		return (left.equals(abs.left) && right.equals(abs.right));
	}
	
	public int hashCode(){
		return 61 * (left.hashCode() + right.hashCode());
	}

    @Override
    public Operation getDerivative() {
        return new Addition(left.getDerivative(),right.getDerivative());
    }
}

