package changer.model.entities;

public class ValoresModificados {
	String nome="";
	String valor="";


	public ValoresModificados(String nome, String valor) {
		this.nome = nome;
		this.valor = valor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("valoresModificados [nome=");
		builder.append(nome);
		builder.append(", valor=");
		builder.append(valor);
		builder.append("]");
		return builder.toString();
	}



}
