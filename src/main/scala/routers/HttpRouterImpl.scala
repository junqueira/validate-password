package routers
import config.Environment


object HttpRouterImpl {

    private def buildLogPattern() = {
        """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^&+=])(?=\S+$)$""".r
    }

    def validatePassword(password: String): Boolean = {
        applyPasswordValidation(password)
    }

    private def verifyQuantityChar(password: String): Boolean = {
        var validate = true
        if (password.length < 9)
            validate = false
        validate
    }

    private def verifyDuplicateChar(password: String): Boolean = {
        var validate = true
        password.foreach(p => {
            if (password.count(_ == p) > 1)
                validate = false
        })
        validate
    }

    private def applyPasswordValidation(password: String): Boolean = {
        val PATTERN = buildLogPattern()
        val first = PATTERN.findFirstMatchIn(password) match {
            case Some(_) => true
            case None => false
        }
        val second = verifyQuantityChar(password)
        val third = verifyDuplicateChar(password)
        (first & second & third)
    }
}
