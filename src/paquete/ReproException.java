package paquete;
/**
 * Esta es una clase excepci�n, es usada en caso de que no se introduzca un n�mero
 * v�lido en el main
 */
public class ReproException extends Exception {
	public ReproException(String msg) {
		super(msg); 
	}
}
