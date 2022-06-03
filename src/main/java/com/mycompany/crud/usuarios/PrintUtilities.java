/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.usuarios;

import java.util.Scanner;

/**
 *
 * @author alex-escb
 */
public class PrintUtilities {
    public static void printH1( String headerText ){

        System.out.println("==========================");
        System.out.println(headerText);
        System.out.println("==========================");
    }
    
    public static String readInput( Scanner keyInput, String label, String defaultValue){
        System.out.println(' ');
        System.out.println(label +" : ");
        String inputValue = keyInput.nextLine();
        // || or    && and
        if (inputValue.isEmpty()|| inputValue.isBlank()) {
            inputValue = defaultValue;
        }
        return inputValue;
    }
    public static void printMenu(){
        System.out.println("======================================");
        System.out.println("Opciones");
        System.out.println("======================================");
        System.out.println("[1] \t [Agregar Usuarios]");
        System.out.println("[2] \t [Modificar Usuarios]");
        System.out.println("[3] \t [Eliminar Usuarios]");
        System.out.println("[4] \t [Mostrar Usuarios]");
        
        System.out.println("======================================");
        System.out.println("[5] \t Salir");
    }
    
    public static void print(String text){
        System.out.println(text);
    }
}