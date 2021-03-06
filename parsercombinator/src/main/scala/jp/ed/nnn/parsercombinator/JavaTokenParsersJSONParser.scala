package jp.ed.nnn.parsercombinator

/**
 * 12章 中級課題
 */

import scala.util.parsing.combinator.JavaTokenParsers

object JavaTokenParsersJSONParser extends JavaTokenParsers{

  def obj: Parser[Map[String, Any]]  =
    "{" ~> repsep(member, ",") <~ "}" ^^ { Map() ++ _ }

  def arr: Parser[List[Any]] =
    "[" ~> repsep(value, ",") <~ "]"

  def member: Parser[(String, Any)] =
    stringLiteral ~ ":" ~ value ^^ { t => (t._1._1, t._2) }

  def value: Parser[Any] =
    obj |
      arr |
      stringLiteral |
      (floatingPointNumber ^^ { _.toDouble }) |
      "null" ^^  { _ => null } |
      "true" ^^  { _ => true } |
      "false" ^^  { _ => false }

  def apply(input: String): Any = parseAll(value, input) match {
    case Success(result, _) => result
    case failure: NoSuccess => scala.sys.error(failure.msg)
  }

}
