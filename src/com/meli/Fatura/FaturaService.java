package com.meli.Fatura;

import com.meli.Cliente.Cliente;
import com.meli.crud.CrudInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FaturaService implements CrudInterface<Fatura> {

    List<Fatura> faturas;

    public FaturaService() {
        this.faturas = new ArrayList<>();
    }

    @Override
    public void create(Fatura fatura) {
        faturas.add(fatura);
    }

    @Override
    public void update(Fatura fatura) {
        OptionalInt intIndex = findId(fatura.getFaturaId());
        if (intIndex.isEmpty())
            return;

        faturas.set(intIndex.getAsInt(), fatura);
    }

    @Override
    public void delete(String id) {
        faturas.remove(findId(id).getAsInt());
    }

    @Override
    public Fatura read(String id) {
        return faturas.stream().filter(c -> c.getFaturaId().equals(id)).findFirst().stream().collect(Collectors.toList()).get(0);
    }

    @Override
    public OptionalInt findId(String faturaId) {
        return IntStream.range(0, faturas.size())
                .filter(i -> faturaId.equals(faturas.get(i).getFaturaId()))
                .findFirst();
    }
}
