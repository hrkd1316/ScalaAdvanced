import scala.annotation.tailrec

/**
 * 06章初級課題
 */

object ListOperation extends App{
  def filter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil:List[T]){(x, y) => if(f(y)) y :: x else x}.reverse
  }

  /**
   * 06章中級課題
   * ギブアップしたやつ　模範回答
   */
  def flatten(list: List[_]): List[Any] = list match {
    case Nil => Nil
    case (x: List[_]) :: xs => flatten(x) ++ flatten(xs)
    case x :: xs => x :: flatten(xs)
  }

  /**
   * 06章上級課題
   * */
  def split[A](n: Int, list: List[A]): (List[A], List[A]) = {
    val list1 = list.foldLeft(Nil: List[A]){(x, y) => if(x.length < n) y :: x else x}.reverse
    val list2 = list.foldRight(Nil: List[A]){(y, x) => if(x.length < list.length - n) y :: x else x}.reverse
    (list1, list2)
  }
  /**
   * 06章上級課題 模範回答
   * */
  def split[A](n: Int, list: List[A]): (List[A], List[A]) = {
    @tailrec
    def splitRec(index: Int, take: List[A], rest: List[A]): (List[A], List[A]) =
      (index, rest) match {
        case (_, Nil) => (take.reverse, Nil)
        case (0, list) => (take.reverse, rest)
        case (i, x::xs) => splitRec(i - 1, x::take, xs)
      }
    splitRec(n, Nil, list)
  }
}
