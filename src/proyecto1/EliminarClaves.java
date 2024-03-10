package proyecto1;
import java.util.*;
public class EliminarClaves {

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1000,"motorola");
        map.put(2000, "xiaomi");
        map.put(3000, "lenovo");
        map.put(4000, "lg");
        map.put(5000, "huawei");
        map.put(6000, "vivo");
        System.out.println("La lista Original de claves: "+ map);
        map.remove(4000);
        System.out.println(" Lista actualizada despues de eliminar las claves "+ map);
    }
}
