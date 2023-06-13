import org.apache.hadoop.hive.ql.exec.UDF

import java.time.format.DateTimeFormatter

class timematch extends UDF {
  val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def timeStr {
    timeStr match {
      case """^(\d{4})-(\d{2})-(\d{2}) (\d{2})\:(\d{2})\:(\d{2})$""".r (year, month, day, hour, minute, second) =>
    val dateTime = LocalDateTime.of (year.toInt, month.toInt, day.toInt, hour.toInt, minute.toInt, second.toInt)
    Some (dateTime)

      case """^(\d{2})/(\d{2})/(\d{4}) (\d{2})\:(\d{2})\:(\d{2})$""".r (day, month, year, hour, minute, second) =>
    val dateTime = LocalDateTime.of (year.toInt, month.toInt, day.toInt, hour.toInt, minute.toInt, second.toInt)
    Some (dateTime)

      case _ => None
    }
  }
}
