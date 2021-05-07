import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class NumberFormatterSpec extends AnyFlatSpec with Diagrams{

  "format" should "入力された数値を3桁ごとにカンマ区切りをいれることができる" in {
    assert(NumberFormatter.format(0) === "0")
    assert(NumberFormatter.format(10) === "10")
    assert(NumberFormatter.format(100) === "100")
    assert(NumberFormatter.format(1000) === "1,000")
    assert(NumberFormatter.format(1000000) === "1,000,000")
    assert(NumberFormatter.format(-1) === "-1")
    assert(NumberFormatter.format(-10) === "-10")
    assert(NumberFormatter.format(-100) === "-100")
    assert(NumberFormatter.format(-1000) === "-1,000")
  }

}