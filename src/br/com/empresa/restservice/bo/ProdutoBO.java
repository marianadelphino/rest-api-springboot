package br.com.empresa.restservice.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.empresa.restservice.entity.ProdutoEntity;

public class ProdutoBO {

	private static HashMap<Long, ProdutoEntity> banco = new HashMap<>();
	private static Long sequence = (long) 3;
	
	static{
		banco.put((long) 1, new ProdutoEntity((long) 1, "Celular", 100, 5));
		banco.put((long) 2, new ProdutoEntity((long) 2, "Telefone", 1000, 5));
		banco.put((long) 3, new ProdutoEntity((long) 3, "Tablet", 200, 5));
	}
	
	public void cadastrar(ProdutoEntity produto){
		produto.setCodigo(++sequence);
		banco.put(sequence, produto);
	}
	
	public List<ProdutoEntity> listar(){
		return new ArrayList<ProdutoEntity>(banco.values());
	}
	
	public void atualizar(ProdutoEntity produto){
		banco.put(produto.getCodigo(), produto);
	}
	
	public void remover(Long codigo){
		banco.remove(codigo);
	}
	
	public ProdutoEntity buscar(Long codigo){
		return banco.get(codigo);
	}
	
}
