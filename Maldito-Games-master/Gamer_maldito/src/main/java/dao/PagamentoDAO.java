package dao;

import modelo.Pagamento;
import java.util.List;

public interface PagamentoDAO {
    void criar(Pagamento pagamento);
    Pagamento buscarPorId(int id);
    List<Pagamento> listarPorVenda(int idVenda);
    void deletar(int id);
}