package paquete;

public class Track {
	private String nombre;
	private String artista;
	private String genero;

	/**
	 * @param nom sirve para buscar por el nombre de la canción
	 * @param tit para el título de la canción
	 * @param gen para un género musical
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
		buf.append("Canción: " + nombre + " Artista: " + artista + " Género: " + genero);
		return buf.toString();
	}
}
