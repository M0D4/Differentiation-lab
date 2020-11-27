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
public class Constant implements Operation {
	private String c;
	
	public Constant(String c) {
		this.c = c;
	}

	public String toString(){
		return c;
 	}

	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Constant)) return false;
		Constant abs = (Constant) o;
		return (c.equals(abs.c));
	}
	
	public int hashCode(){
		return 23 * (int) Double.parseDouble(c);
	}

    @Override
    public Operation getDerivative() {
        return new Constant("0");
    }
}

