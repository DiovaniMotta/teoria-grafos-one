package br.com.furb.grafos.tipos;

public class TipoGrafoBipartido implements TipoGrafo {

	protected int[] colors;
	protected int[][] matrix;

	@Override
	public String tipoGrafo(int[][] matrix) {
		init(matrix);
		TipoGrafo tipoGrafo = new TipoGrafoMultigrafo();
		String multigrafo = tipoGrafo.tipoGrafo(matrix);
		if(multigrafo != null)
			return null;
		this.matrix = matrix;
		for(int x = 0 ; x < colors.length ; ++x){
			  if(colors[x] == -1)
			   if(diffColor(x, 0) == 0) 
				   return null;
		}
			 return "Bipartido,";
	}

	protected void init(int[][] matrix) {
		colors = new int[matrix.length];
		for (int x = 0; x < matrix.length; x++)
			colors[x] = -1;
	}

	protected int diffColor(int v, int c) {
		int p;
		colors[v] = 1 - c; 
		for (p = 0; p < colors.length; ++p) {
			if (matrix[v][p] == 1 && colors[p] == -1) { 
				if (diffColor(p, 1 - c) == 0)
					return 0;
			} else if (colors[p] == 1 - c)
				return 0;
		}
		return 1;
	}
}
