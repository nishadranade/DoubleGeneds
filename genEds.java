import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {
    public static void main(String[] args) {
        List < String > superList = new ArrayList < String > ();
        Set < String > duplicates = new HashSet < String > ();
        Set < String > rejects = new HashSet < String > ();
        try {
            File f = new File("C:\\Users\\nisha\\Desktop\\genEds.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            //
            //
            //
            //
            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                superList.add(readLine);
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s: superList) {
            System.out.println(s);
        }
        System.out.println("****************************");
        for (int i = 0; i < superList.size(); i++) {
            for (int j = 0; j < superList.size(); j++) {
                if (i != j) {
                    String s1 = superList.get(i);
                    String s2 = superList.get(j);
                    int l1 = s1.length();
                    int l2 = s2.length();
                    if (s1.substring(l1 - 10, l1).equals(s2.substring(l2 - 10, l2))) {
                        if (s1.substring(2).equals(s2.substring(2))) {
                            if (!(s1.startsWith("I") || s2.startsWith("I"))) {
                                if (!(rejects.contains(s1) || rejects.contains(s2))) {
                                    duplicates.add(s2.substring(0, 2) + " " + s1);
                                }
                                rejects.add(s1);
                                rejects.add(s2);
                            }
                        }
                        if (s1.substring(2).equals(s2.substring(3))) {
                            if (!(s1.startsWith("I") || s2.startsWith("I"))) {
                                if (!(rejects.contains(s1) || rejects.contains(s2))) {
                                    duplicates.add(s2.substring(0, 3) + " " + s1);
                                }
                                rejects.add(s1);
                                rejects.add(s2);
                            }
                        }
                        if (s1.substring(3).equals(s2.substring(1))) {
                            if (!(s1.startsWith("I") || s2.startsWith("I"))) {
                                if (!(rejects.contains(s1) || rejects.contains(s2))) {
                                    duplicates.add(s2.substring(0, 2) + " " + s1);
                                }
                                rejects.add(s1);
                                rejects.add(s2);
                            }
                        }
                        if (s1.substring(3).equals(s2.substring(2))) {
                            if (!(s1.startsWith("I") || s2.startsWith("I"))) {}
                        }
                        if (!(rejects.contains(s1) || rejects.contains(s2))) {
                            duplicates.add(s2.substring(0, 2) + " " + s1);
                        }
                        rejects.add(s1);
                        rejects.add(s2);
                    }
                }
            }
            List < String > dupli = new ArrayList < String > (duplicates);
            dupli.sort(null);
            for (String s7: dupli) {
                System.out.println(s7);
            }
        }
    }
