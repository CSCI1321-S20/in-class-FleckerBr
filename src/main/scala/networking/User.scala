package networking

import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream

class User(name: String, sock: Socket, in: BufferedReader, out: PrintStream)