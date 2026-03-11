package main;

import model.*;
import view.*;

public class Main {

    public static void main(String[] args) {

        Onibus onibus = new Onibus(10);

        PainelCentral painel = new PainelCentral();
        Quiosque q1 = new Quiosque("QUIOSQUE 1");
        Quiosque q2 = new Quiosque("QUIOSQUE 2");

        onibus.addAssentoListener(painel);
        onibus.addAssentoListener(q1);
        onibus.addAssentoListener(q2);

        System.out.println("\n======================================");
        System.out.println("ATUALIZAÇÃO DO SISTEMA DE ASSENTOS:");
        System.out.println("======================================\n");
        
        System.out.println("Cliente reservando assento 6...\n");
        onibus.reservarAssento(6);
       
        System.out.println("\n======================================");
        System.out.println("ATUALIZAÇÃO DO SISTEMA DE ASSENTOS:");
        System.out.println("======================================\n");

        System.out.println("Cliente reservando assento 3...\n");
        onibus.reservarAssento(3);

        System.out.println("\n======================================");
        System.out.println("ATUALIZAÇÃO DO SISTEMA DE ASSENTOS:");
        System.out.println("======================================\n");
        
        System.out.println("Cliente comprando assento 2...\n");
        onibus.comprarAssento(2);
        
        System.out.println("\n======================================");
        System.out.println("ATUALIZAÇÃO DO SISTEMA DE ASSENTOS:");
        System.out.println("======================================\n");
        
        System.out.println("Cliente comprando assento 1...\n");
        onibus.comprarAssento(1);
        
        System.out.println("\n======================================");
        System.out.println("ATUALIZAÇÃO DO SISTEMA DE ASSENTOS:");
        System.out.println("======================================\n");
        
        System.out.println("Cliente comprando assento 1...\n"); // vai sair a mensagem de assento indisponivel (da classe onibus)
        onibus.comprarAssento(1);
        
        System.out.println("\n======================================");
        System.out.println("ATUALIZAÇÃO DO SISTEMA DE ASSENTOS:");
        System.out.println("======================================\n");
        
        System.out.println("Cliente reservando assento 3...\n"); //mensagem de assento reservado/ocupado
        onibus.reservarAssento(3);
        
    }
}