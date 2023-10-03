package br.edu.ifms.restaurante_pedidos.consumer;

import br.edu.ifms.restaurante_pedidos.model.Pedido;
import br.edu.ifms.restaurante_pedidos.queue.FilaPedidos;

public class Cozinheiro extends Thread {
    private FilaPedidos filaPedidos;

    public Cozinheiro(FilaPedidos filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = filaPedidos.removerPedido();
            System.out.println("Cozinheiro preparando o pedido: " + pedido);
            
            try {
                Thread.sleep(pedido.getTempoDePreparo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            pedido.marcarProntoParaServir();
            System.out.println("Pedido pronto: " + pedido);
        }
    }
}