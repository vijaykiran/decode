package com.lunatech.urldecode


import java.nio.charset.Charset

object DecoderOld {


  val patternHexa = """(%[0-9a-zA-Z]{0,})+""".r
  val charset = Charset.forName("UTF-8")

  def decode(str: String): String ={
    patternHexa.replaceAllIn(str, x => decodeBytes(x.toString.split("%").tail.toList))
  }

  def fromHexToInt(c: String): Int = {
    try {
      Integer.parseInt(c, 16)
    } catch {
      case e: Exception => throw new IllegalArgumentException("Illegal hex characters");
    }
  }
  def decodeBytes(hexa: List[String]): String = {
    val bytes = hexa.map(fromHexToInt(_)).map(_.toByte)
    new String(bytes.toArray, 0, bytes.length, charset)
  }

}
