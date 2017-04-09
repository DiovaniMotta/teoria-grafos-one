package br.com.furb.grafos.tipos;

import java.util.ArrayList;
import java.util.List;

public class TipoGrafoRegular implements TipoGrafo {

	private List<Integer> collections = new ArrayList<>();

	@Override
	public String tipoGrafo(int[][] matrix) {
		List<Integer> graus = new ArrayList<>();
		collections.clear();
		TipoGrafo grafo = new TipoGrafoMultigrafo();
		String aux = grafo.tipoGrafo(matrix);
		if (aux != null)
			return null;
		for (int x = 0; x < matrix.length; x++) {
			int grau = 0;
			for (int y = x; y < matrix.length; y++)
				grau += matrix[x][y];
			graus.add(grau);
		}
		collections.addAll(graus);
		for (Integer integer : graus) {
			boolean retorno = equals(integer);
			if (!retorno)
				return null;
		}
		return "Regular,";
	}

	protected boolean equals(Integer x) {
		for (Integer integer : collections)
			if (!integer.equals(x) || integer == 0)
				return false;
		return true;
	}

}
