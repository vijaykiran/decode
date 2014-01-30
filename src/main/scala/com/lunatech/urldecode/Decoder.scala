package com.lunatech.urldecode

import java.nio.charset.Charset
import java.net.URISyntaxException

object Decoder {

  val charset = Charset.forName("UTF-8")

  def decode2(str: String): String = {
    val encoded = str.getBytes(charset)
    val decoded = new Array[Byte](encoded.length)
    var i = 0
    var j: Int = 0
    for (x <- 0 until encoded.length) {
       if (x == i) {
        if (encoded(i) == '%') {
          if (i + 2 >= encoded.length)
            throw new URISyntaxException(str, "Invalid URL-encoded string at char " + i);
          else {
            i = i + 1
            val first = encoded(i)
            i = i + 1
            val second = encoded(i)
            i = i + 1
            val value = fromHexToInt(first) * 16 + fromHexToInt(second)
            decoded(j) = value.toByte
          }

        } else {
          decoded(j) = encoded(i)
          i =i +1
        }
        j = j + 1
      }
    }
    new String(decoded, 0, j, charset)
  }                                             

  def fromHexToInt(b: Byte): Byte = b match {
    case '0' => 0
    case '1' => 1
    case '2' => 2
    case '3' => 3
    case '4' => 4
    case '5' => 5
    case '6' => 6
    case '7' => 7
    case '8' => 8
    case '9' => 9
    case 'a' => 10
    case 'A' => 10
    case 'b' => 11
    case 'B' => 11
    case 'c' => 12
    case 'C' => 12
    case 'd' => 13
    case 'D' => 13
    case 'e' => 14
    case 'E' => 14
    case 'f' => 15
    case 'F' => 15
    case _ => throw new URISyntaxException(String.valueOf(b), "Invalid URL-encoded string");
  }
}
