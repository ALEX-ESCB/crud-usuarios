/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.crud.usuarios;

import java.util.Scanner;
import java.util.ArrayList;
import com.pmp.dao.Usuarios;
import com.pmp.dao.UsuariosDao;

/**
 *
 * @author alex-escb
 */
public class CrudUsuarios {
    
    //RANDAL ALEXIS ESCOBAR DIAZ - 1503199802758
    
    private static Scanner keyInput;
    private static String selectedOption = " ";
    private static ArrayList<Usuarios> usu;

    public static void main(String[] args) {

        init();
        while(!selectedOption.equalsIgnoreCase("S")) {
            PrintUtilities.printMenu();
            selectedOption = PrintUtilities.readInput(
                    keyInput,
                    "Escriba la opcion a ejecutar",
                    " "
            );
            switch (selectedOption.toUpperCase()) {
                case "1":
                    create();
                    break;
                case "2":
                    mostrar();
                    update();
                    break;
                case "3":
                    mostrar();
                    eliminar();
                case "4":
                    mostrar();
                    break;
                case "5":
                    PrintUtilities.printH1("ADIOS");
                    break;
            }
        }
        
    }

    
    private static void mostrar(){
        usu = UsuariosDao.Obtener();
        for( int i = 0; i< usu.size(); i++) {
            Usuarios currentUsu = usu.get(i);
            System.out.println( currentUsu.printString());
        }
    }
    
    private static void create() {
        PrintUtilities.printH1("Agregar Usuarios");
        String Nombre = PrintUtilities.readInput(keyInput, "Nombre Completo", " ");    
        String Email = PrintUtilities.readInput(keyInput, "Email del Usuario", " ");
        String Estado = PrintUtilities.readInput(keyInput, "Estado (ACT, INA)", " ");
        String Password = PrintUtilities.readInput(keyInput, "Password", " ");
        String Avatar = PrintUtilities.readInput(keyInput, "Avatar", " ");
        String FchIngreso = PrintUtilities.readInput(keyInput, "FchIngreso dia/mes/anio", " ");
        Usuarios newUsuario = new Usuarios();
        newUsuario.setNombre(Nombre);
        newUsuario.setEmail(Email);
        newUsuario.setEstado(Estado);
        newUsuario.setPassword(Password);
        newUsuario.setAvatar(Avatar);
        newUsuario.setFchIngreso(FchIngreso);
        UsuariosDao.agregar(newUsuario);
        usu = UsuariosDao.Obtener();
    }
    
    private static void update() {
        int selectedCodigo = Integer.parseInt(
                PrintUtilities.readInput(keyInput, "Código del Usuario", "")
            );
        if (selectedCodigo == 0) {
            PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
        } else {
            Usuarios UsuToUpdate = null;
            for (int i = 0; i < usu.size(); i++) {
                if (usu.get(i).getCodigo()== selectedCodigo) {
                    UsuToUpdate = usu.get(i);
                    break;
                }
            }
            if (UsuToUpdate == null) {
                PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
            } else {
                PrintUtilities.print("Usuario a Modificar");
                PrintUtilities.print(UsuToUpdate.printString());
                PrintUtilities.print("-----------------------");
                UsuToUpdate.setNombre(
                        PrintUtilities.readInput(keyInput, "Nombre Completo", UsuToUpdate.getNombre())
                );
                UsuToUpdate.setEmail(
                        PrintUtilities.readInput(keyInput, "Email del Usuario", UsuToUpdate.getEmail())
                );
                UsuToUpdate.setEstado(
                        PrintUtilities.readInput(keyInput, "Estado ACT, INA", UsuToUpdate.getEstado())
                );
                UsuToUpdate.setPassword(
                        PrintUtilities.readInput(keyInput, "Password", UsuToUpdate.getPassword())
                );
                UsuToUpdate.setAvatar(
                        PrintUtilities.readInput(keyInput, "Avatar", UsuToUpdate.getAvatar())
                );
                UsuToUpdate.setFchIngreso(
                        PrintUtilities.readInput(keyInput, "FchIngreso", UsuToUpdate.getFchIngreso())
                );
                PrintUtilities.print("---------------------");
                UsuariosDao.actualizar(UsuToUpdate);
                usu = UsuariosDao.Obtener();
            }
        }
    }
    
    private static void eliminar() {
        int selectedCodigo = Integer.parseInt(
                PrintUtilities.readInput(keyInput, "Código del Usuario", "")
            );
        if (selectedCodigo == 0) {
            PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
        } else {
            Usuarios UsuToDelete = null;
            int indexToRemove = -1;
            for (int i = 0; i < usu.size(); i++) {
                if (usu.get(i).getCodigo()== selectedCodigo) {
                    UsuToDelete = usu.get(i);
                    indexToRemove = i;
                    break;
                }
            }
            if (UsuToDelete == null) {
                PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
            } else {
                PrintUtilities.print("Usuario a Eliminar");
                PrintUtilities.print(UsuToDelete.printString());
                PrintUtilities.print("-----------------------");
                String eliminar = PrintUtilities.readInput(keyInput, "Desea eliminar este Usuario? (S/N): ", "[S] Para SI, [N] Para NO");
                if ( eliminar.equalsIgnoreCase("S") ) {
                    UsuariosDao.eliminar(UsuToDelete.getCodigo());
                    usu = UsuariosDao.Obtener();
                    PrintUtilities.print("Usuario Eliminada");
                } else {
                    PrintUtilities.print("Eliminación fue Cancelada");
                }
                
                PrintUtilities.print("---------------------");
            }
        }
    }
    
    private static void init(){
        keyInput = new Scanner(System.in);
        UsuariosDao.setup();
        usu = new ArrayList<Usuarios>();
    }
}