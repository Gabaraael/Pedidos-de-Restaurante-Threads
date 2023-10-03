package br.edu.ifms.restaurante_pedidos;

import br.edu.ifms.restaurante_pedidos.consumer.Cozinheiro;
import br.edu.ifms.restaurante_pedidos.producer.Cliente;
import br.edu.ifms.restaurante_pedidos.queue.FilaPedidos;

public class App {
    public static void main(String[] args) {
        int numClientes = (int) (Math.random() * 31) + 20; 
        int numCozinheiros = (int) (Math.random() * 6) + 5; 

        FilaPedidos filaPedidos = new FilaPedidos();

        for (int i = 1; i <= numCozinheiros; i++) {
            Cozinheiro cozinheiro = new Cozinheiro(filaPedidos);
            cozinheiro.start();
        }

        for (int i = 1; i <= numClientes; i++) {
            Cliente cliente = new Cliente("Cliente " + i, filaPedidos);
            cliente.start();
        }
    }
}