package proyecto1;
import java.util.*;
public class PromedioValores {
    public static void main(String[] args) {

        HashMap<String, List<Integer>> studentGrades = new HashMap<>();
        studentGrades.put("Anderson", Arrays.asList(21, 22, 23));
        studentGrades.put("Maria", Arrays.asList(22, 23, 24));
        studentGrades.put("Juan", Arrays.asList(48, 49, 50));
        studentGrades.put("Camilo", Arrays.asList(30, null, 31));
        studentGrades.put("Andrea", Arrays.asList(50, 50, 50));
        studentGrades.put("Sofia", Arrays.asList(0, 25, 50));
        studentGrades.put("Luara", Arrays.asList(25, 30, null));
        studentGrades.put("cristian", Arrays.asList(null, 15, null));

        for (Map.Entry<String, List<Integer>> studentGrade : studentGrades.entrySet()) {
            List<Integer> grades = studentGrade.getValue();
            int sum = 0;
            int count = 0;
            for (Integer grade : grades) {
                if (grade != null) {
                    sum += grade;
                    count++;
                }
            }
            double promedio = (double) sum / count;
            System.out.println(studentGrade.getKey() + "  Su promedio essgir : " + promedio);
        }
    }

}
