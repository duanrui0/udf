package com.byte.day01

import java.text.{DateFormat, ParseException, SimpleDateFormat}
import org.apache.hadoop.hive.ql.exec.{Description, UDF}
import org.apache.hadoop.io.Text
import org.apache.hadoop.hive.ql.exec.UDF
import org.apache.hadoop.io.Text
class time2time extends UDF{



//  下面这个是能用的
  private val inputDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
  private val outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

  def evaluate(inputDate: Text): Text = {
    if (inputDate == null) {
      return null
    }

    try {
      val date = inputDateFormat.parse(inputDate.toString)
      new Text(outputDateFormat.format(date))
    } catch {
      case ex: Exception => null
    }
  }
}
