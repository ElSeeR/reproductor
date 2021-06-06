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
		System.out.println("Bienvenido al reproductor MP3 ReproBrOS�");
		System.out.println("==========================================");
		while (!salir) {
			System.out.println("Elige una opci�n:");
			System.out.println("1 - B�squeda por nombre");
			System.out.println("2 - B�squeda por artista");
			System.out.println("3 - B�squeda por g�nero");
			System.out.println("Para salir introduzca otro n�mero");

			int eleccion;
			try {
				eleccion = sc.nextInt();

			} catch (InputMismatchException e) {
				throw new ReproException("Introduce un n�mero");
			}

			Biblioteca Sergio = new Biblioteca();

			switch (eleccion) {
			case 1:
				System.out.println("Introduzca el nombre de la canci�n:");
				String titulo = sc.next();
				Sergio.busquedaPorNombre(titulo);
				break;

			case 2:
				System.out.println("Introduzca el artista:");
				String artista = sc.next();
				Sergio.busquedaPorArtista(artista);
				break;

			case 3:
				System.out.println("Introduzca un g�nero:");
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
