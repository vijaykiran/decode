package com.lunatech.urldecode

import java.nio.charset.Charset
import java.lang.IllegalArgumentException

object DecoderBis {
  val patternHexa = """(%[0-9a-zA-Z]{0,})+""".r
  val charset = Charset.forName("UTF-8")

  def decode(str: String): String = {
    def iterate(str: String, acc: List[Byte]): List[Byte] = {
      val subs = patternHexa.findFirstIn(str).map { subs =>
        subs match {
          case _ if (subs.length() % 3 != 0) => throw new IllegalArgumentException("Illegal hex characters" + subs);
          case _ => {
            val prefix = str.substring(0, str.indexOf(subs))
            val suffix = str.substring(str.indexOf(subs) + subs.length(), str.length())
            val toBeConverted = subs.toString.split("%").tail.toList
            val converted = toBeConverted.map(x => fromHexToInt(x))
            iterate(suffix, prefix.getBytes(charset).toList ::: converted)
          }
        }
      }
      acc ::: subs.getOrElse(str.getBytes(charset).toList)
    }
    val bytes = iterate(str, List[Byte]())
    new String(bytes.toArray, charset)
  }

  def fromHexToInt(c: String): Byte = {
    try {
      (Integer.parseInt(c, 16)).toByte
    } catch {
      case e: Exception => throw new IllegalArgumentException("Illegal hex characters");
    }
  }

  def decodeBytes(hexa: List[String]): String = {
    val bytes = hexa.map(fromHexToInt(_)).map(_.toByte)
    new String(bytes.toArray, 0, bytes.length, charset)
  }

}