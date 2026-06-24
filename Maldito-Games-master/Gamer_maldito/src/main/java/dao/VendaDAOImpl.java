package dao;

import modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOImpl implements VendaDAO {

    @Override
    public void criar(Venda v) {
        String sql = "INSERT INTO venda (data_venda, valor_total, id_cliente, status_pagamento) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(v.getData())); // data no formato yyyy-MM-dd
            stmt.setDouble(2, v.getValorTotal());
            stmt.setInt(3, v.getIdCliente());
            stmt.setString(4, v.getStatusPagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir venda", e);
        }
    }

    @Override
    public Venda buscarPorId(int id) {
        String sql = "SELECT * FROM venda WHERE id = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairVenda(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar venda", e);
        }
        return null;
    }

    @Override
    public List<Venda> listar() {
        String sql = "SELECT * FROM venda";
        Connection conn = DBConnection.getInstance().getConnection();
        List<Venda> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(extrairVenda(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendas", e);
        }
        return lista;
    }

    @Override
    public void atualizar(Venda v) {
        String sql = "UPDATE venda SET data_venda=?, valor_total=?, id_cliente=?, status_pagamento=? WHERE id=?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(v.getData()));
            stmt.setDouble(2, v.getValorTotal());
            stmt.setInt(3, v.getIdCliente());
            stmt.setString(4, v.getStatusPagamento());
            stmt.setInt(5, v.getIdVenda());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar venda", e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar venda", e);
        }
    }

    private Venda extrairVenda(ResultSet rs) throws SQLException {
        return new Venda(
            rs.getInt("id"),
            rs.getDate("data_venda").toString(),
            rs.getDouble("valor_total"),
            rs.getInt("id_cliente"),
            rs.getString("status_pagamento")
        );
    }
}