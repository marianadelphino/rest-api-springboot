package br.com.empresa.restservice.dao;

import java.util.List;

import br.com.empresa.restservice.entity.ProdutoEntity;

public interface ProdutoDAO extends GenericDAO<ProdutoEntity, Integer> {

	List<ProdutoEntity> listar();

}