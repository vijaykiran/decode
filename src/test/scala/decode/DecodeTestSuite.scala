package decode

import org.specs2.mutable._
import com.lunatech.urldecode.Decoder._

class DecodeTestSuite extends Specification {

  "The decoder " should {
    " let the normal strings unchanged" in {
      decode("Just a normal string") mustEqual "Just a normal string"
    }
  }

  "The decoder " should {
    " decode the path of an url and replace %-hexadecimal encoded characters " in {
      decode("/download/images%E2%82%AC/fromage+pat%C3%A9.png") mustEqual "/download/images€/fromage+paté.png"
    }
  }

  "The decoder " should {
    " let incorrect %-hexadecimal encoded characters unchanged" in {
      decode("/download/images/fromage+pat%HQ.png") mustEqual "/download/images/fromage+pat%HQ.png"
    }
  }

  "The decoder " should {
    " replace '%C3%A9' %-hexadecimal by é " in {
      decodeBytes(List("C3", "A9")) mustEqual "é"
    }
  }

  "The decoder " should {
    " replace '%E2%82%AC' %-hexadecimal by é " in {
      decodeBytes(List("E2", "82", "AC")) mustEqual "€"
    }
  }

}