object TypeClassStudy extends App{
  /**
   * 08章初級課題
   */
  implicit class RichString(val src: String){
    def twice: String = src + src
  }
  println("hello".twice)

  /**
   * 08章中級課題
   */
  implicit class RichInt(val src: Int){
    def takeRight(n: Int): Int = {
      src.toString.takeRight(n).toInt
    }
  }
  println(123423423.takeRight(5))

  /**
   * 08章上級課題
   */
  trait Additive[A] {
    def plus(a: A, b: A): A

    def zero: A
  }
  case class Point(x: Double, y: Double)

  object Point {
    implicit object PointAdditive extends Additive[Point] {
      def plus(a: Point, b: Point): Point = {
        if (a == zero){
          b
        }else if (b == zero) {
          a
        } else {
          Point(a.x + b.x, a.y + b.y)
        }
      }

      def zero: Point = Point(0, 0)
    }
  }
  def sum[A](lst: List[A])(implicit m: Additive[A]): A = lst.foldLeft(m.zero)((x, y) => m.plus(x, y))
}
