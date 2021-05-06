import scala.annotation.tailrec
object Main {

  @tailrec
  def series(n: Int, acc: Int): Int = {
    if (n == 0) {
      acc
    } else {
      series(n - 1, acc + n)
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


  /**
   * 02章上級課題
   */
  def isSorted[E](sortedSeq: Seq[E])(orderd: (E, E) => Boolean): Boolean = {
    var i = 1
    while (i < sortedSeq.length && orderd(sortedSeq(i - 1), sortedSeq(i))) {
      i = i + 1
    }
    if (i == sortedSeq.length) true
    else false
  }

  /**
   * 02章上級課題　模範回答
   */
  def isSorted2[E](sortedSeq: Seq[E])(isOrdered: (E, E) => Boolean): Boolean = {
    @tailrec
    def isSortedRecursive(i: Int): Boolean = {
      if (i == sortedSeq.length - 1) true
      else if (!isOrdered(sortedSeq(i), sortedSeq(i + 1))) false
      else isSortedRecursive(i + 1)
    }
    if(sortedSeq.length == 0) true else isSortedRecursive(0)
  }

  /**
   * 03章初級課題
   */
  def syokyuKadai03(): Option[Int] = {
    val v1: Option[Int] = Some(2)
    val v2: Option[Int] = Some(3)
    val v3: Option[Int] = Some(5)
    val v4: Option[Int] = Some(7)
    val v5: Option[Int] = Some(11)

    for {
      i1 <- v1
      i2 <- v2
      i3 <- v3
      i4 <- v4
      i5 <- v5
    } yield  i1 * i2 * i3 * i4 * i5
  }

  /**
   * 03章中級課題
   */
  def chukyuKadai03(x: Int): Option[Int] = {
    val f1: Option[Int => Int] = Some((x) => x * 2)
    val f2: Option[Int => Int] = Some((x) => x + 10)
    val f3: Option[Int => Int] = Some((x) => x / 3)
    for {
      i1 <- f1
      i2 <- f2
      i3 <- f3
    } yield i3(i2(i1(x)))
  }
}

