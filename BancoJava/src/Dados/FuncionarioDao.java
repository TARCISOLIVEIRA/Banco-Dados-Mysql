/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;



public class FuncionarioDao {
    Connection con;
    Statement st; 
    public boolean conectar (){ 
     
        try {
    
    
             Class.forName("com.mysql.jdbc.Driver");
             con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/Controle","root","root"); 
             st = con.createStatement();
             return true;
        } catch (ClassNotFoundException | SQLException ex) {
             return false;
        } 
}
    
    public int salvar (Funcionario func){
        int status;
        try {
            String inserir ;
            inserir = "INSERT INTO funcionario VALUES ('"+ func.getMatricula() + "','"+ func.getNome() + "','" + func.getCargo() + "', " + func.getSalario() + ")";
            status = st.executeUpdate(inserir);
            return status; // retorna 1
        } catch (SQLException ex) {
           // System.out.println(ex.getErrorCode()); 1062 tentativa de inserir já cadastrado
            return ex.getErrorCode() ; 
        }
    }
    public void desconectar (){
        try {
            con.close();
        } catch (SQLException ex) {
           
        }
    }
   
}