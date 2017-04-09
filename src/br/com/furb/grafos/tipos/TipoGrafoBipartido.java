package br.com.furb.grafos.tipos;

public class TipoGrafoBipartido implements TipoGrafo {

	protected int[] colors;
	protected int[][] matrix;

	@Override
	public String tipoGrafo(int[][] matrix) {
		init(matrix);
		TipoGrafo tipoGrafo = new TipoGrafoMultigrafo();
		String multigrafo = tipoGrafo.tipoGrafo(matrix);
		if (multigrafo != null)
			return null;
		this.matrix = matrix;
		boolean bipartido = grafoBipartido();
		if (!bipartido)
			return null;
		return "Bipartido,";
	}

	protected boolean grafoBipartido() {
		for (int x = 0; x < colors.length; ++x) {
			if (colors[x] == -1)
				if (!diffColor(x, 0))
					return false;
		}
		return true;
	}

	protected void init(int[][] matrix) {
		colors = new int[matrix.length];
		for (int x = 0; x < matrix.length; x++)
			colors[x] = -1;
	}

	protected boolean diffColor(int v, int c) {
		colors[v] = c;
		for (int p = v; p < colors.length; p++) {
			if (colors[p] == -1) {
				if (!diffColor(p, 1 - c))
					return false;
			} else if (colors[p] == c)
				return false;
		}
		return true;
	}
}
