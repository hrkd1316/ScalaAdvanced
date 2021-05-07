/**
 * 07章初級課題
 */
//val tribs: Stream[Int] = 0 #:: 0 #:: 1 #:: tribs.zip(tribs.tail).map{n => n._1 + n._2}.zip(tribs.tail.tail).map{n => n._1 + n._2}
//tribs.take(15).foreach(println)

/**
 * 07章中級課題 ギブアップ 模範回答
 * - Streamの実装(遅延評価の部分のみ)
 * 07章上級課題
 * - Streamの一度計算した値を再計算しない仕様の実装
 * */
trait StreamStudy[+A] {
  def headOption: Option[A] = {
    this match {
      case EmptyStream => None
      case Cons(h, t) => Some(h())
    }
  }
  
  def tail: StreamStudy[A] = this match {
    case EmptyStream => throw new NoSuchMethodError()
    case Cons(h, t) => t()
  }
}

case object EmptyStream extends StreamStudy[Nothing]

case class Cons[+A](h: () => A, t: () => StreamStudy[A]) extends StreamStudy[A]

object StreamStudy extends App{
  
  def cons[A](h: => A, t: => StreamStudy[A]): StreamStudy[A] = {
    lazy val head = h
    lazy val tail = t
    Cons(() => head, () => tail)
  }

  def empty[A]: StreamStudy[A] = EmptyStream
}
