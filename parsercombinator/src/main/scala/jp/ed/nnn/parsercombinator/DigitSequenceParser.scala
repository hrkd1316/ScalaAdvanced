package jp.ed.nnn.parsercombinator

/**
 * 11章上級課題
 */
case class DigitSequence(seq: Seq[String])

object DigitSequenceParser extends MyFirstCombinator {

  def digit: Parser[String] = oneOf('0' to '9')

  def apply(input: String): ParseResult[DigitSequence] =
    map(rep(digit), {list: List[String] => DigitSequence(list)})(input)
}
