package mud

class Player(var name: String, private var inv: List[Item], var pos: Location) {
	def getInventory(): String = {
		var y = "Inventory:\n "
		for (item <- inv) {
			y += "[" + item.name + "] "
		}
    if (y == "Inventory:\n ") {
      y += "[Empty]"
    }
    y
  }
}

object Player {
  
  def processCommand(cmd: String): Unit = {

  }
}