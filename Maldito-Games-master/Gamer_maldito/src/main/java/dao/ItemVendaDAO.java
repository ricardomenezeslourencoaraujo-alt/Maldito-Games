package dao;

import modelo.ItemVenda;
import java.util.List;

public interface ItemVendaDAO {
    void criar(ItemVenda item);
    ItemVenda buscarPorId(int id);
    List<ItemVenda> listarPorVenda(int idVenda);
    void deletar(int id);
}