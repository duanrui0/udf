import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object HiveUDFInSparkApp {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.WARN)

    val spark = SparkSession.builder()
      .appName("HiveUDFInSparkApp").master("local")
      .enableHiveSupport() // 启用 Hive 支持
      .getOrCreate()

    // 注册 Hive 自定义 UDF
    spark.sql("CREATE TEMPORARY FUNCTION my_udf AS 'com.byte.day01.time2time'")

    // 使用 Hive 自定义 UDF
    val df = spark.sql("SELECT my_udf('06/15/2022 16:34:12') ")

    df.show()

    spark.stop()
  }
}
