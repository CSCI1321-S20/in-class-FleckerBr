package networking

import akka.actor.Actor
import akka.actor.Props
import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream

class ChatManager extends Actor {
    import ChatManager._
    def receive = {
        case NewUser(name, sock, in, out) =>
            context.actorOf(Props(new User(name, sock, in, out)), name)
        case CheckAllInputs =>
            for(child <- context)
        case m => println("Unhandeld Message in ChatManager...")
    }
}

object ChatManager {
    case class NewUser(name: String, sock: Socket, in: BufferedReader, out: PrintStream)
    case object CheckAllInputs
}