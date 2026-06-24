-- Inserção de dados de exemplo (DML)

INSERT INTO produto (nome, descricao, preco, quantidade_estoque, categoria) VALUES
('Notebook', 'Dell Inspiron 15', 3500.00, 10, 'Informática'),
('Mouse', 'Mouse óptico USB', 89.90, 50, 'Periféricos'),
('Teclado', 'Teclado mecânico RGB', 320.00, 30, 'Periféricos'),
('Monitor', 'Monitor 24'' Full HD', 1200.00, 15, 'Monitores'),
('Headset', 'Headset gamer 7.1', 450.00, 20, 'Áudio');

INSERT INTO cliente (nome, cpf, telefone, email, endereco) VALUES
('João Silva', '111.111.111-11', '(11) 99999-1111', 'joao@email.com', 'Rua A, 123'),
('Maria Oliveira', '222.222.222-22', '(11) 99999-2222', 'maria@email.com', 'Rua B, 456');

INSERT INTO venda (data_venda, valor_total, id_cliente, status_pagamento) VALUES
(CURRENT_DATE, 389.90, 1, 'PAGO'),
(CURRENT_DATE, 1520.00, 2, 'PENDENTE');

INSERT INTO item_venda (id_venda, id_produto, quantidade, subtotal) VALUES
(1, 2, 1, 89.90),  -- Mouse
(1, 3, 1, 300.00), -- Teclado (preço ajustado aqui, mas pode ser o da tabela)
(2, 4, 1, 1200.00), -- Monitor
(2, 5, 1, 320.00);  -- Headset (preço ajustado)

INSERT INTO pagamento (id_venda, forma_pagamento, valor_pago, data_pagamento) VALUES
(1, 'CARTAO', 389.90, CURRENT_DATE);