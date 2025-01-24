import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Manager {

  public void addStudent(List<Student> studentList, Scanner scanner) {
    String name = "";
    int score;

    System.out.println("学生データを追加します。");
    System.out.print("名前を入力してください:");
    if (scanner.hasNext()) {
      name = scanner.next();
    }

    System.out.print("点数を入力してください");
    try {
      score = scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("点数は整数で入力してください");
      return;
    }
    System.out.println("次の学生データを追加しました");
    System.out.println("名前：" + name + ", 点数：" + score);
    Student student = new Student(name, score);
    studentList.add(student);
  }

  public void deleteStudent(List<Student> studentList, Scanner scanner, int studentListCounter) {
    System.out.print("削除する学生データの名前を入力してください:");
    if (scanner.hasNext()) {
      String name = scanner.next();
      studentList.removeIf(student -> student.getName().equals(name));
    }
    //カウンターと比べた増減で削除件数を表示
    if (studentListCounter > studentList.size()) {
      System.out.println(
          "学生データを" + (studentListCounter - studentList.size()) + "件削除しました");
    } else {
      System.out.println("一致する学生データは存在しませんでした");
    }
  }

  public void updateScore(List<Student> studentList, Scanner scanner) {
    String name = "";
    int score;
    boolean isExist = false;

    System.out.println("学生データを更新します。");
    System.out.print("更新する学生データの名前を入力してください:");

    if (scanner.hasNext()) {
      name = scanner.next();
    }

    System.out.print("新しい点数を入力してください:");
    try {
      score = scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("点数は整数で入力してください");
      return;
    }

    for (Student student : studentList) {
      if (student.getName().equals(name)) {
        student.setScore(score);
        System.out.println("学生データを更新しました");
        System.out.println("名前：" + name + ", 点数：" + score);
        isExist = true;
      }
    }

    if (!isExist) {
      System.out.println("一致する学生データは存在しませんでした");
    }
  }

  public void calculateAverage(List<Student> studentList) {
    List<Integer> scoreList = new ArrayList<>();
    DecimalFormat displayFormat = new DecimalFormat("##.#");
    double average;

    if (studentList.isEmpty()) {
      System.out.println("学生データがありません");
    } else {
      System.out.print("平均点は：");

      studentList
          .forEach(student -> scoreList.add(student.getScore()));

      average = scoreList.stream()
          .mapToInt(Integer::intValue)
          .average()
          .getAsDouble();

      System.out.println((int) average + "点です");
    }
  }

  public void displayAll(List<Student> studentList) {

    if (studentList.isEmpty()) {
      System.out.println("学生データがありません。");
    } else {
      System.out.println("学生一覧を表示します");
      for (Student student : studentList) {
        System.out.println("名前：" + student.getName() + ", 点数：" + student.getScore());
      }
    }
  }

}
