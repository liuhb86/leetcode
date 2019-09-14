import java.time.LocalDate;
object Solution {
    val days = Array("", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
        val localDate = LocalDate.of(year, month, day);
        //Getting the day of week for a given date
        val dayOfWeek = localDate.getDayOfWeek();
        days(dayOfWeek.getValue)
    }
}