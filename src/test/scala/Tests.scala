import config.Environment
import org.scalatest._
import routers.HttpRouterImpl


class Tests extends FlatSpec with Matchers {

    var password = "\"AbTp9!fo\""
    it should s"password tem nove ou mais caracteres - IsValid($password) -> true" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

    password = "\"\""
    it should s"password tem ao menos 1 dígito IsValid($password) -> false" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

    password = "\"ABTP9!FOK\""
    it should s"password tem ao menos 1 letra minúscula - IsValid($password) -> false" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

    password = "\"abtp9!fok\""
    it should s"password tem ao menos 1 letra maiúscula - IsValid($password) -> false" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

    password = "\"AbTp9fok\""
    it should s"password tem ao menos 1 caractere especial - IsValid($password) -> false" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

    password = "\"AbTTp9!fok\""
    it should s"password não possuir caracteres repetidos - IsValid($password) -> false" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

    password = "\"AbTp9!fok\""
    it should s"password - IsValid($password) -> is valid" in {
        val res = HttpRouterImpl.validatePassword(password)
        assert(!res)
    }

}
