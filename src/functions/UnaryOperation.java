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

public abstract class UnaryOperation implements Operation {
         protected Operation op;
	
	public UnaryOperation(Operation op) {
		this.op = requireNonNull(op);
	}
	
	public Operation getOp(){
		return op;
	}
}