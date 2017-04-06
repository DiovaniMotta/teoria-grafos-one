package br.com.furb.grafos;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.tipos.TipoGrafo;
import br.com.furb.grafos.tipos.TipoGrafoBipartido;
import br.com.furb.grafos.tipos.TipoGrafoCompleto;
import br.com.furb.grafos.tipos.TipoGrafoDirigido;
import br.com.furb.grafos.tipos.TipoGrafoMultigrafo;
import br.com.furb.grafos.tipos.TipoGrafoNaoDirigido;
import br.com.furb.grafos.tipos.TipoGrafoNulo;
import br.com.furb.grafos.tipos.TipoGrafoRegular;
import br.com.furb.grafos.tipos.TipoGrafoSimples;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 30/03/2017 Classe responsável por
 *         efetuar as validações cabíveis ao grafo que será processado
 *
 */
public class Grafo {

	private List<TipoGrafo> tipoGrafo = new ArrayList<>();

	protected void init() {
		tipoGrafo.add(new TipoGrafoBipartido());
		tipoGrafo.add(new TipoGrafoCompleto());
		tipoGrafo.add(new TipoGrafoDirigido());
		tipoGrafo.add(new TipoGrafoMultigrafo());
		tipoGrafo.add(new TipoGrafoNaoDirigido());
		tipoGrafo.add(new TipoGrafoNulo());
		tipoGrafo.add(new TipoGrafoRegular());
		tipoGrafo.add(new TipoGrafoSimples());
	}

	public Grafo() {
		init();
	}

	/**
	 * Qual é o tipo do grafo (dirigido ou não, simples ou multigrafo, regular,
	 * completo, nulo ou bipartido) nome do método: tipoDoGrafo parâmetro de
	 * entrada: matriz de adjacência retorno: String contendo o tipo do grafo
	 * 
	 * @return
	 */
	public String tipoDeGrafo(int[][] matrix) {
		StringBuilder stringBuilder = new StringBuilder();
		for (TipoGrafo tipoGrafo : tipoGrafo) {
			String retorno = tipoGrafo.tipoGrafo(matrix);
			if (retorno != null && !retorno.isEmpty())
				stringBuilder.append(retorno);
		}
		return stringBuilder.toString();
	}

	/**
	 * Quantas arestas esse grafo possui? Liste o conjunto de arestas. nome do
	 * método: arestasDoGrafo parâmetro de entrada: matriz de adjacência
	 * retorno: String com a quantidade e o conjunto de arestas
	 * 
	 * @return
	 */
	public String arestasDoGrafo(int[][] matrix) {
		int count = 0;
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix.length; y++) {
				int value = matrix[x][y];
				if (value != 0) {
					count++;
					builder.append("Aresta: " + x + "->" + y + ";");
					matrix[y][x] = 0;
				}
			}
		}
		StringBuilder parse = new StringBuilder();
		parse.append("Número de Arestas: " + count + "\n");
		parse.append(builder.toString());
		return parse.toString();
	}

	/**
	 * Qual é o grau de cada vértice. Liste a sequência de graus nome do método:
	 * grausDoVertice parâmetro de entrada: matriz de adjacência retorno: String
	 * identificando o grau de cada vértice e por fim, a sequência de graus
	 * 
	 * @return
	 */
	public String grauDoVertice(int[][] matrix) {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < matrix.length; x++) {
			int grau = 0;
			for (int y = x; y < matrix.length; y++)
				grau += matrix[x][y];
			builder.append("Vértice:" + x + ",Grau:" + grau + ";");
		}
		return builder.toString();
	}
}
