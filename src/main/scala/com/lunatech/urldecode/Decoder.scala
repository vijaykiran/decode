package com.lunatech.urldecode

import java.nio.charset.Charset
import java.lang.IllegalArgumentException

object Decoder {

  val charset = Charset.forName("UTF-8")

  /**
   * Decode %-Hexadecimal encoded characters from a given string
   *
   * Input:  String
   * Output: String
   */
  def decode(str: String): String = {
    val encoded = str.toCharArray()
    val decoded = new Array[Byte](encoded.length)
    var i = 0
    var j: Int = 0

    for (x <- 0 until encoded.length) {
      if (x == i) {
        if (encoded(i) == '%') {
          if (i + 2 >= encoded.length)
            throw new IllegalArgumentException("Incomplete trailing escape (%) pattern " + i);
          else {
            val value = fromHexToInt((encoded(i + 1) +: Array[Char]() :+ encoded(i + 2)) mkString "")
            decoded(j) = value.toByte
            i = i + 3
          }

        } else {
          decoded(j) = encoded(i).toByte
          i = i + 1
        }
        j = j + 1
      }
    }
    new String(decoded, 0, j, charset)
  }

  def fromHexToInt(c: String): Int = {
    try {
      Integer.parseInt(c, 16)
    } catch {
      case e: Exception => throw new IllegalArgumentException("Illegal hex characters");
    }
  }
}
