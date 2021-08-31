package dao;

import entidades.Produto;
import jdbc.utils.ConexaoConfig;
import jdbc.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    //Nome tabela: produtos_lista

    public void inserir (Produto prod) {
        String sql = "INSERT INTO produtos_lista (nome, preco, custo) VALUES" +
                "(?,?,?)";
        Connection con = ConexaoConfig.criarConexao();
        PreparedStatement pst= null;
        try {
            pst = con.prepareStatement(sql);
            //Insere os valores
            pst.setString(1, prod.getNomeProduto());
            pst.setDouble(2, prod.getValorProduto());
            pst.setDouble(3, prod.getCustoProduto());
            //Executa a query
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (pst != null) {
                Utils.finalizeQuery(con, pst);
            }
        }
    }

    public List<Produto> lerProdutos () {
        String sql = "SELECT * FROM produtos_lista";

        List<Produto> lista = new ArrayList<>();
        Connection con = ConexaoConfig.criarConexao();
        PreparedStatement pst = null;
        ResultSet rs =null;

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {
                //Recuperando dados do banco e colando na lista
                Produto prod = new Produto ();
                prod.setId(rs.getInt(1));
                prod.setNomeProduto(rs.getString(2));
                prod.setValorProduto(rs.getDouble(3));
                prod.setCustoProduto(rs.getDouble(4));
                lista.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                Utils.finalizeQuery(con,pst,rs);
            }
        }
        return lista;
    }

    public void atualizar (Produto prod) {
        String sql = "UPDATE produtos_lista SET nome = ?, preco = ?, custo =?" +
                "WHERE id = ?";

        Connection con = ConexaoConfig.criarConexao();
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,prod.getNomeProduto());
            pst.setDouble(2,prod.getValorProduto());
            pst.setDouble(3, prod.getCustoProduto());

            //Qual produto você deseja atualizar?
            pst.setInt(4, prod.getId());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pst != null) {
                Utils.finalizeQuery(con,pst);
            }
        }
    }

    public void deletar (int id) {
        String sql = "DELETE FROM produtos_lista WHERE id = ?";

        Connection con = ConexaoConfig.criarConexao();
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pst != null) {
                Utils.finalizeQuery(con,pst);
            }
        }
    }
}
