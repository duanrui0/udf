package com_byte.demo

import scala.io.StdIn

object 模式匹配 {

  def main(args: Array[String]): Unit = {
    var str=1
    str match {
      case str if str >1 => print("daf")
      case str if str <1 => print("dshafuias")
      case str if str ==1 => print("shadiao")
    }

  }
}
