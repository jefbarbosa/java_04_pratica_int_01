package com.meli.Fatura;

import com.meli.Cliente.Cliente;
import com.meli.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Fatura() {
        this.items = new ArrayList<>();
    }

    public Fatura(Cliente cliente, List<Item> items, double totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
