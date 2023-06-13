package com.byte.day01

import org.apache.hadoop.hive.ql.exec.UDF
import org.apache.hadoop.io.Text

class UpperCaseUDF extends UDF {
  def evaluate(s: Text): Text = {
    if (s == null) {
      null
    } else {
      new Text(s.toString.toUpperCase)
    }
  }
}
