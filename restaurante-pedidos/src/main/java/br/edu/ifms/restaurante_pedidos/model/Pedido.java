

package br.edu.ifms.restaurante_pedidos.model;

import java.util.Random;

import br.edu.ifms.restaurante_pedidos.enums.Categoria;

public class Pedido {
	
	private String cliente;
	private String nome;
    private int tempoDePreparo;
    private String categoria;
    private boolean prontoParaServir = false;
    
    public Pedido(String nome, int tempoDePreparo, String categoria, String cliente) {
    	this.cliente = cliente;
        this.nome = nome;
        this.tempoDePreparo = tempoDePreparo;
        this.categoria = categoria;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(int tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static int gerarTempoDePreparoAleatorio() {
        Random rand = new Random();
        return rand.nextInt(3901) + 100; 
    }
    
   
    public static String gerarCategoriaAleatoria() {
        String[] categorias = {"entrada", "prato principal", "sobremesa"};
        Random rand = new Random();
        int index = rand.nextInt(categorias.length);
        return categorias[index];
    }    

    public static Pedido criarPedidoAleatorio(Categoria categoria, String cliente) {
        int tempoDePreparo = gerarTempoDePreparoAleatorio();
        
        String categoriaPedido = categoria.toString();
        String nomePrato = categoria.getPratoAleatorio(categoria);      
        
        return new Pedido(nomePrato, tempoDePreparo, categoriaPedido, cliente);
    }
    
    public synchronized void marcarProntoParaServir( ) {
        prontoParaServir = true;
        notify();
    }

    public synchronized boolean estaProntoParaServir( ) {
        return prontoParaServir;
    }    
    
    @Override
  	public String toString() {
  		return "Pedido [cliente= " + cliente + ", nome= " + nome + ", tempoDePreparo= " + tempoDePreparo + ", categoria= " + categoria + "]";
  	}
}