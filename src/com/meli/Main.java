package com.meli;

import com.meli.Cliente.Cliente;
import com.meli.Cliente.ClienteService;
import com.meli.Fatura.Fatura;
import com.meli.Fatura.FaturaService;
import com.meli.Item.Item;

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

        ClienteService clienteService = new ClienteService();
        FaturaService  faturaService = new FaturaService();

        clienteService.create(new Cliente("ID123", "Antonio", "Conselheiro"));
        clienteService.create(new Cliente("ID124", "Joao", "Batista"));
        clienteService.create(new Cliente("ID222", "Maria", "Silva"));

        clienteService.printAll();

        Cliente cliente = clienteService.read("ID124");
        cliente.setSobrenome("Amaral");
        clienteService.update(cliente);

        clienteService.printAll();

        Item item1 = new Item("K234","sorvete",3, 12.0);
        Item item2 = new Item("L224","laranja",6, 1.0);
        Item item3 = new Item("P554","Pão",2, 2.0);

        List<Item> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        items.add(item3);

        faturaService.create(new Fatura("F65443","ID123",items));
        faturaService.create(new Fatura("F65422","ID222",items));

        Fatura fatura1 = faturaService.read("F65443");
        System.out.println(fatura1);

//        deleteClients(clientes);



//        Scanner scanner = new Scanner(System.in);
//        String input;
//        System.out.println("\n1-consultar cliente ## 2-Sair");
//        input = scanner.nextLine();
//
//        while (input.equals("1")) {
//
//            searchCliente(clientes);
//
//            System.out.println("\n1-consultar cliente ## 2-Sair");
//            input = scanner.nextLine();
//        }
    }
}
