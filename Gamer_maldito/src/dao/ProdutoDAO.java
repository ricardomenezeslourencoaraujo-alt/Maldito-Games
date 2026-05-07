package dao;

import modelo.Produto;
import java.util.List;

public interface ProdutoDAO {
    void criar(Produto produto);
    Produto buscarPorId(int id);
    List<Produto> listar();
    void atualizar(Produto produto);
    void deletar(int id);
}