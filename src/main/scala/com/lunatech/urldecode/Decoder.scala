package com.lunatech.urldecode

import java.nio.charset.Charset

object Decoder {

  val pattern = """(%[0-9a-fA-F]{2})+""".r
  val charset = Charset.forName("UTF-8")

  def decode(str: String): String = {
    pattern.replaceAllIn(str, x => Decoder.decodeBytes(x.toString.split("%").tail.toList))
  }

  def fromHexToInt(hex: String): Int = {
    Integer.parseInt(hex, 16)
  }

  def decodeBytes(hexa: List[String]): String = {
    val bytes = hexa.map(fromHexToInt(_)).map(_.toByte)
    new String(bytes.toArray, 0, bytes.length, charset)
  }

}