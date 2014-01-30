package decode

import org.specs2.mutable._
import com.lunatech.urldecode.Decoder._

import java.net.URISyntaxException

class DecodeTestSuite extends Specification {

  "The decoder " should {
    " let the normal strings unchanged" in {
      decode2("Just a normal string") mustEqual "Just a normal string"
    }
  }

  "The decoder " should {
    " decode the path of an url and replace %-hexadecimal encoded characters " in {
      decode2("/download/images%E2%82%AC/fromage+pat%C3%A9.png") mustEqual "/download/images€/fromage+paté.png"
    }
  }

  "The decoder " should {
    " should throw an exception for incorrect %-hexadecimal " in {
      decode2("/download/images/fromage+pat%HQ.png") must throwA[URISyntaxException]
    }
  }

  "The decoder " should {
    " replace '%25' %-hexadecimal by % " in {
      decode2("%25") mustEqual "%"
    }
  }
  
  
  "The decoder " should {
    " should throw an exception for %QQ " in {
      decode2("%QQ") must throwA[URISyntaxException]
    }
  }
  
  "The decoder " should {
    " should throw an exception for % " in {
      decode2("%") must throwA[URISyntaxException]
    }
  }
}