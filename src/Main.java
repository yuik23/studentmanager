import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int number = 0;
    int studentListCounter = 0;
    final int PASS_NUMBER = 0;
    final int ADD_STUDENT_MENU_NUMBER = 1;
    final int DELETE_STUDENT_MENU_NUMBER = 2;
    final int UPDATE_STUDENT_MENU_NUMBER = 3;
    final int CALCULATE_STUDENT_MENU_NUMBER = 4;
    final int DISPLAY_STUDENT_MENU_NUMBER = 5;
    final int EXIT_STUDENT_MENU_NUMBER = 6;

    List<Student> studentList = new ArrayList<>();
    Manager manager = new Manager();
    Scanner scanner = new Scanner(System.in);

    //6.終了が選択されるまで選択肢の表示をループ
    while (number != 6) {
      number = 0;
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");
      System.out.print("選択してください:");

      if (scanner.hasNextInt()) {
        number = scanner.nextInt();
      } else {
        System.out.println("1~6の整数を入力してください");
      }

      switch (number) {
        case (PASS_NUMBER):
          //1~6の整数が入力されなかった場合はメッセージを表示し選択肢を表示
          break;
        case (ADD_STUDENT_MENU_NUMBER):
          manager.addStudent(studentList, scanner);
          break;
        case (DELETE_STUDENT_MENU_NUMBER):
          //リストの増減をチェックするためのカウンターに削除前のリスト数を保存
          studentListCounter = studentList.size();
          manager.deleteStudent(studentList, scanner, studentListCounter);
          break;
        case (UPDATE_STUDENT_MENU_NUMBER):
          manager.updateScore(studentList, scanner);
          break;
        case (CALCULATE_STUDENT_MENU_NUMBER):
          manager.calculateAverage(studentList);
          break;
        case (DISPLAY_STUDENT_MENU_NUMBER):
          manager.displayAll(studentList);
          break;
        case (EXIT_STUDENT_MENU_NUMBER):
          System.out.println("終了します");
          break;
      }
      scanner.nextLine();
    }
    scanner.close();
  }
}
