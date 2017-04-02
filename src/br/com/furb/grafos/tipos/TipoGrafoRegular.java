package br.com.furb.grafos.tipos;

public class TipoGrafoRegular implements TipoGrafo {

	@Override
	public String tipoGrafo(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix.length; y++) {
				int size = (matrix.length - 1);
				int value = matrix[x][y];
				int grau = matrix[size - x][size - y];
				if (value != grau)
					return null;
			}
		}
		return "Regular,";
	}

}
