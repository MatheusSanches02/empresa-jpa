package br.com.fiap.checkpoint1.exception;

public class IdException extends Exception{
	
	public IdException() {
		super("Erro ao realizar commit");
	}
	
	public IdException(String msg) {
		super(msg);
	}
}
