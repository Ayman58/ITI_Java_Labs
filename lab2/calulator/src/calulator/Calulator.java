package calulator;

public class Calulator {
   public static void main(String[] args) {
    int result =0;
    int first = Integer.parseInt(args[0]);
    int secound= Integer.parseInt(args[2]);
    String op= args[1];
    switch(op){
        case "+" :
        result =first + secound;
        break;
        case "-" :
        result =first - secound;
        break;
        case "*" :
        result =first * secound;
        break;
        case "/" :
        result =first / secound;
        break;
    }
    System.out.println(result);

}
}
