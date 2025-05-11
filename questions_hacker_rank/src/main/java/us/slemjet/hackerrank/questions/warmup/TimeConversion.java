package us.slemjet.hackerrank.questions.warmup;

/**
 *
 */
public class TimeConversion {

    /**
     * Time:    O(1)
     * Space:   O(1)
     */
    public String timeConversion(String s) {
        // Write your code here

        String amPm = s.substring(s.length() - 2);

        String time = s.substring(0, s.length() - 2);
        String hour = s.substring(0, 2);

        if (amPm.equals("AM") && !hour.equals("12") || (hour.equals("12") && amPm.equals("PM"))) {
            return time;
        } else {
            int hourInt = Integer.parseInt(hour);
            hourInt += 12;
            hourInt %= 24;
            return String.format("%02d", hourInt) + time.substring(2);
        }
    }
}
