sealed trait LoginError
case object InvalidPassword extends LoginError
case object UserNotFound extends LoginError
case object PasswordLocked extends LoginError

case class User(id: Long, name:String, password: String)

object LoginService {
  def login(name: String, password: String): Either[LoginError, User] = {
    (name, password) match {
      case ("taro", "Password1") => Right(User(1, name, password))
      case ("taro", _) => Left(InvalidPassword)
      case (_, _) => Left(UserNotFound)
    }
  }
}
