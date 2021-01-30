package innet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tiempo, veces;
		String stAcceso, stSeguir;
		Boolean Acceso = true;
		Boolean Seguir = true;
		
		while(Seguir) {
			System.out.println("Cuantas veces quieres hacer ping: ");
			veces = sc.nextInt();
			sc.nextLine();
			System.out.println("Cuanto tiempo de espera quieres (milisegundos): ");
			tiempo = sc.nextInt();
			sc.nextLine();
			System.out.println("Quieres acceso total o parcial: ");
			stAcceso = sc.nextLine();
			if(stAcceso.toLowerCase().equals("total")) {
				Acceso = true;
			}else {
				Acceso = false;
			}
			
			
			try {
				InetAddress direccion = InetAddress.getByName("google.com");
				InetAddress direccionOtra = InetAddress.getByName("172.16.200.154");
				
				if(Acceso) {
					for(int i=0; i<veces;i++) {
						System.out.println("Se ha encontrado la direccion "+direccion.getHostName()+": "+direccion.isReachable(tiempo));
						System.out.println("Se ha encontrado la direccion "+direccionOtra.getHostName()+": "+direccionOtra.isReachable(tiempo));
					}
				}
				else {
					for(int i=0; i<veces;i++) {
						System.out.println("Se ha encontrado la direccion: "+direccion.isReachable(tiempo));
						System.out.println("Se ha encontrado la direccion: "+direccionOtra.isReachable(tiempo));
					}
				}
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			System.out.println("Quieres seguir (Y/N): ");
			stSeguir = sc.nextLine();
			if(stSeguir.toUpperCase().equals("Y")) {
				Seguir = true;
			}else {
				Seguir = false;
			}
		}
		sc.close();
	}

}
