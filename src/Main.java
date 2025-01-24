import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int number = 0;
    int studentListCounter = 0;

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
        case (0):
          //1~6の整数が入力されなかった場合はメッセージを表示し選択肢を表示
          break;
        case (1):
          manager.addStudent(studentList, scanner);
          break;
        case (2):
          //リストの増減をチェックするためのカウンターに削除前のリスト数を保存
          studentListCounter = studentList.size();
          manager.deleteStudent(studentList, scanner, studentListCounter);
          break;
        case (3):
          manager.updateScore(studentList, scanner);
          break;
        case (4):
          manager.calculateAverage(studentList);
          break;
        case (5):
          manager.displayAll(studentList);
          break;
        case (6):
          System.out.println("終了します");
          break;
      }
      scanner.nextLine();
    }
    scanner.close();
  }
}
