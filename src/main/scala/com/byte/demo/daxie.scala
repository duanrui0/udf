package com.byte.demo
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.SparkSession

class daxie {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("MyUDF")
      .master("local")
      //      .enableHiveSupport()
      .getOrCreate()

    val hiveContext = spark.sqlContext

    // 定义自定义函数逻辑
    val myUDF = udf((s: String) => s.toUpperCase())

    // 注册自定义函数到HiveContext
    hiveContext.udf.register("myUDF", myUDF)

    // 使用自定义函数查询Hive表
    val result = hiveContext.sql("SELECT myUDF('abs')")
    result.show()

    spark.stop()
  }
}
