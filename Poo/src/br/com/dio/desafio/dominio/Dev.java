package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {
	//Atributos
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	private int nivel = 1;
	private static final int XP_POR_NIVEL = 100;
	private List<String> historicoDeProgresso = new ArrayList<>();
	private List<Certificado> certificados = new ArrayList<>();
	
	public double verificarNivel() {
		double xpTotal = calcularTotalXp();
		while(xpTotal >= XP_POR_NIVEL * nivel) {
			nivel++;
		}
		return nivel;
	}
	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if(conteudo.isPresent()) {
			if(conteudo.get() instanceof Curso) {
				Curso curso = (Curso) conteudo.get();
				if (verificarPreRequisitos(curso)) {
					this.conteudosConcluidos.add(conteudo.get());
					this.conteudosInscritos.remove(conteudo.get());
					registrarProgresso(curso.getTitulo());
					gerarCertificado(curso);
					System.out.println("Progresso realizado com sucesso na mentoria: " + curso.getTitulo() + " concluido em: " + LocalDate.now());
				} else {
					System.err.println("Pré-requisitos não atendidos para o curso: " + curso.getTitulo());
				}
			} else if(conteudo.get() instanceof Mentoria) {
				Mentoria mentoria = (Mentoria) conteudo.get();
				this.conteudosConcluidos.add(conteudo.get());
				this.conteudosInscritos.remove(conteudo.get());
				registrarProgresso(mentoria.getTitulo());
				gerarCertificado(mentoria);
				System.out.println("Progresso realizado com sucesso na mentoria: " + mentoria.getTitulo() + " concluido em: " + LocalDate.now());
			}
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}
	
//	Método para registrar o histórico de progresso
	private void registrarProgresso(String tituloConteudo) {
		LocalDate dataAtual = LocalDate.now();
		historicoDeProgresso.add("Conteúdo: " + tituloConteudo + " concluído em " + dataAtual);
	}
	
//  Método para exibir o histórico de progresso
    public void exibirHistorico() {
        if (historicoDeProgresso.isEmpty()) {
            System.out.println("Nenhum progresso registrado ainda.");
        } else {
            System.out.println("Histórico de Progresso:");
            historicoDeProgresso.forEach(System.out::println);
        }
    }
	
//	Método para gerar o certificado
	private void gerarCertificado(Conteudo conteudo) {
		Certificado certificado = new Certificado(this.nome, conteudo.getTitulo());
		certificados.add(certificado);
		System.out.println("Certificado gerado com sucesso: " + certificado);
	}
	
//	Método para exibir os certificados do Dev
	public void exibirCertificados() {
		if (certificados.isEmpty()) {
			System.out.println("Nenhum certificado gerado ainda.");
		} else {
			System.out.println("Certificados de conclusão:");
			certificados.forEach(System.out::println);
		}
	}
	
//	Método para verificar os pré requisitos dos cursos
	private boolean verificarPreRequisitos(Curso curso) {
		return conteudosConcluidos.containsAll(curso.getPreRequisitos());
	}
	
//	Método para calcular o XP do Dev
	public double calcularTotalXp() {
		return this.conteudosConcluidos
				.stream()
				.mapToDouble(Conteudo::calcularXp)
				.sum();
	}

//	Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}
	
	public int getNivel() {
		return nivel;
	}

//	Equals HashCode
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Dev dev = (Dev) o;
		return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
	}
	
	public int hashCode() {
		return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
	}
}
