package com.lunatech.urldecode

object test2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  val str1 ="/download/images/fromage+pat%C3%A9.png";System.out.println("""str1  : String = """ + $show(str1 ));$skip(21); 
   val str2="%C3%AB";System.out.println("""str2  : String = """ + $show(str2 ));$skip(48); 
   
   val pattern = """(%[0-9a-fA-F]{2})+""".r;System.out.println("""pattern  : scala.util.matching.Regex = """ + $show(pattern ));$skip(96); val res$0 = 
   
   
   pattern.replaceAllIn(str1,x=>Decoder.decodeBytes(x.toString.split("%").tail.toList));System.out.println("""res0: String = """ + $show(res$0))}
   
   
  
}
