package br.com.fiap.checkpoint1.main;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.checkpoint1.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.checkpoint1.entity.Funcionario;
import br.com.fiap.checkpoint1.entity.Produtividade;
import br.com.fiap.checkpoint1.exception.CommitException;
import br.com.fiap.checkpoint1.exception.IdException;
import br.com.fiap.checkpoint1.singleton.EntityManagerFactorySingleton;

public class Program {
	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		Funcionario funcionario = new Funcionario("Matheus", "489.444.136.00", 19,new BigDecimal(1000.0), true, Calendar.getInstance(), null, Produtividade.NORMAL);
		
		FuncionarioDaoImpl dao = new FuncionarioDaoImpl(em);
		

		try {
			dao.create(funcionario);
			dao.commit();
		}catch(CommitException e) {
			System.err.println(e.getMessage());
		}
		try {
			dao.findById(1);
		}catch(IdException e) {
			System.err.println(e.getMessage());
		}
		try {
			funcionario.setSalario(new BigDecimal(1500.0));
			dao.update(funcionario);
			dao.commit();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			dao.remove(3);
			dao.commit();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		//Fechar fabrica
		em.close();
		factory.close();
	}
}
