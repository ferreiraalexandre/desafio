package br.com.desafio.exception;

public class ProductException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProductException(String msg) {
		super(msg);
	}

	public ProductException(String msg,Throwable t) {
		super(msg, t);
	}

	public ProductException(Throwable t) {
		super("Erro de Conexão", t);
	}
}
