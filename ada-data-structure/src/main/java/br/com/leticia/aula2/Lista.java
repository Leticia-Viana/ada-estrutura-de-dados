package br.com.leticia.aula2;

public class Lista<T> {

    ItemListaEncadeada<T> primeiroItem;
    ItemListaEncadeada<T> ultimoItem;
    int tamanho = 0;

    public Lista() {
    }

    public static void main(String[] args) throws Exception {
        Lista<String> lista = new Lista<>();

        lista.add("Ana"); //0
        lista.add("André"); //1
        lista.add("Ultimo"); //2
        lista.add("Fábio"); //3
        lista.add("Leticia"); //4
        lista.add("Michele"); //5
        lista.add("Odair"); //6
        lista.add("Andrws"); //7
        lista.add("Laura"); //8

        System.out.println(lista.get(6));
        System.out.println(lista.getOptimized(6));
        lista.printList();
    }

    public T add(T dado) {
        if (primeiroItem == null) {
            this.primeiroItem = new ItemListaEncadeada<>();
            primeiroItem.setDado(dado);
            ultimoItem = primeiroItem;
        } else {
            ItemListaEncadeada<T> item = new ItemListaEncadeada<>();
            item.setDado(dado);
            item.setAnterior(ultimoItem);
            ultimoItem.setProximo(item);
            ultimoItem = item;
        }
        tamanho++;
        return dado;
    }

    //Implementação exercício 2
    public T getOptimized(int posicao) {
        ItemListaEncadeada<T> item;
        if (posicao >= (tamanho / 2 + 1)) {
            item = ultimoItem;
            int i;
            for ( i = 1; i < tamanho - posicao; i++) {
                item = item.getAnterior();
            }
            System.out.println( i + " interações otimizadas");
        } else {
            item = primeiroItem;
            int i;
            for ( i = 0; i < posicao; i++) {
                item = item.getProximo();
            }
            System.out.println(i + " interações otimizadas");
        }
        return item.getDado();
    }

    public T get(int posicao) throws Exception {
        this.validateRulesList(posicao);
        if (posicao == 0) return primeiroItem.getDado();
        ItemListaEncadeada<T> item = primeiroItem;
        int i;
        for ( i = 0; i < posicao; i++) {
            item = item.getProximo();
        }
        System.out.println( i + " interações normais");
        return item.getDado();
    }


    private ItemListaEncadeada<T> getItem(int posicao) throws Exception {
        this.validateRulesList(posicao);

        if (posicao == 0) return primeiroItem;

        ItemListaEncadeada<T> item = primeiroItem;

        for (int i = 0; i < posicao; i++) {
            item = item.getProximo();
        }
        return item;
    }

    public T remove(int posicao) throws Exception {

        if (posicao == 0) {
            T dado = primeiroItem.getDado();
            primeiroItem = primeiroItem.getProximo();
            return dado;
        }

        ItemListaEncadeada<T> itemAtual = this.getItem(posicao);
        ItemListaEncadeada<T> itemAnterior = itemAtual.getAnterior();

        if (itemAtual == ultimoItem) {
            ultimoItem = itemAnterior;
            itemAnterior.setProximo(null);
        } else {
            itemAnterior.setProximo(itemAtual.getProximo());
        }

        return itemAtual.getDado();
    }

    public T validateRulesList(int posicao) throws Exception {
        if (posicao < 0) throw new Exception("Posição não pode ser negativa");
        if (posicao >= tamanho) throw new IndexOutOfBoundsException("Posição acima do tamanho da lista");

        return null;
    }

    public void printList() {
        ItemListaEncadeada<T> item = primeiroItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " + primeiroItem.getDado());
        System.out.println("ultimoItem: " + ultimoItem.getDado());

        while (item.getProximo() != null) {
            System.out.println(item.getDado());
            item = item.getProximo();
        }

        System.out.println(item.getDado());
    }

    public void printListReverse() {
        ItemListaEncadeada<T> item = ultimoItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " + ultimoItem.getDado());
        System.out.println("ultimoItem: " + primeiroItem.getDado());

        while (item.getAnterior() != null) {
            System.out.println(item.getDado());
            item = item.getAnterior();
        }

        System.out.println(item.getDado());
    }

}


