package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso Lógica de Programação");
		curso1.setDescricao("Descrição Curso Lógica de Programação");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("Curso JavaScript");
		curso2.setDescricao("Descrição Curso JavaScript");
		curso2.setCargaHoraria(16);
		curso2.adicionarPreRequisito(curso1);
		
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Mentoria Java");
		mentoria.setDescricao("Descrição Mentoria Java");
		mentoria.setData(LocalDate.now());
		
//		System.out.println(curso1);
//		System.out.println(curso2);
//		System.out.println(mentoria);
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devDaniel = new Dev();
		devDaniel.setNome("Daniel");
		devDaniel.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos Daniel" + devDaniel.getConteudosInscritos());
//		devDaniel.progredir();
//		devDaniel.progredir();
		System.out.println("Conteúdos inscritos Daniel" + devDaniel.getConteudosInscritos());
		System.out.println("Conteúdos concluídos Daniel" + devDaniel.getConteudosConcluidos());
		System.out.println("XP: " + devDaniel.calcularTotalXp());
		System.out.println("Nível: " + devDaniel.verificarNivel());
		devDaniel.exibirCertificados();
		
		System.out.println("-------");
		
		Dev devJoao = new Dev();
		devJoao.setNome("João");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos João" + devJoao.getConteudosInscritos());
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
//		System.out.println("Conteúdos inscritos João" + devJoao.getConteudosInscritos());
//		System.out.println("Conteúdos concluídos João" + devJoao.getConteudosConcluidos());
//		System.out.println("XP: " + devJoao.calcularTotalXp());
//		System.out.println("Nível: " + devJoao.verificarNivel());
		System.out.println("-------");
		devJoao.exibirCertificados();
		
	}
}
