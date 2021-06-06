package paquete;

import java.util.ArrayList;

public class Biblioteca implements Buscador {

	private ArrayList<Track> tracks;// Lista
	private Reproductor player;// Reproductor
	private LectorCanciones reader;// Lector

	public Biblioteca() {
		tracks = new ArrayList<Track>();
		player = new Reproductor();
		reader = new LectorCanciones();
		leerBiblioteca("canciones");
		System.out.println();
	}
	
	/**
	 * M�todo para buscar por nombre de la canci�n
	 */
	public void busquedaPorNombre(String nombre) {
		for (Track track : tracks) {
			String title = track.getNombre();
			if (title.contains(nombre)) {
				System.out.println(track.toString());
			}
		}
	}

	/**
	 * M�todo para buscar por artista
	 */
	
	public void busquedaPorArtista(String nombre) {
		for (Track track : tracks) {
			String artista = track.getArtista();
			if (artista.contains(nombre)) {
				System.out.println(track.toString());
			}
		}
	}

	/**
	 * M�todo para buscar por un g�nero musical
	 */
	
	public void busquedaPorGenero(String nombre) {
		for (Track track : tracks) {
			String genero = track.getGenero();
			if (genero.contains(nombre)) {
				System.out.println(track.toString());
			}
		}
	}

	/**
	 * M�todo para reproducir archivos MP3
	 * (A�n no disponible)
	 */
	
	public void reproducir(String nombre) {
		for (Track track : tracks) {
			String titulo = track.getNombre();
			if (titulo.contains(nombre)) {
				player.reproducir(track.getNombre());
				System.out.println("Reproduciendo: " + track.getArtista() + " - " + track.getNombre());
			}
		}
	}

	public int getNumeroCanciones() {
		return tracks.size();
	}

	public void listaTodasCanciones() {
		System.out.println("Canciones: ");

		for (Track track : tracks) {
			System.out.println(track.toString());
		}
		System.out.println();
	}

	public void parar() {
		player.stop();
	}

	private void leerBiblioteca(String folderName) {
		ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

		for (Track track : tempTracks) {
			tracks.add(track);
		}
	}

}
