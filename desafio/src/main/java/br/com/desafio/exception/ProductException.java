package br.com.desafio.exception;

import br.com.desafio.exception.MainException;

public class ProductException extends MainException {

	private static final long serialVersionUID = 1L;

	public ProductException() {
		this.generateObject("Produto existente.",
				"Gentileza informar um produto que não esteja cadastrada no sistema.");
	}
}
