package teste

import akka.actor.ActorSystem
import colossus.IOSystem
import colossus.core.InitContext
import colossus.protocols.http.server.{HttpServer, Initializer}
import routers.HttpRouterHandler


object PasswordValidate extends App {
    implicit val actorSystem = ActorSystem()
    implicit val ioSystem = IOSystem()
    HttpServer.start("server", 9000) {
        context => new HandlerInitializer(context)
    }
}

class HandlerInitializer(context: InitContext) extends Initializer(context) {
    override def onConnect = context =>
        new HttpRouterHandler(context)
}
