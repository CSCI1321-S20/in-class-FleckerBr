package mud

object Main {
	def main(args: Array[String]): Unit = {

        Location.readLocations()

        println("What would you like your name to be?")
        val playerName = readLine().trim()
        var players = List(new Player(playerName, List(new Item("Unidentified Scrap","An unknown type of scrap metal.")), Location.locations(0)))
        
        println(players(0).name)
        println(players(0).pos.description())

        var playerInput = ""
        while(playerInput.toLowerCase() != "exit"){
            println("What would you like to do?")
            playerInput = readLine().trim()
            
            //playerInput.split(" +", 2)

            if (playerInput.toLowerCase() == "help") {
                println("press space to jump")
            }
            else if (playerInput.toLowerCase() == "inv"){
                println(players(0).getInventory())
            }
        }
    }
}