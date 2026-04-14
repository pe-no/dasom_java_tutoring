import java.util.Scanner;

// TODO 21: 동아리 부원 관리 시스템
public class Main {
    // TODO 22
    static final String CLUB_NAME = "DASOM";

    public static void main(String[] args) {
        // TODO 23
        ClubManager<Member> manager = new ClubManager<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== " + CLUB_NAME + " 백엔드 과제 시스템 ===");

        // TODO 24
        String[] menu = {"1. 부원 등록", "2. 특별 활동", "3. 종료"};

        // TODO 25
        while (true) {
            System.out.println("\n--- 메뉴 ---");
            for (String item : menu) {
                System.out.println(item);
            }
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            // TODO 26
            try {
                if (choice.equals("1")) {
                    System.out.print("이름: "); String name = scanner.nextLine();
                    System.out.print("학번: "); String id = scanner.nextLine();

                    // TODO 27
                    Member newMember = new Admin(name, id);

                    // TODO 28
                    manager.addMember(newMember);
                }
                else if (choice.equals("2")) {
                    for (Member m : manager.getMembers()) {
                        m.performRole();
                        if (m instanceof Admin) {
                            Admin admin = (Admin) m;
                            admin.manageServer();
                        }
                    }
                }
                else if (choice.equals("3")) {
                    System.out.println("종료합니다.");
                    break;
                }
            } catch (DuplicateException e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
        scanner.close();
    }
}