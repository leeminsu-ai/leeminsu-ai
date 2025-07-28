package day13;

public class Test06계산기 {

    public static void main(String[] args) {

        try {
            String birth = "2020-01-15";  // ← 날짜 형식을 yyyy-MM-dd로 정확히 입력
            if (birth.length() != 10) throw new Exception("날짜 형식이 잘못되었습니다");

            int year = Integer.parseInt(birth.substring(0, 4));
            int month = Integer.parseInt(birth.substring(5, 7));
            int date = Integer.parseInt(birth.substring(8, 10));

            int userTime = year * 12 + month;
            int userDay = convertToDays(year, month, date);

            System.out.println("year = " + year);
            System.out.println("month = " + month);
            System.out.println("date = " + date);

            int currentYear = 2025;
            int currentMonth = 7;
            int currentDate = 28;
            int currentTime = currentYear * 12 + currentMonth;
            int currentDay = convertToDays(currentYear, currentMonth, currentDate);

            // 생일이 미래인지 검사
            if ((currentTime < userTime) || (currentTime == userTime && currentDate < date)) {
                throw new Exception("생일은 미래일 수 없습니다");
            }

            // 나이 계산 (년 단위)
            int diff = currentTime - userTime;
            int globalAge = diff / 12;

            System.out.println("당신의 만나이는: " + globalAge + "세");

        } catch (Exception e) {
            System.out.println("처리 과정에서 오류 발생: " + e.getMessage());
        }
    }

    // 전달까지의 날짜 합계 구하는 함수
    public static int convertToDays(int year, int month, int date) {
        boolean isLeap = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
        int[] daysOfMonth = { 31, (isLeap ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = 0;

        for (int i = 0; i < month - 1; i++) {
            days += daysOfMonth[i];
        }

        days += date;

        return days;
    }
}

