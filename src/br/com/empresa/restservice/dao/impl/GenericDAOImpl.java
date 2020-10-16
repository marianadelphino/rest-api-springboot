package br.com.empresa.restservice.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.empresa.restservice.dao.GenericDAO;
import br.com.empresa.restservice.exception.DBException;
import br.com.empresa.restservice.exception.IdNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	protected EntityManager em;

	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public void alterar(T entity) {
		em.merge(entity);
	}

	@Override
	public void remover(K codigo) throws IdNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null) {
			throw new IdNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(classe, codigo);
	}

	public void salvar() throws DBException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBException("Erro no commit", e);
		}
	}

}
