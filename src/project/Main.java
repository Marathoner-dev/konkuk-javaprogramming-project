package project.src.project;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        FileIO fileIO = new FileIO(menu.getSubjects());

        fileIO.load();
        menu.startMenu();
        fileIO.save();
    }
}
