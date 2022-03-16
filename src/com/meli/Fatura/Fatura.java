package com.meli.Fatura;

import com.meli.Cliente.Cliente;
import com.meli.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private String faturaId;

    private String clienteId;
    private List<Item> items;
    private double totalCompra;

    public Fatura() {
        this.items = new ArrayList<>();
    }

    public Fatura(String faturaId ,String clienteId, List<Item> items) {
        this.faturaId = faturaId;
        this.clienteId = clienteId;
        this.items = items;
        setTotalCompra();
    }

    public String getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(String faturaId) {
        this.faturaId = faturaId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
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

    private void setTotalCompra() {
        this.totalCompra = items.stream().map(item -> item.getQuantidade()*item.getCustoUnitario()).reduce(Double::sum).orElse(-1.0);
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "faturaId='" + faturaId + '\'' +
                ", clienteId='" + clienteId + '\'' +
                ", items=\n" + items +
                ",\ntotalCompra=" + totalCompra +
                '}';
    }
}
