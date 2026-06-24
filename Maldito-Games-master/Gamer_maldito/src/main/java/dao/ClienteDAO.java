package dao;

import modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    void criar(Cliente cliente);
    Cliente buscarPorId(int id);
    List<Cliente> listar();
    void atualizar(Cliente cliente);
    void deletar(int id);
}