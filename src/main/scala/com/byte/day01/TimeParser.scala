package com.byte.day01

import org.apache.hadoop.hive.ql.exec.UDF

import java.text.SimpleDateFormat
import java.util.Date

class TimeParser extends UDF{

  def evaluate(input: String): String = {
    val sdf1 = new SimpleDateFormat("yyyy-MM-dd")
    val sdf2 = new SimpleDateFormat("yyyy/MM/dd")
    val sdf3 = new SimpleDateFormat("yyyy年MM月dd日")
    val sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val sdf5 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    val sdf6 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒")
    val sdf7 = new SimpleDateFormat("yyyyMMdd")
    val sdf8 = new SimpleDateFormat("yyyyMMddHHmmss")
    val sdf9 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val sdf10 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")
    val sdf11 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")

    var date: Date = null
    var output: String = null

    if (input == null) {
      return null
    }

    try {
      date = sdf1.parse(input)
    } catch {
      case e1: Exception =>
        try {
          date = sdf2.parse(input)
        } catch {
          case e2: Exception =>
            try {
              date = sdf3.parse(input)
            } catch {
              case e3: Exception =>
                try {
                  date = sdf4.parse(input)
                } catch {
                  case e4: Exception =>
                    try {
                      date = sdf5.parse(input)
                    } catch {
                      case e5: Exception =>
                        try {
                          date = sdf6.parse(input)
                        } catch {
                          case e6: Exception =>
                            try {
                              date = sdf7.parse(input)
                            } catch {
                              case e7: Exception =>
                                try {
                                  date = sdf8.parse(input)
                                } catch {
                                  case e8: Exception =>
                                    try {
                                      date = sdf9.parse(input)
                                    } catch {
                                      case e9: Exception =>
                                        try {
                                          date = sdf10.parse(input)
                                        } catch {
                                          case e10: Exception =>
                                            try {
                                              date = sdf11.parse(input)
                                            } catch {
                                              case e11: Exception =>
                                                return null
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    output = sdf4.format(date) // 转换为标准时间格式 yyyy-MM-dd HH:mm:ss
    output
  }
}
