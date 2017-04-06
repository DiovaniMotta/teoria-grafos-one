package br.com.furb.grafos.tipos;

public class TipoGrafoNaoDirigido implements TipoGrafo {

	@Override
	public String tipoGrafo(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix.length; y++) {
				int value = matrix[x][y];
				int inverse = matrix[y][x];
				if(value != inverse)
					return null;
			}
		}
		return "Não Dirigido,";
	}
}
