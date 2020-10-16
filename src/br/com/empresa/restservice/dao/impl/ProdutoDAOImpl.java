package br.com.empresa.restservice.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.empresa.restservice.dao.ProdutoDAO;
import br.com.empresa.restservice.entity.ProdutoEntity;

public class ProdutoDAOImpl extends GenericDAOImpl<ProdutoEntity, Integer> implements ProdutoDAO {

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<ProdutoEntity> listar() {
		return em.createQuery("from ProdutoEntity", ProdutoEntity.class).getResultList();
	}

}