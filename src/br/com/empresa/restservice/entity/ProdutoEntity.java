package br.com.empresa.restservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "seqProduto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduto")
	@Column(name = "CD_PRODUTO")
	private Long codigo;

	@Column(nullable = false, name = "NM_PRODUTO", length = 300)
	private String nome;

	@Column(nullable = false, name = "NR_PRECO")
	private double preco;

	@Column(nullable = false, name = "NR_QUANTIDADE")
	private int quantidade;

	public ProdutoEntity() {
		super();
	}

	public ProdutoEntity(Long codigo, String nome, double preco, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
