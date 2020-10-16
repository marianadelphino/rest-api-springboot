package br.com.empresa.restservice.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.restservice.bo.ProdutoBO;
import br.com.empresa.restservice.entity.ProdutoEntity;
import br.com.empresa.restservice.factory.EntityManagerFactorySingleton;

@RestController
@ManagedBean
public class ProdutoController {

	ProdutoBO bo = new ProdutoBO();
	
	@Autowired(required=false)
	private EntityManagerFactory fabrica= EntityManagerFactorySingleton.getInstance(); 

	@GetMapping("/produto")
	public List<ProdutoEntity> produto(@RequestParam(value = "name", defaultValue = "") String name) {
		return bo.listar();
	}

	@GetMapping(path = "/produto/{codigo}")
	public ProdutoEntity buscar(@PathVariable("codigo") Long codigo) {
		ProdutoEntity produto = bo.buscar(codigo);
		return produto;
	}

	@RequestMapping(path = "/produto/cadastrar", method = RequestMethod.POST)
	public void cadastrar(@Validated @RequestBody ProdutoEntity produto) {
		bo.cadastrar(produto);
	}

	@RequestMapping(path = "/produto/atualizar/{codigo}", method = RequestMethod.PUT)
	public void atualizar(@PathVariable("codigo") Long codigo, @Validated @RequestBody ProdutoEntity produto) {
		bo.atualizar(produto);
	}

	@RequestMapping(path = "/produto/remover/{codigo}", method = RequestMethod.DELETE)
	public void remover(@PathVariable("codigo") Long codigo) {
		bo.remover(codigo);
	}
}