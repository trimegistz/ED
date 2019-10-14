import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class StringList implements Comparator<String>{

    @Override
    public int compare(String s1, String s2){
        return s1.length() -s2.length();
    }

    public static void main(String[] args){
        String s1 = new String("A");
        String s2 = new String("dlfjkc");
        String s3 = new String("odghfdkvc");
        String s4 = new String("oifsjdmadsadsads");
        String s5 = new String("dlfjgj");
        String s6 = new String("sdlkurew");
        String s7 = new String("sdlfjearurei");

        ArrayList<String> list = new ArrayList<String>();
        StringList ss = new StringList() ;

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);

        Collections.sort(list, ss);
        System.out.println(list);

    }
}