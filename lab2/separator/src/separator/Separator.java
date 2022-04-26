package separator;
public class Separator {
    public static void main(String[] args) {
        String str = new String();
        for(int i=0; i<args.length;i++){
          str+= args[i];
        }
        String[] Arr= str.split("\\.",20);
        for (int i=0; i<Arr.length;i++){
            System.out.println(Arr[i]);
        }
    }  
}
