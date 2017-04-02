package br.com.furb.grafos.tipos;

public class TipoGrafoMultigrafo implements TipoGrafo {

	@Override
	public String tipoGrafo(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix.length; y++) {
				if (x == y) {
					int value = matrix[x][y];
					if (value != 0)
						return "Multigrafo,";
				}
			}
		}
		return null;
	}

}
