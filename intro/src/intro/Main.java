package intro;

public class Main {

	public static void main(String[] args) {
		
		//camelCase
		//Don't repeat yourself
		String internetSubeButonu ="�nternet �ubeye gir";
		double dolarDun =8.20;
		double dolarBugun =8.20;
		int vade =36;
		boolean dustuMu= false;
		
		
		System.out.println(internetSubeButonu);
		
		if(dolarBugun<dolarDun) {
			System.out.println("Dolar d��t� resmi");
		}else if(dolarBugun>dolarDun){
			System.out.println("Dolar y�kseldi resmi");
		}
		
		else {System.out.println("Dolar e�ittir resmi");
		
		}
		
		String kredi1="H�zl� kredi";
		String kredi2="Mutlu emekli kredisi";
		String kredi3="Konut kredisi";
		String kredi4="�iftci kredisi";
		String kredi5="Msb kredisi";
		
		String[] krediler = 
				{
				"H�zl� kredi",
				"Mutlu emekli kredisi",
				"Konut kredisi",
				"�iftci kredisi",
				"Msb kredisi", 
				"Meb kredisi",
				"K�lt�r Bakanl��� kredisi"
				};
		//foreach
		for(String kredi : krediler) {
			System.out.println(kredi);			
		
		}
		for(int i=0; i<krediler.length; i++) {
			System.out.println(krediler[i]);
		}

	}

}
