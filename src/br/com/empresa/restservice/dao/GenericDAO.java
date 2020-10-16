package br.com.empresa.restservice.dao;

import br.com.empresa.restservice.exception.DBException;
import br.com.empresa.restservice.exception.IdNotFoundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);

	void alterar(T entity);

	void remover(K codigo) throws IdNotFoundException;

	T pesquisar(K codigo);

	void salvar() throws DBException;

}
