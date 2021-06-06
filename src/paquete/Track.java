package paquete;

public class Track {
	private String nombre;
	private String artista;
	private String genero;

	/**
	 * @param nom sirve para buscar por el nombre de la canci�n
	 * @param tit para el t�tulo de la canci�n
	 * @param gen para un g�nero musical
	 */
	public Track(String nom, String tit, String gen) {
		this.artista = nom;
		this.nombre = tit;
		this.genero = gen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getArtista() {
		return this.artista;
	}

	public String getGenero() {
		return this.genero;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Canci�n: " + nombre + " Artista: " + artista + " G�nero: " + genero);
		return buf.toString();
	}
}
