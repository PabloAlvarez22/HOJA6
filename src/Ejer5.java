// Autor: Pablo Alvarez 221082

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import Interfaces.IMap;
import java.io.FileReader;
import factory.Factory;

public class Ejer5 {


    
    Factory factory = new Factory();
    Scanner in  = new Scanner(System.in);
    IMap listadoproductos;
    public static void main(String[] args) throws Exception {
        Ejer5 ejer = new Ejer5();
        ejer.initialize();
    }


    public void initialize(){

        System.out.println("1. linkedhashmap");
        System.out.println("2. hashmap ");
        System.out.println("3. treemap");
        int resp = in.nextInt();

        listadoproductos = factory.returnHashmap(resp);


        readFile();
        menu();
    }


   

    public void menu(){
        int resp = 0;
        while(resp!=5){
            System.out.println("1. Agregar un producto a la colección del usuario.");
            System.out.println("2.  Mostrar la categoría del producto.");
            System.out.println("3. Mostrar los datos del producto");
            System.out.println("4. Mostrar los datos del producto por tipo.");
            System.out.println("5. salir");
            resp = in.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("nombre: ");
                    String name = in.next();
                    System.out.println("categoria: ");
                    String category = in.next();
                
            
                    try {
                        listadoproductos.add(name, category);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                
                case 2:
                    System.out.println("nombre: ");
                    String name2 = in.next();
                    System.out.println("NOMBRE: "+name2);
                    System.out.println("categoria: "+ listadoproductos.find(name2));
                   
                    break;
                case 3:
                listadoproductos.printMap();
                    break;
                case 4:
                listadoproductos.orderByCategory();
                    break;
                default:
                    break;
            }
        }
        

    }


    public void readFile(){
        File file = new File("src/ListadoProducto.txt");
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

            while (line != null) {
				// read next line
				line = reader.readLine();

                if(line!=null){
                    String[] values = line.split("\\|");
    
                    String name = values[1];
                    String category = values[0];
                    
                    try {
                        listadoproductos.add(name, category);
                        
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
			}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }
}
