package dao;

import modelo.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAOImpl implements PagamentoDAO {

    @Override
    public void criar(Pagamento p) {
        String sql = "INSERT INTO pagamento (id_venda, forma_pagamento, valor_pago, data_pagamento) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getIdVenda());
            stmt.setString(2, p.getFormaPagamento());
            stmt.setDouble(3, p.getValorPago());
            stmt.setDate(4, java.sql.Date.valueOf(p.getDataPagamento()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pagamento", e);
        }
    }

    @Override
    public Pagamento buscarPorId(int id) {
        String sql = "SELECT * FROM pagamento WHERE id = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairPagamento(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pagamento", e);
        }
        return null;
    }

    @Override
    public List<Pagamento> listarPorVenda(int idVenda) {
        String sql = "SELECT * FROM pagamento WHERE id_venda = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        List<Pagamento> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(extrairPagamento(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pagamentos", e);
        }
        return lista;
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM pagamento WHERE id = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar pagamento", e);
        }
    }

    private Pagamento extrairPagamento(ResultSet rs) throws SQLException {
        return new Pagamento(
            rs.getInt("id"),
            rs.getInt("id_venda"),
            rs.getString("forma_pagamento"),
            rs.getDouble("valor_pago"),
            rs.getDate("data_pagamento").toString()
        );
    }
}