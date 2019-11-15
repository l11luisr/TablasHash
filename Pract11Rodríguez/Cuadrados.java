public class Cuadrados {
	
	// Método para aplicar centro de cuadrados
	static long centroCuadrados(String clave) {
		
		// Atributos
		String aux, temp;
		int tam1, tam2, primero;
		long num1, num2;
		
		// Lógica del método
		tam1 = clave.length();
		System.out.println("\n Cantidad de dígitos: " + tam1);
		num1 = Integer.parseInt(clave);
		num2 = (long)Math.pow(num1, 2);
		aux = Long.toString(num2);
		tam2 = aux.length();
		primero = (tam2 - tam1) / 3;
		temp = aux.substring(primero, primero + tam1);
		System.out.println("\n Cuadrado: " + temp);
		System.out.println("\n\t -> El valor hash son los últimos tres dígitos + 1");
		num1 = Integer.parseInt(temp);
			
		return num2;
	}

}
