package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Certificado {
    private String nomeDev;
    private String tituloConteudo;
    private LocalDate dataConclusao;
    
    public Certificado(String nomeDev, String tituloConteudo) {
        this.nomeDev = nomeDev;
        this.tituloConteudo = tituloConteudo;
        this.dataConclusao = LocalDate.now();
    }

    @Override
    public String toString() {
    	return "-------------------------------\n" +
    		   "Certificado de Conclusão: \n" +
               "Desenvolvedor: " + nomeDev + "\n" +
               "Conteúdo: " + tituloConteudo + "\n" +
               "Data de Conclusão: " + dataConclusao + "\n" +
    		   "-------------------------------";
    }

}
