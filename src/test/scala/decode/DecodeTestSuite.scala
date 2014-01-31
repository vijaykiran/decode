package decode

import org.specs2.mutable._
import com.lunatech.urldecode.DecoderBis._

import java.net.URISyntaxException

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
    " should throw an exception for incorrect %-hexadecimal " in {
      decode("/download/images/fromage+pat%HQ.png") must throwA[IllegalArgumentException]
    }
  }

  "The decoder " should {
    " replace '%25' %-hexadecimal by % " in {
      decode("%25") mustEqual "%"
    }
  }
  
  
  "The decoder " should {
    " should throw an exception for %QQ " in {
      decode("%QQ") must throwA[IllegalArgumentException]
    }
  }
  
  "The decoder " should {
    " should throw an exception for % " in {
      decode("%") must throwA[IllegalArgumentException]
    }
  }
}