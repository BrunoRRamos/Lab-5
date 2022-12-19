package documin;

import documin.documento.Utilitarios;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList elemt = new ArrayList();

        elemt.add(1);
        elemt.add(2);
        elemt.add(3);
        elemt.add(4);
        elemt.add(5);
        printaArray(elemt);
        System.out.println();
        moveParaBaixo(elemt, 2);
        printaArray(elemt);


    }

    public static void moveParaCima(ArrayList arrayList, int posicao) {
        if ((posicao - 1) > 0) {
            Utilitarios.mudaPosicao(arrayList, posicao, posicao - 1);
        }
    }

    public static void moveParaBaixo(ArrayList arrayList, int posicao) {
        if ((posicao + 1) < arrayList.size() - 1) {
            Utilitarios.mudaPosicao(arrayList, posicao, posicao + 1);
        }
    }

    public static void printaArray(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

}
