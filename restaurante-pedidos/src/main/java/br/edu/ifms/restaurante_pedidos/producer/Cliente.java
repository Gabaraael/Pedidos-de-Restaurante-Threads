package br.edu.ifms.restaurante_pedidos.producer;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.restaurante_pedidos.enums.Categoria;
import br.edu.ifms.restaurante_pedidos.model.Pedido;
import br.edu.ifms.restaurante_pedidos.queue.FilaPedidos;

public class Cliente extends Thread {
	private String nome;
	private List<Pedido> pedidos;
	private FilaPedidos filaPedidos;

	public Cliente(String nome, FilaPedidos filaPedidos) {
		this.nome = nome;
		this.pedidos = new ArrayList<>();
		this.filaPedidos = filaPedidos;
	}

	@Override 
	public void run() {
		for (int i = 0; i < 3; i++) {
			Categoria categoria = Categoria.getCategoriaPeloIndice(i);

			Pedido pedido = Pedido.criarPedidoAleatorio(categoria, nome);
			System.out.println(nome + " fez o pedido: " + pedido);
			pedidos.add(pedido);
			filaPedidos.adicionarPedido(pedido);

			synchronized (pedido) {
				while (!pedido.estaProntoParaServir()) {
					try {
						pedido.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			System.out.println(nome + " consumiu o pedido: " + pedido);
		}
	}
}
