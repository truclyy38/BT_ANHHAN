package forest;

import java.util.Comparator;
public class AnimalComparator implements Comparator<Animal> {
 
    // Ghi đè phương thức compare.
    @Override
    public int compare(Animal o1, Animal o2) {
        // Hai đối tượng null coi như bằng nhau.
        if (o1 == null && o2 == null) {
            return 0;
        }
        // Nếu o1 là null, coi như o2 lớn hơn
        if (o1 == null) {
            return -1;
        }
        // Nếu o2 là null, coi như o1 lớn hơn.
        if (o2 == null) {
            return 1;
        }
        
        // Nguyên tắc:
        int value;
        // Sắp xếp tăng dần theo loại động vật
        value = o1.getKind().compareTo(o2.getKind());
        if (value != 0) 
        return value;
        // Nếu loại giống nhau, sắp xếp tăng dần theo tên
        value = o1.getName().compareTo(o2.getName());
        if (value != 0) 
        return value;
        // Sắp xếp tăng dần theo tuổi
        value = o1.getAge() - o2.getAge();
        if (value != 0) 
        return value;
        // Sắp xếp tăng dần theo giá
        value = o1.getCost() - o2.getCost();
        return value;
    }
 
}