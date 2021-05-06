import scala.annotation.tailrec
object Main {

  @tailrec
  def series(n: Int, acc: Int): Int = {
    if (n == 0) {
      acc
    } else {
      series(n-1, acc + n)
    }
  }

  /**
   * 01章初級課題
   */
  @tailrec
  def fact(n: Int, acc: Int): Int = if (n <= 1) acc else fact(n - 1, acc * n)

  /**
   * 01章中級課題
   */

  case class Switch(isOn: Boolean)
  def toggle(switch: Switch): Switch = {
    if (switch.isOn) Switch(false) else Switch(true)
  }

  /**
   * 01章上級課題
   */
  def twice(f: Int => Int): Int => Int = (x) => f(f(x))
  def twice_another(f: Int => Int): Int => Int = f.compose(f)
}
