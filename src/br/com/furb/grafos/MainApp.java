package br.com.furb.grafos;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 03/04/2017
 * Classe responsável por executar as rotinas de validação do grafo
 */
public class MainApp {

	public static void main(String[] args) {
		int [][] values = {{0,1,0},{1,0,1},{0,1,0}};
		Grafo grafo = new Grafo();
		String typeGraph = grafo.tipoDeGrafo(values);
		System.out.println("Tipo Grafo:"+typeGraph);
		String arrestas = grafo.arestasDoGrafo(values);
		System.out.println("Arrestas:"+arrestas);
		String grau = grafo.grauDoVertice(values);
		System.out.println("Grau:"+grau);
	}
}
