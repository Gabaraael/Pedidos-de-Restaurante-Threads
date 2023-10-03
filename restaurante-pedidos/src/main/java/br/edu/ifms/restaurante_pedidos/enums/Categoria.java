package br.edu.ifms.restaurante_pedidos.enums;

import java.util.Random;

public enum Categoria {
    ENTRADA("Salada", "Sopa", "Bruschetta"),
    PRATO_PRINCIPAL("Bife à Parmegiana", "Frango Grelhado", "Lasanha"),
    SOBREMESA("Pudim", "Sorvete", "Torta de Chocolate");
    
    

    private final String[] valores;
    
    private final Random random = new Random();

    Categoria(String... valores) {
        this.valores = valores;
    }

    public String[] getValores() {
        return valores;
    }

    public String getPratoAleatorio(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula");
        }
        
        String[] valoresDaCategoria = categoria.getValores();
        
        if (valoresDaCategoria.length == 0) {
            throw new IllegalArgumentException("A categoria não possui valores");
        }

        int indiceAleatorio = random.nextInt(valoresDaCategoria.length);
        return valoresDaCategoria[indiceAleatorio];
    }

    public static Categoria getCategoriaPeloIndice(int indice) {
        if (indice >= 0 && indice < values().length) {
            return values()[indice];
        }
        throw new IllegalArgumentException("Índice de categoria inválido");
    }
}
