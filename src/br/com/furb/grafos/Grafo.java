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
 * @author Diovani Bernardi da Motta Data: 30/03/2017 Classe respons�vel por
 *         efetuar as valida��es cab�veis ao grafo que ser� processado
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
	 * Qual � o tipo do grafo (dirigido ou n�o, simples ou multigrafo, regular,
	 * completo, nulo ou bipartido) nome do m�todo: tipoDoGrafo par�metro de
	 * entrada: matriz de adjac�ncia retorno: String contendo o tipo do grafo
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
	 * m�todo: arestasDoGrafo par�metro de entrada: matriz de adjac�ncia
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
		parse.append("N�mero de Arestas: " + count + "\n");
		parse.append(builder.toString());
		return parse.toString();
	}

	/**
	 * Qual � o grau de cada v�rtice. Liste a sequ�ncia de graus nome do m�todo:
	 * grausDoVertice par�metro de entrada: matriz de adjac�ncia retorno: String
	 * identificando o grau de cada v�rtice e por fim, a sequ�ncia de graus
	 * 
	 * @return
	 */
	public String grauDoVertice(int[][] matrix) {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < matrix.length; x++) {
			int grau = 0;
			for (int y = x; y < matrix.length; y++)
				grau += matrix[x][y];
			builder.append("V�rtice:" + x + ",Grau:" + grau + ";");
		}
		return builder.toString();
	}
}
