package com.meli.Cliente;

import com.meli.crud.CrudInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClienteService implements CrudInterface<Cliente> {

    List<Cliente> clientes;

    public ClienteService() {
        this.clientes = new ArrayList<>();
    }

    public ClienteService(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void create(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        OptionalInt intIndex = findId(cliente.getID());
        if (intIndex.isEmpty())
            return;

        clientes.set(intIndex.getAsInt(), cliente);
    }

    @Override
    public void delete(String clientID) {
        clientes.remove(findId(clientID).getAsInt());
    }

    @Override
    public Cliente read(String clientID) {
        return clientes.stream().filter(c -> c.getID().equals(clientID)).findFirst().stream().collect(Collectors.toList()).get(0);
    }

    @Override
    public OptionalInt findId(String clientID) {
        return IntStream.range(0, clientes.size())
                .filter(i -> clientID.equals(clientes.get(i).getID()))
                .findFirst();

    }

    public void printAll() {
        System.out.println();
        clientes.forEach(System.out::println);
    }


}
