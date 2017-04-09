package br.com.furb.grafos;

/**
 * 
 * @author Diovani Bernardi da Motta
 * @author Ingmar de Aguiar
 * Data: 03/04/2017
 * Classe respons�vel por executar as rotinas de valida��o do grafo
 */
public class MainApp {

	public static void main(String[] args) {
		int [][] values = {{0,0,1,1,1},{0,0,1,1,1},{1,1,0,0,0},{1,1,0,0,0},{1,1,0,0,0}};
		Grafo grafo = new Grafo();
		String typeGraph = grafo.tipoDeGrafo(values);
		System.out.println("Tipo Grafo:"+typeGraph);
		//String arrestas = grafo.arestasDoGrafo(values);
		//System.out.println("Arrestas:"+arrestas);
		//String grau = grafo.grauDoVertice(values);
		//System.out.println("Grau:"+grau);
	}
}
