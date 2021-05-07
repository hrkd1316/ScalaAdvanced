/**
 * 09章 初級課題
 */
object NumberFormatter extends App{

  def format(number: Int): String = {

    val natural = if(number < 0) -number else number
    val reversed: String = natural.toString.reverse
    val indexedSeq: Seq[(Char, Int)] = reversed.zipWithIndex
    val nestedSeq: Seq[Seq[Char]] = indexedSeq.map(
      (t) => if (t._2 % 3 == 2 && t._2 < indexedSeq.length - 1) {
        Seq(t._1, ',')
      } else {
        Seq(t._1)
      })
    (if(number < 0) "-" else "") + (nestedSeq.flatten.reverse.mkString)
  }

}
