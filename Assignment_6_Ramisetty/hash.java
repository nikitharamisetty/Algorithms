import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;

public class hash {
    private int n = 31;
    private String hashTable[] = new String[n];
    private int size = 0;
    private int collisions = 0;
    boolean isPrime(int n){
        for(int j = 2; j < Math.sqrt(n); j++){
            if( n % j == 0)
                return false;
        }
        return true;
    }


    void insert(String str){
        int key = Cal_hash(str, n);
        int probing = 0;
        int location = (key + probing * probing) % n;

        if(size < n/2){
            while (hashTable[location] != null){
                probing++;
                collisions++;
                location = (key + probing * probing) % n;
            }
            hashTable[location] = str;

        } else {

            print_item(hashTable);
            System.out.println("\nNumber of Collisions before increasing the table size: " + collisions);

            collisions = 0;
            int temp = 2 * n;
            while(true){
                if(isPrime(temp))
                    break;
                else
                    temp++;
            }

            int temporarytable = temp;
            System.out.println("New table size: " + temporarytable);
            String tempTable[] = new String[temporarytable];

            for(int i = 0; i < n; i++){
                if(hashTable[i] != null){
                    key = Cal_hash(hashTable[i], temporarytable);
                    probing = 0;
                    location = (key + probing * probing) % temporarytable;

                    while(tempTable[location] != null){
                        probing++;
                        collisions++;
                        location = (key + probing * probing) % temporarytable;
                    }
                    tempTable[location] = hashTable[i];
                }
            }

            hashTable = Arrays.copyOf(tempTable, temporarytable);
            n = temporarytable;

            key = Cal_hash(str, n);
            probing = 0;
            location = (key + probing * probing) % n;

            while (hashTable[location] != null){
                probing++;
                collisions++;
                location = (key + probing * probing) % n;
            }
            hashTable[location] = str;
        }
        size++;
    }

    void print_item(String arr[]){

        System.out.println("Printing the hash table: ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null)
                System.out.println("Hash Table Key -> " + i + " , Value -> " + arr[i]);
            else
                System.out.println("Hash Table Key -> " + i + " , Value -> ");
        }
    }

    int Cal_hash(String s, int n){
        int k = 0;
        for(char c: s.toCharArray()){
            k += c;
        }

        k = k % (n);

        return k;
    }
    public static ArrayList<String> readFile(){
        ArrayList<String> words = new ArrayList<>(20);
        File file = new File("/Users/nkitharamisetty/Documents/ALGORITHMS/Assignment_6_Ramisetty/words.txt");
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null){
                words.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }


    public static void main(String[] args) {
        hash h = new hash();
        ArrayList<String> words = readFile();

        for(String i: words){
            h.insert(i);
        }
        System.out.println("\n Number of Collisions after we increased the table size: " + h.collisions);

        h.print_item(h.hashTable);
    }
}

