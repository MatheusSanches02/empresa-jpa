package br.com.fiap.checkpoint1.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.checkpoint1.contracts.GenericDao;
import br.com.fiap.checkpoint1.exception.CommitException;
import br.com.fiap.checkpoint1.exception.IdException;

public class GenericDaoImpl <E,K> implements GenericDao<E,K> {



	private EntityManager em;
	
	//Atributo que armazena o .cvlass da entidade
	private Class<E> clazz;

	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void create(E entity) {
		em.persist(entity);
	}

	public void update(E entity) throws IdException {
		//valida se o obj existe pra ser atualizado
		//findById(entity.getCodigo());
		em.merge(entity);
	}

	public void remove(K id) throws IdException {
		E entity = findById(id);
		em.remove(entity);
	}

	public E findById(K id) throws IdException{
			E entity = em.find(clazz, id); //Pesquisa o churros
			if(entity != null) //valida se a entidade existe
				return entity;
			throw new IdException(); //Se nao existir lançar exceção
		}
		

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
