import com.byte.day01.time2time
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.SparkSession

object MyUDF {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("MyUDF")
      .master("local")
//      .enableHiveSupport()
      .getOrCreate()

    val hiveContext = spark.sqlContext

    // 定义自定义函数逻辑
//    val myUDF = udf((s: String) => s.toUpperCase())
    val myUDF =new time2time
    // 注册自定义函数到HiveContext
//    hiveContext.udf.register("myUDF", myUDF)

    // 使用自定义函数查询Hive表
    val result = hiveContext.sql("SELECT myUDF('12/12/2023 00:00:00')")
    result.show()

    spark.stop()
  }
}
