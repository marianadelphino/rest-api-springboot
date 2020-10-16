package br.com.empresa.restservice.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.empresa.restservice.entity.ProdutoEntity;
import br.com.empresa.restservice.exception.WebServiceException;


public class ProdutoRepository {

	private Client cliente = Client.create();

	private static final String URL = "http://localhost:8080/WebServiceREST-Server/produto/";

	public void remover(int codigo) throws WebServiceException {
		WebResource resource = cliente.resource(URL + codigo);
		ClientResponse response = resource.delete(ClientResponse.class);

		if (response.getStatus() != 204) {
			throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
	}

	public void atualizar(ProdutoEntity produto) throws WebServiceException {
		WebResource resource = cliente.resource(URL + produto.getCodigo());

		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, produto);

		if (response.getStatus() != 200) {
			throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
	}

	public ProdutoEntity buscar(int codigo) throws WebServiceException {
		WebResource resource = cliente.resource(URL + codigo);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
		// Recuperar o produto enviado pelo webservice
		ProdutoEntity produto = response.getEntity(ProdutoEntity.class);
		return produto;
	}

	public List<ProdutoEntity> listar() throws WebServiceException {
		WebResource resource = cliente.resource(URL);
		// Configura o tipo de dado que vamos receber e faz a requisição ao ws
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		// Valida se deu tudo certo
		if (response.getStatus() != 200) {
			throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
		// Recuperar os valores enviados ao webservice
		ProdutoEntity[] array = response.getEntity(ProdutoEntity[].class);
		// Retorna a lista de produtos
		return Arrays.asList(array);
	}

	public void cadastrar(ProdutoEntity produto) throws WebServiceException {
		WebResource resource = cliente.resource(URL);

		// Configura que tipo de dado será enviado e faz a requisição enviando o produto
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, produto);

		// Valida se deu certo.. se deu erro lança a exceção
		if (response.getStatus() != 201) {
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
	}

}
