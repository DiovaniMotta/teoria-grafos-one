package br.com.furb.grafos.tipos;

public class TipoGrafoNulo implements TipoGrafo {

	@Override
	public String tipoGrafo(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix.length; y++) {
				int value = matrix[x][y];
				if(value != 0)
					return null;
			}
		}
		return "Nulo,";
	}

}
