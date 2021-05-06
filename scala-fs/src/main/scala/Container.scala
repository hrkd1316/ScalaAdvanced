/**
 *2章中級課題
 */
class Container[+T](n: T) {
  def put[E >: T](a: E): Container[E] = new Container(a)
  def get[E >: T](): E = n
}
