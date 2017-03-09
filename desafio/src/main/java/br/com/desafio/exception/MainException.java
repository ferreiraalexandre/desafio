package br.com.desafio.exception;

import br.com.desafio.util.ObjectException;

public class MainException extends Exception{

	private ObjectException object;
	
	private static final long serialVersionUID = 1L;

	public ObjectException getObject() {
		return object;
	}

	private void setObject(ObjectException object) {
		this.object = object;
	}
	
	protected void generateObject(String msg, String descricao){
		
		ObjectException object = new ObjectException();
		
		object.setMessage(msg);
		object.setDescription(descricao);
		
		this.setObject(object);
	}
}
