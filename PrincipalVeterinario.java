package Veterinario;

import java.util.ArrayList;

import java.util.Scanner;

public class PrincipalVeterinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perro perro1 = new Perro("Kiko", 3, "braco húngaro");
		Perro perro2 = new Perro("Chispa", 4, "pastor alemán");
		Perro perro3 = new Perro("Tobi", 6, "dálmata");
		
		Gato gato1 = new Gato("Bilbo", 3, "corto");
		Gato gato2 = new Gato("Frodo", 5, "mediano");
		Gato gato3 = new Gato("Elliot", 7, "largo");

		
		Pajaro pajaro1 = new Pajaro("Loren", 2, "verde");
		Pajaro pajaro2 = new Pajaro("Keylor", 1, "amarillo");
		Pajaro pajaro3 = new Pajaro("Nely", 1, "azul");

		
		ArrayList<Animal> animalesEnfermos = new ArrayList();
		ArrayList<Animal> animalesSanos = new ArrayList();
		
		animalesEnfermos.add(perro1);
		animalesEnfermos.add(gato1);
		animalesEnfermos.add(pajaro1);

		animalesSanos.add(perro2);
		animalesSanos.add(gato2);
		animalesSanos.add(pajaro2);
		
		animalesSanos.add(perro3);
		animalesSanos.add(gato3);
		animalesSanos.add(pajaro3);
		
		
		Scanner sc = new Scanner(System.in);
		int dia = 0;
		int entrada= 0;
		
		while(true) {
			
			dia++;
			
			System.out.println("\n\nDIA " + dia );
			System.out.println();
			
			introducirAltasyListarEnfermos(animalesEnfermos, animalesSanos, sc);
			
			introducirBajasyListarSanos(animalesEnfermos, animalesSanos, sc);		
			
		}
		
		//sc.close();
		
		


	}

	public static void introducirBajasyListarSanos(ArrayList<Animal> animalesEnfermos, ArrayList<Animal> animalesSanos, Scanner sc) {
		int entrada;
		do {
			
			System.out.println("\nAnimales sanos");
			System.out.println();
			
			if (animalesSanos.size()>0) {
			
				for(int i = 0; i<animalesSanos.size(); i++) {
					
					System.out.println((i+1) + ".- " + animalesSanos.get(i).getNombre());
					}
				
				System.out.println();
				
				
				do {
					System.out.print("¿Qué animal ha enfermado (1 - " + animalesSanos.size() + ") (-1: ninguno)");
					entrada = sc.nextInt();
				}while(((entrada<0 )&&(entrada!=-1)) || (entrada > animalesSanos.size()));
				
				if (entrada != -1) {
					
					animalesEnfermos.add(animalesSanos.get(entrada-1));
					animalesSanos.remove(entrada-1);
				}
				
			}else {
				
				System.out.println("\nNo hay animales sanos");
				System.out.println();
				entrada = -1;
				
			}
		}while(entrada != -1);
	}

	public static void introducirAltasyListarEnfermos(ArrayList<Animal> animalesEnfermos, ArrayList<Animal> animalesSanos,
			Scanner sc) {
		int entrada;
		do {
			
			if (animalesEnfermos.size()>0) {
				
				System.out.println("\nAnimales enfermos");
				System.out.println();
			
				for(int i = 0; i<animalesEnfermos.size(); i++) {
					
					System.out.println((i+1) + ".- " + animalesEnfermos.get(i).getNombre());
					}
				
				System.out.println();
				
				
				do {
					System.out.print("¿Qué animal se ha recuperado ya? (1 - " + animalesEnfermos.size() + ") (-1: ninguno)");
					entrada = sc.nextInt();
				} while (((entrada<0 )&&(entrada!=-1)) || (entrada > animalesEnfermos.size()));
					
					
					
					
				if (entrada != -1) {
					
					animalesSanos.add(animalesEnfermos.get(entrada-1));
					animalesEnfermos.remove(entrada-1);
				}
				
			}else {
				
				System.out.println("\nNo hay animales enfermos");
				System.out.println();
				entrada = -1;
				
			}
		}while(entrada != -1);
	}

}
