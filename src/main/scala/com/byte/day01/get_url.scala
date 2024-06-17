package com.byte.day01

import org.apache.hadoop.hive.ql.exec.UDF

import java.util.regex.Pattern
import scala.collection.mutable.ArrayBuffer

class get_url extends UDF{

  def get_url2(url: String): ArrayBuffer[String] = {
    val pattern: Pattern = Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]")
    val matcher = pattern.matcher(url)
    val urlArr = ArrayBuffer[String]()

    while (matcher.find()) {
      urlArr.append(matcher.group())
    }

    if (!urlArr.isEmpty) {
      urlArr
    } else {
      throw new Exception("URL列表为空")
    }
  }
}
