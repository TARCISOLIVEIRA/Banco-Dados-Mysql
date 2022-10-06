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
    
    public boolean salvar (Funcionario func){
        try {
            String inserir ;
            inserir = "INSERT INTO funcionario VALUES ('"+ func.getMatricula() + "','"+ func.getNome() + "','" + func.getCargo() + "', " + func.getSalario() + ")";
            st.executeUpdate(inserir);
            return true;
        } catch (SQLException ex) {
            return false; 
        }
    }
    public void desconectar (){
        try {
            con.close();
        } catch (SQLException ex) {
           
        }
    }
   
}