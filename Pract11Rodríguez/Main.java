/*
									UNIVERSIDAD AUT�NOMA DE BAJA CALIFORNIA
								  FACULTAD DE CIENCIAS QU�MICAS E INGENIER�A
									  ALGORITMOS Y ESTRUCTURA DE DATOS
											     PR�CTICA #11

Nombre: Rodr�guez Munoz Jos� Luis
Pr�ctica: Funciones Hash
Fecha: 13/11/2019

Descripci�n:
Las funciones que transforman n�meros grandes o claves en n�meros m�s pequenos se conocen como
funciones de dispersi�n o funciones hash. Normalmente, la clave asociada con un elemento es de tipo
entero, si no es as� antes se deber� transformar la clave a un valor entero. Por ejemplo, si la clave es
una cadena de caracteres, se puede transformar considerando el valor ASCII de cada car�cter como si
fuera un d�gito entero. Existen varias funciones Hash, entre ellas:

Funci�n Aritm�tica modular
	Utiliza la aritm�tica modular genera valores dispersos calculando el residuo de la divisi�n entre la
	clave x y el tamano de la tabla m.
	h(x)= x modulo m
	Con el fin de que esta funci�n disperse lo m�s uniformemente posible, es necesario tener cuidado con
	la elecci�n del tamano de la tabla, m. No se recomienda elegir m�ltiplos de 2 ni tampoco de 10, se
	obtienen mejores resultados con n�meros primos grandes.

Funci�n Centro de Cuadrados
	Consiste en elevar al cuadrado la clave y tomar los d�gitos centrales como el valor hash y sumarle 1. La
	cantidad de d�gitos que se toman del centro queda determinado por el rango del �ndice de la tabla, por
	ejemplo si la tabla tiene tamano 100, el rango estar�a entre 0 y 99, por lo tanto solo se necesitar�a 2
	d�gitos. Por ejemplo si tomamos como clave 129641, el cuadrado es 16806788881 y el tamano de la
	tabla es 1000, por lo tanto se tomaran 678 +1, el valor hash ser�a 679.

Funci�n Truncamiento
	Consiste en seleccionar parte del n�mero, no necesariamente consecutivas. Por ejemplo, si un n�mero
	de 6 d�gitos, se pueden unir el segundo, el cuarto y el sexto para formar el valor hash. Utilizando 129641,
	el valor resultante es 261

M�todo multiplicativo
	La dispersi�n de una clave utilizando el m�todo de la multiplicaci�n genera direcciones en
	tres pasos.
		1. Multiplica la clave x por una constante real, R, 0 y 1. Una elecci�n de la constante R es la inversa
		de la raz�n �urea, R = 0.6180334.
		2. Determina la parte decimal, d, del n�mero obtenido en la multiplicaci�n, R*x.
		3. Multiplica el tamano de la tabla, m, por d y al truncarse el resultado se obtiene un n�mero
		entero en el rango 0 ... m-1 que ser� la direcci�n dispersa.
				1. R * x
				2. d = R * x - ParteEntera(R * x)
				3. h(x) = ParteEntera(m * d)

Desarrollo de la pr�ctica:
Implemente en C o Java 3 de las funciones anteriores, a su elecci�n y realice pruebas con los 3 m�todos
utilizando como entrada el mismo conjunto de 20 claves num�ricas de 7 d�gitos, una de las claves debe
ser su matr�cula. Las claves deben ser uniformes. Considere el tamano de la tabla Hash (m) igual para
todas las funciones. 

*/

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// Atributos
		String clave;
		long valor;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		Hash hash = new Hash(20); // Tabla Hash de 20 elementos
		String[] elementos = {"0123456", "1234567", "1245678", "1256789", "1267890", "1278901", "1289012", "1290123", "1201234", "1212345", "1252717", "1253444", "1253546", "1253779", "1257400", "1260368", "1260444", "1260579", "1260896", "1260367"}; // Arreglo de 20 elementos
		hash.funcionHash(elementos, hash.arreglo); // Recibe los elementos y el arreglo
		hash.mostrar();
		String buscado = hash.buscarClave("1260368"); // Se encuentra el elemento o no
		if(buscado ==  null) { // Si no se encuentra
			
			System.out.println("\n La clave 1260368 no se encuentra en la tabla ...");
		}
		
		// M�todo multiplicativo/dispersi�n
		System.out.println("\n ----------------------------------------------- ");
		System.out.println("\n\n\t M�todo Multiplicativo");
		System.out.println("\n Clave: ");
		clave = entrada.readLine();
		valor = Dispersion.transformaClave(clave);
		valor = Dispersion.dispersion(valor);
		System.out.println("\n La dispersi�n de la clave " + clave + " es " + valor);
		
		// Funci�n centro de cuadrados
		System.out.println("\n ------------------------------------------------ ");
		System.out.println("\n\n\t Centro de Cuadrados");
		System.out.println("\n Clave: ");
		clave = entrada.readLine();
		valor = Cuadrados.centroCuadrados(clave);
		
	}

}
