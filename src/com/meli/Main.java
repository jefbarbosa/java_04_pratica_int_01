package com.meli;

import com.meli.Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static void deleteClients(List<Cliente> clientes) {

        clientes.forEach(System.out::println);

        clientes.remove(2);
        System.out.println();
        clientes.forEach(System.out::println);
    }


    private static void searchCliente(List<Cliente> clientes) {
        System.out.println("Digite o Id do cliente");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Cliente> clienteTarget = clientes.stream().filter(cliente -> cliente.getID().equals(input)).collect(Collectors.toList());
        if (clienteTarget.size() == 0) {
            System.out.println("ID NOT FOUND!");
            return;
        }

        clienteTarget.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("ID123", "Antonio", "Conselheiro"));
        clientes.add(new Cliente("ID124", "Joao", "Batista"));
        clientes.add(new Cliente("ID222", "Maria", "Silva"));

        deleteClients(clientes);

        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("\n1-consultar cliente ## 2-Sair");
        input = scanner.nextLine();

        while (input.equals("1")) {

            searchCliente(clientes);

            System.out.println("\n1-consultar cliente ## 2-Sair");
            input = scanner.nextLine();
        }
    }
}
