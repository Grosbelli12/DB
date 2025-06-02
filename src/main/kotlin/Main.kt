package org.example

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

fun main(){
    /**
     * Primeiro vai o nome do driver JDBC
     * Depois vai o nome do banco, nesse caso, POSTGRESQL
     * Depois o IP que o banco está localizado, nesse caso, na nossa máquina
     * Por último a porta que o banco está e o nome do banco. Exemplo 5432/meu-banco
     */

    val url = "jdbc:postgresql://localhost:5432/aula"
    val user = "postgres"
    val senha = "postgres"

    try {
        val conexao : Connection = DriverManager.getConnection(url, user, senha)
        println("A conexão foi um sucesso")

        val salvar = "insert into pessoa(id , cpf, nome)"+
                "values(9, '000.000.000-09', 'aawdawdwawddv')";

        val atualizar = "UPDATE pessoa set cpf = '000.000.060-00' where id = 2"

        val excluir = "DELETE FROM pessoa WHERE cpf = '000.000.000-09'"

        conexao.createStatement().execute(excluir)

        // O ResultSet é um array de Resultados
        val query : ResultSet = conexao.createStatement().executeQuery("" +
            "select * from pessoa")

       while (query.next()) {
        val informacao = query.getString("cpf")
        println(informacao)
       }
        query.close() // Encerra a query
        conexao.close() // Encerra a conexão

    }catch (e: Exception){
        e.printStackTrace()
    }

}