package br.com.empresa.restservice.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import br.com.empresa.restservice.entity.ProdutoEntity;
import br.com.empresa.restservice.exception.WebServiceException;
import br.com.empresa.restservice.repository.ProdutoRepository;

@ManagedBean
public class ProdutoBean {

	private ProdutoEntity produto;

	private List<ProdutoEntity> lista;

	private ProdutoRepository rep;

	@PostConstruct
	private void init() {
		produto = new ProdutoEntity();
		rep = new ProdutoRepository();
		try {
			lista = rep.listar();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}

	public void cadastrar() {

		FacesMessage msg;
		try {

			rep.cadastrar(produto);
			msg = new FacesMessage("Produto cadastrado!");
			lista = rep.listar();
			produto = new ProdutoEntity();
		} catch (WebServiceException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public ProdutoEntity getProdutoTO() {
		return produto;
	}

	public void setProdutoTO(ProdutoEntity produto) {
		this.produto = produto;
	}

	public List<ProdutoEntity> getLista() {
		return lista;
	}

	public void setLista(List<ProdutoEntity> lista) {
		this.lista = lista;
	}

}
