object Benchmark {

  def benchmark(f: => Unit) = {
    val begin = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()
    val formatter = java.text.NumberFormat.getNumberInstance()
    println(s"time: ${formatter.format(end - begin)} ミリ秒")
  }

  def benchmarkNano(f: => Unit) = {
    val begin = System.nanoTime()
    f
    val end = System.nanoTime()
    val formatter = java.text.NumberFormat.getNumberInstance()
    println(s"time: ${formatter.format(end - begin)} ナノ秒")
  }
  /**
   * 05章初級課題
   */
  benchmark {
    val backList = List[Int]()
    for (i <- 0 to 10000) backList :+ i
  }
  benchmark {
    val backArray = Array[Int]()
    for (i <- 0 to 10000) backArray :+ i
  }
  benchmark {
    val frontList = List[Int]()
    for (i <- 0 to 10000) i +: frontList
  }
  benchmark {
    val frontArray = Array[Int]()
    for (i <- 0 to 10000) i +: frontArray
  }

  /**
   * 05章中級課題
   */
  val bigList = (1 to 10000000).toList
  val bigArray = (1 to 10000000).toArray
  benchmarkNano(bigList(9999999))
  benchmarkNano(bigArray(9999999))

  /**
   * 05章上級課題
   */
  benchmarkNano((1 to 100000).toArray)
  benchmarkNano(scala.collection.immutable.HashMap((1 to 100000).map(i => i -> i): _*))
  benchmarkNano(scala.collection.immutable.TreeMap((1 to 100000).map(i => i -> i): _*))
}
