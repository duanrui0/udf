package com_byte.demo

//package com.byte.demo
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf
class aaaaa {
  def length(str: String): Int = {
    str.length
  }

  def registerLengthUDF(): UserDefinedFunction = {
    udf(length _)
  }
}
