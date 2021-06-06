package paquete;
/**
 * Esta es una clase excepción, es usada en caso de que no se introduzca un número
 * válido en el main
 */
public class ReproException extends Exception {
	public ReproException(String msg) {
		super(msg); 
	}
}
