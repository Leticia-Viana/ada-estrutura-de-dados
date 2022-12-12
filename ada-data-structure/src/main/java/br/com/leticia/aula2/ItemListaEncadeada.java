package br.com.leticia.aula2;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemListaEncadeada<T> {

    private T dado;
    private ItemListaEncadeada<T> anterior;
    private ItemListaEncadeada<T> proximo;
}
