package dao;

import modelo.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDAOImpl implements ItemVendaDAO {

    @Override
    public void criar(ItemVenda item) {
        String sql = "INSERT INTO item_venda (id_venda, id_produto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getIdVenda());
            stmt.setInt(2, item.getIdProduto());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getSubtotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir item da venda", e);
        }
    }

    @Override
    public ItemVenda buscarPorId(int id) {
        String sql = "SELECT * FROM item_venda WHERE id = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairItem(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar item", e);
        }
        return null;
    }

    @Override
    public List<ItemVenda> listarPorVenda(int idVenda) {
        String sql = "SELECT * FROM item_venda WHERE id_venda = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        List<ItemVenda> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(extrairItem(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens da venda", e);
        }
        return lista;
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM item_venda WHERE id = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar item", e);
        }
    }

    private ItemVenda extrairItem(ResultSet rs) throws SQLException {
        return new ItemVenda(
            rs.getInt("id"),
            rs.getInt("id_venda"),
            rs.getInt("id_produto"),
            rs.getInt("quantidade"),
            rs.getDouble("subtotal")
        );
    }
}