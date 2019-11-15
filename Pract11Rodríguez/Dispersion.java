public class Dispersion {
	
	static final int M = 1024;
	static final double R = 0.618034;
	
	// M�todo para transformar clave
	static long transformaClave(String clave) {
		
		int j;
		long d;
		d = 0;
		
		for(j = 0; j < Math.min(clave.length(), 20); j++) {
			
			d = d * 27 + (int)clave.charAt(j);
		}
		
		if(d < 0) {
			
			d = -d;
		}
		
		return d;
	}
	
	// M�todo para aplicar la dispersi�n
	static int dispersion(long x) {
		
		double t;
		int v;
		t = R * x - Math.floor(R * x); // Parte decimal
		v = (int) (M * t);
		return v;
	}

}
