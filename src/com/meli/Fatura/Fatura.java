package com.meli.Fatura;

import com.meli.Cliente.Cliente;
import com.meli.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private String clienteId;
    private List<Item> items;
    private double totalCompra;

    public Fatura() {
        this.items = new ArrayList<>();
    }

    public Fatura(String clienteId, List<Item> items, double totalCompra) {
        this.clienteId = clienteId;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public String getCliente() {
        return clienteId;
    }

    public void setCliente(String clienteId) {
        this.clienteId = clienteId;
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
