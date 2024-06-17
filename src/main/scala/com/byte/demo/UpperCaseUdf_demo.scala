package com.byte.demo

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object UpperCaseUdf_demo {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.WARN)

    val spark = SparkSession.builder()
      .appName("HiveUDFInSparkApp").master("local")
      .enableHiveSupport() // 启用 Hive 支持
      .getOrCreate()

    // 注册 Hive 自定义 UDF
    spark.sql("CREATE TEMPORARY FUNCTION my_udf2 AS 'com.byte.day01.UpperCaseUDF'")

    // 使用 Hive 自定义 UDF
    val df = spark.sql("SELECT my_udf2('abc') ")


    df.show()

    spark.stop()
  }
}
