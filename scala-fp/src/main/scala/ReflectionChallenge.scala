import scala.reflect.runtime.universe.{TermName, runtimeMirror, typeTag}

/**
 * 10章中級課題　ギブアップ
 */

class Issue(private val title: String) {
  private def printTitle(): Unit = println(title)
}

object ReflectionChallenge extends App {
  val issue = new Issue("不具合1")

  val mirror = runtimeMirror(issue.getClass.getClassLoader)
  val instanceMirror = mirror.reflect(issue)
  val printTitleMethod = typeTag[Issue].tpe.decl(TermName("printTitle")).asMethod
  instanceMirror.reflectMethod(printTitleMethod).apply()
}
