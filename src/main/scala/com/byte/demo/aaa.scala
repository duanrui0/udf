package com_byte.demo

import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

object aaa {
  def length(str: String): Int = {
    str.length
  }

  def registerLengthUDF(): UserDefinedFunction = {
    udf(length _)
  }
}
