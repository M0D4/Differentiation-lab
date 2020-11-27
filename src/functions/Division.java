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
public class Division extends BinaryOperation {

	public Division(Operation left, Operation right) {
		super(left, right);
	}

        @Override
	public Operation getLeft(){
		return left;
	}
	
        @Override
	public Operation getRight(){
		return right;
	}
	
        @Override
	public String toString(){
		return "(" + left.toString() + ")/(" + right.toString() + ")";
	}

	
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Division)) return false;
		Division abs = (Division) o;
		return (left.equals(abs.left) && right.equals(abs.right));
	}
	
        @Override
	public int hashCode(){
		return 67 * (left.hashCode() + right.hashCode());
	}

    @Override
    public Operation getDerivative() {
    Operation num = new Subtraction(new Product(left.getDerivative(), right),
                new Product(left, right.getDerivative()));
    Operation den = new Pow(right, new Constant("2"));
    return new Division(num, den);
    }
}
