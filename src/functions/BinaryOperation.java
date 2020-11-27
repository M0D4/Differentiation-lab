/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import static java.util.Objects.requireNonNull;

/**
 *
 * @author Moustafa
 */
public abstract class BinaryOperation implements Operation {
	 protected Operation left;
         protected Operation right;
	
	public BinaryOperation(Operation left, Operation right) {
		this.left = requireNonNull(left);
		this.right = requireNonNull(right);
	}
	
	public Operation getLeft(){
		return left;
	}
	
	public Operation getRight(){
		return right;
	}
}
