package dao;

import modelo.Venda;
import java.util.List;

public interface VendaDAO {
    void criar(Venda venda);
    Venda buscarPorId(int id);
    List<Venda> listar();
    void atualizar(Venda venda);
    void deletar(int id);
}