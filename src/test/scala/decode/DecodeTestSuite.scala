package decode

import org.specs2.mutable._
import com.lunatech.urldecode.Decoder._

class DecodeTestSuite extends Specification {

  "The '/download/images%E2%82%AC/fromage+pat%C3%A9.png' path" should {
    "must be decoded " in {
      decode("/download/images%E2%82%AC/fromage+pat%C3%A9.png") mustEqual "/download/images€/fromage+paté.png"
    }
  }
  
  "The '/download/images/fromage+pat%C3%A9%E2%82%AC.png' path" should {
    "must be decoded " in {
      decode("/download/images/fromage+pat%C3%A9%E2%82%AC.png") mustEqual "/download/images/fromage+paté€.png"
    }
  }
  
   "The '/download/images/fromage+pat%C3%A9.png' path" should {
    "must be decoded " in {
      decode("/download/images/fromage+pat%C3%A9.png") mustEqual "/download/images/fromage+paté.png"
    }
  }
  
  "The '%C3%A9' character" should {
    "must be decoded " in {
      decodeBytes(List("C3","A9"))  mustEqual "é"
    }
  }
  
  
   "The '%E2%82%AC' character" should {
    "must be decoded " in {
       decodeBytes(List("E2","82","AC")) mustEqual "€"
    }
  }
}