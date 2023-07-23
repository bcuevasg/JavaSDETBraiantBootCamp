package com.Tareas;


public class ReverseString {
    public static void main(String[] args) {
        String lista = "Java";
        String listaR = "";
        for(int i = lista.length()-1; i>=0;i--){
            //System.out.println();
            listaR += lista.charAt(i);
        }
        System.out.println(listaR);


        String reversed = lista.chars()
                .mapToObj(c -> (char)c)
                .reduce("",(s,c) -> c+s,(s1,s2) -> s2+s1 );
        System.out.println(reversed);

        String reversed1 = lista.chars()
                .collect(StringBuilder::new,
                        (b, c) -> b.insert(0, (char)c), (b1, b2) -> b1.insert(0, b2))
                .toString();
        System.out.println(reversed1);

    }
}
