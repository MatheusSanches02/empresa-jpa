package br.com.fiap.checkpoint1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.checkpoint1.contracts.FuncionarioDao;
import br.com.fiap.checkpoint1.entity.Funcionario;

public class FuncionarioDaoImpl extends GenericDaoImpl<Funcionario, Integer> implements FuncionarioDao{

	public FuncionarioDaoImpl(EntityManager em) {
		super(em);
	}

}
