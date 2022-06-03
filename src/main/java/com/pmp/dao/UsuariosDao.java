/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alex-escb
 */
public class UsuariosDao {
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS USUARIOS"
                + " (CODIGO INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " NOMBRE TEXT,"
                + " EMAIL TEXT,"
                + " ESTADO TEXT,"
                + " PASSWORD TEXT,"
                + " AVATAR TEXT,"
                + " FCHINGRESO TEXT);";
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCrearTabla);
            comando.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    public static ArrayList<Usuarios> Obtener(){
        String sqlObtenerTodo = "SELECT * FROM USUARIOS;";
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try{
            Statement comando = Conexion.getConexion().createStatement();
            ResultSet usuarioRows = comando.executeQuery(sqlObtenerTodo);
            while (usuarioRows.next()){
                Usuarios usuario = new Usuarios();
                usuario.setCodigo(usuarioRows.getInt("CODIGO"));
                usuario.setNombre(usuarioRows.getString("NOMBRE"));
                usuario.setEmail(usuarioRows.getString("EMAIL"));
                usuario.setEstado(usuarioRows.getString("ESTADO"));
                usuario.setPassword(usuarioRows.getString("PASSWORD"));
                usuario.setAvatar(usuarioRows.getString("AVATAR"));
                usuario.setFchIngreso(usuarioRows.getString("FCHINGRESO"));
                usuarios.add(usuario);
            }
            comando.close();
            return usuarios;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    public static Usuarios agregar(Usuarios newUsuario) {
        String sqlInsertUsuarios = "INSERT INTO USUARIOS (NOMBRE, EMAIL, ESTADO, PASSWORD, AVATAR, FCHINGRESO) VALUES (?, ?, ?, ?, ?, ?); ";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlInsertUsuarios);
            comando.setString(1, newUsuario.getNombre());
            comando.setString(2, newUsuario.getEmail());
            comando.setString(3, newUsuario.getEstado());
            comando.setString(4, newUsuario.getPassword());
            comando.setString(5, newUsuario.getAvatar());
            comando.setString(6, newUsuario.getFchIngreso());
            int registroAgregado = comando.executeUpdate();
            comando.close();
            return newUsuario;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public static Usuarios actualizar(Usuarios  updUsu){
        String sqlUpdate = "UPDATE USUARIOS set NOMBRE=?, EMAIL=?, ESTADO=?, PASSWORD=?, AVATAR=?, FCHINGRESO=? WHERE CODIGO=?;";
        try{
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlUpdate);
            comando.setString(1, updUsu.getNombre());
            comando.setString(2, updUsu.getEmail());
            comando.setString(3, updUsu.getEstado());
            comando.setString(4, updUsu.getPassword());
            comando.setString(5, updUsu.getAvatar());
            comando.setString(6, updUsu.getFchIngreso());
            comando.setInt(7, updUsu.getCodigo());
            int registroActualizado = comando.executeUpdate();
            comando.close();
            return updUsu;
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    
    }
    
    
    public static int eliminar(int codEliminar){
        String sqlEliminar = "DELETE FROM USUARIOS WHERE CODIGO=?";
        try{
           PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlEliminar);
           comando.setInt(1, codEliminar);
           int registrosEliminados = comando.executeUpdate();
           comando.close();
           return registrosEliminados;
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return 0;
        }
    
    }
    
}