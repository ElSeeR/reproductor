package paquete;
import java.util.*;
/**
 * Reproductor de archivos MP3
 * @author Sergio Bailez
 *
 */
public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ReproException {
		boolean salir = false;
		System.out.println("Bienvenido al reproductor MP3 ReproBrOS®");
		System.out.println("==========================================");
		while (!salir) {
			System.out.println("Elige una opción:");
			System.out.println("1 - Búsqueda por nombre");
			System.out.println("2 - Búsqueda por artista");
			System.out.println("3 - Búsqueda por género");
			System.out.println("Para salir introduzca otro número");

			int eleccion;
			try {
				eleccion = sc.nextInt();

			} catch (InputMismatchException e) {
				throw new ReproException("Introduce un número");
			}

			Biblioteca Sergio = new Biblioteca();

			switch (eleccion) {
			case 1:
				System.out.println("Introduzca el nombre de la canción:");
				String titulo = sc.next();
				Sergio.busquedaPorNombre(titulo);
				break;

			case 2:
				System.out.println("Introduzca el artista:");
				String artista = sc.next();
				Sergio.busquedaPorArtista(artista);
				break;

			case 3:
				System.out.println("Introduzca un género:");
				String genero = sc.next();
				Sergio.busquedaPorGenero(genero);
				break;

			default:
				System.out.println("Saliendo del reproductor...");
				salir = true;
			}

		}
	}

}
