package br.com.dio.desafio.dominio;

import java.util.HashSet;
import java.util.Set;

public class Curso extends Conteudo{
	//Atributos
	private int cargaHoraria;
	private Set<Curso> preRequisitos = new HashSet<>();
	
	@Override
	public double calcularXp() {
		// TODO Auto-generated method stub
		return XP_PADRAO + 80d;
	}
	
	public Curso() {
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Set<Curso> getPreRequisitos() {
        return preRequisitos;
    }

    public void adicionarPreRequisito(Curso curso) {
        preRequisitos.add(curso);
    }
	
	@Override
	public String toString() {
		StringBuilder preRequisitosTitulos = new StringBuilder();
		
		if(preRequisitos != null && !preRequisitos.isEmpty()) {
			for (Curso preRequisito : preRequisitos) {
				preRequisitosTitulos.append(preRequisito.getTitulo()).append(", ");
			}
			preRequisitosTitulos.setLength(preRequisitosTitulos.length() - 2);
		} else {
	        preRequisitosTitulos.append("Nenhum");
	    }
		return "Curso [titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", cargaHoraria=" + cargaHoraria +  ", Pré requisitos=" + preRequisitosTitulos + "]";
	}

	
}
