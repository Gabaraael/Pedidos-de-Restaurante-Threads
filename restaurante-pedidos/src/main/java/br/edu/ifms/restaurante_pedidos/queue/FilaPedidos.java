package br.edu.ifms.restaurante_pedidos.queue;

import java.util.LinkedList;
import java.util.Queue;

import br.edu.ifms.restaurante_pedidos.model.Pedido;

public class FilaPedidos {
	
    private Queue<Pedido> fila = new LinkedList<>();

    public synchronized void adicionarPedido(Pedido pedido) {
        fila.offer(pedido);
        notify();
    }

    public synchronized Pedido removerPedido() {
        while (fila.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return fila.poll();
    }
}