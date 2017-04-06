package br.com.furb.grafos.tipos;

public class TipoGrafoCompleto implements TipoGrafo {

	@Override
	public String tipoGrafo(int[][] matrix) {
		TipoGrafo tipoGrafo = new TipoGrafoSimples();
		String retorno = tipoGrafo.tipoGrafo(matrix);
		if (retorno == null)
			return null;
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix.length; y++) {
				if (y != x) {
					int value = matrix[x][y];
					if(value == 0)
						return null;
				}
			}
		}
		return "Completo,";
	}

}
