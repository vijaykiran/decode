package com.lunatech.urldecode
import scala.util.parsing.combinator._
import java.nio.charset.Charset
import scala.util.parsing.combinator.RegexParsers
import scala.util.matching.Regex
import scala.util.parsing.combinator._
import scala.util.parsing.json.Parser

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(306); 
  val substractingValue = 131;System.out.println("""substractingValue  : Int = """ + $show(substractingValue ));$skip(71); 

  def decodeByte(byte: Int): Int = {
    byte - substractingValue
  };System.out.println("""decodeByte: (byte: Int)Int""");$skip(76); 

  def fromHexToInt(hex: String): Int = {
    Integer.parseInt(hex, 16)
  };System.out.println("""fromHexToInt: (hex: String)Int""");$skip(403); 

  def decodeBytes(bytes: List[String]): Array[Char] = {
    def iter(bytes: List[String], acc: Int): Int = {
      if (bytes.isEmpty)
        acc
      else {
        val resI = fromHexToInt(bytes.head)

        println(resI)
        fromHexToInt(bytes.head) + iter(bytes.tail, acc)
      }

    }
    val adjusted = decodeByte(iter(bytes, 0))
    println(adjusted)
    Character.toChars(adjusted)
  };System.out.println("""decodeBytes: (bytes: List[String])Array[Char]""");$skip(54); 

  val str = "/download/images/fromage+pat%C3%A9.png";System.out.println("""str  : String = """ + $show(str ));$skip(37); 

  val pattern = "%[0-9a-fA-F]{2}".r;System.out.println("""pattern  : scala.util.matching.Regex = """ + $show(pattern ));$skip(125); 

  def parse(str: String): String = str match {
    case pattern => {
      println("1")
      ""
    }
    case _ => ""
  };System.out.println("""parse: (str: String)String""");$skip(116); 

  def parse2(str: String): String = {
    val charArray = str.toCharArray()
    charArray.map(iter2(_))
    ""
  };System.out.println("""parse2: (str: String)String""");$skip(118); 

  def iter2(ch: Char): String = str match {
    case "%" => {
      println("1")
      ""
    }
    case _ => ""
  };System.out.println("""iter2: (ch: Char)String""");$skip(15); val res$0 = 

  parse2(str);System.out.println("""res0: String = """ + $show(res$0));$skip(20); 

  val str2 = "%34";System.out.println("""str2  : String = """ + $show(str2 ));$skip(21); 

  val str1 = "%6df";System.out.println("""str1  : String = """ + $show(str1 ));$skip(20); 

  val str3 = "%6x"


    object CSV extends RegexParsers {

      case class Hexa(value: String)

      def TXT = "[^\",\r\n]".r

      def hexas: Parser[String] = """.+[%[0-9a-fA-F]{2}]+.+""".r ^^ { case ls => ls.mkString("") }

      def field: Parser[String] = (escaped | nonescaped)
      def escaped: Parser[String] = (hexas) ^^ { case ls => ls.mkString("") }
      def nonescaped: Parser[String] = (TXT*) ^^ { case ls => ls.mkString("") }

      def parse(s: String) = parseAll(field, s) match {
        case Success(res, e) => {
          val d=res
          val f=e
          println(res + " " + e)
        }
        case _ => List[List[String]]()
      }
    }

    //    class JSON extends RegexParsers {
    //      case class Hexa(value: String)
    //
    //      def hexas: Parser[String] = ".+[%[0-9a-fA-F]{2}]+.+".r
    //
    //      def hexa: Parser[Hexa] = hexas ^^ {
    //        case hexas => hexas match {
    //          case Some(hexas) => println(hexas.toString())
    //          case _ => println("f")
    //        }
    //      }
    //    }

    object MyParser extends JavaTokenParsers {
      val pattern = ".+[%[0-9a-fA-F]{2}]+.+".r
      def parse(str: String) {
        parseAll(pattern, str) match {
          case Success(result, d) => {

            println(result + " " + d)
          }
          case f => println(f)
        }
      }

    };System.out.println("""str3  : String = """ + $show(str3 ));$skip(1679); 
    //MyParser.parse("/download/images/fromage+pat%C3%A9.png")

    //val res1 = MyParser.parse("%C3%AB")

    //    object hexa extends CSV {
    //      def parse(str: String): Any = {
    //        parseAll(hexas, str)
    //      }
    //    }

    val kk2 = CSV.parse("/download/images/fromage+pat%C3%A9.png");System.out.println("""kk2  : Any = """ + $show(kk2 ));$skip(33); 
    val kk = CSV.parse("%C3%AB");System.out.println("""kk  : Any = """ + $show(kk ))}

  
  
  
}
