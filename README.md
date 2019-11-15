
					UNIVERSIDAD AUTÓNOMA DE BAJA CALIFORNIA
				       FACULTAD DE CIENCIAS QUÍMICAS E INGENIERÍA
				           ALGORITMOS Y ESTRUCTURA DE DATOS
						     PRÁCTICA #11

Nombre: Rodríguez Munoz José Luis

Práctica: Funciones Hash

Fecha: 13/11/2019

Descripción:
Las funciones que transforman números grandes o claves en números más pequenos se conocen como
funciones de dispersión o funciones hash. Normalmente, la clave asociada con un elemento es de tipo
entero, si no es así antes se deberá transformar la clave a un valor entero. Por ejemplo, si la clave es
una cadena de caracteres, se puede transformar considerando el valor ASCII de cada carácter como si
fuera un dígito entero. Existen varias funciones Hash, entre ellas:

Función Aritmética modular

	Utiliza la aritmética modular genera valores dispersos calculando el residuo de la división entre la
	clave x y el tamano de la tabla m.
	h(x)= x modulo m
	Con el fin de que esta función disperse lo más uniformemente posible, es necesario tener cuidado con
	la elección del tamano de la tabla, m. No se recomienda elegir múltiplos de 2 ni tampoco de 10, se
	obtienen mejores resultados con números primos grandes.

Función Centro de Cuadrados

	Consiste en elevar al cuadrado la clave y tomar los dígitos centrales como el valor hash y sumarle 1. La
	cantidad de dígitos que se toman del centro queda determinado por el rango del índice de la tabla, por
	ejemplo si la tabla tiene tamano 100, el rango estaría entre 0 y 99, por lo tanto solo se necesitaría 2
	dígitos. Por ejemplo si tomamos como clave 129641, el cuadrado es 16806788881 y el tamano de la
	tabla es 1000, por lo tanto se tomaran 678 +1, el valor hash sería 679.

Función Truncamiento

	Consiste en seleccionar parte del número, no necesariamente consecutivas. Por ejemplo, si un número
	de 6 dígitos, se pueden unir el segundo, el cuarto y el sexto para formar el valor hash. Utilizando 129641,
	el valor resultante es 261

Método multiplicativo
	La dispersión de una clave utilizando el método de la multiplicación genera direcciones en
	tres pasos.
		1. Multiplica la clave x por una constante real, R, 0 y 1. Una elección de la constante R es la inversa
		de la razón áurea, R = 0.6180334.
		2. Determina la parte decimal, d, del número obtenido en la multiplicación, R*x.
		3. Multiplica el tamano de la tabla, m, por d y al truncarse el resultado se obtiene un número
		entero en el rango 0 ... m-1 que será la dirección dispersa.
				1. R * x
				2. d = R * x - ParteEntera(R * x)
				3. h(x) = ParteEntera(m * d)

Desarrollo de la práctica:

Implemente en C o Java 3 de las funciones anteriores, a su elección y realice pruebas con los 3 métodos
utilizando como entrada el mismo conjunto de 20 claves numéricas de 7 dígitos, una de las claves debe
ser su matrícula. Las claves deben ser uniformes. Considere el tamano de la tabla Hash (m) igual para
todas las funciones. 
