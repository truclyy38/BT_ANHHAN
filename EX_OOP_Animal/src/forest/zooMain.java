package forest;

public class zooMain {
    public static void main(String[] args) {
        zooList dt = new zooList();
        dt.transDataToList();
        while (true) {
            int choice = menuForest.menu();
            switch (choice) {
                case 1:
                    dt.displayList1();
                    break;
                case 2:
                    dt.displayList();
                    break;
                case 3:
                    dt.sortList();
                    break;
                case 4:
                    dt.filterList();
                    break;
                case 5:
                    dt.addList();
                    break;
                case 6:
                    dt.viewAnimal();
                    break;
                case 7:
                    dt.editList();
                    break;
                case 8:
                    dt.deleteAnimal();
                    break;
                case 9:
                    dt.saveFile();
                    System.out.println("Finished! Thank you.");
                    return;
            }
        }

    }

}
