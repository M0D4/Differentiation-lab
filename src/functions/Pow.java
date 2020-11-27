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


public class Pow extends BinaryOperation {
	public Pow(Operation left, Operation right) {
		super(left,right);
	}

	public String toString(){
		return "(" + left.toString() + ")<STARTsup>(" + right.toString() + ")<ENDsup>";
 	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Pow)) return false;
		Pow abs = (Pow) o;
		return (left.equals(abs.left) && right.equals(abs.right));
	}
	
	public int hashCode(){
		return 71 * (left.hashCode() + right.hashCode());
	}

    @Override
    public Operation getDerivative() {
        Operation fTerm = new Pow(left, right);
        Operation sTerm = new Addition(new Product(right.getDerivative(), new Log(left)),new Division(new Product(right, left.getDerivative()),left)) ;
        return new Product(fTerm,sTerm);
    }
}
